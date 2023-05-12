package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;
import nz.ac.auckland.se281.GameDifficulties.Difficulties;
import nz.ac.auckland.se281.Main.Difficulty;

public class Morra {

  private String name;
  private int roundNumber = -1;
  private String stringHumanFingers;
  private String stringHumanSum;
  private int humanPoints;
  private int jarvisPoints;
  private int pointsToWin;
  private Difficulty difficulty;
  private List<Integer> numbersPlayed;

  public Morra() {}

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    numbersPlayed = new ArrayList<>();
    this.difficulty = difficulty;

    this.pointsToWin = pointsToWin;
    name = options[0];
    MessageCli.WELCOME_PLAYER.printMessage(name);

    resetGame();
    roundNumber = 1;
    return;
  }

  public void play() {
    // If round number is not a positive integer we know the a game has not started
    if (roundNumber < 0) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    // Convert round number to string and display
    String roundNumberString = String.valueOf(roundNumber);
    MessageCli.START_ROUND.printMessage(roundNumberString);
    MessageCli.ASK_INPUT.printMessage();

    // TODO: Is the naming of this ok?
    boolean isValidInput = readAndCheckFingersAndSum();

    // If it is not valid print error messages and ask for input again
    while (!isValidInput) {
      MessageCli.INVALID_INPUT.printMessage();
      MessageCli.ASK_INPUT.printMessage();

      isValidInput = readAndCheckFingersAndSum();
    }

    // TODO: is it okay to use variable declared at the top
    // Once it is a valid input print out the message
    MessageCli.PRINT_INFO_HAND.printMessage(name, stringHumanFingers, stringHumanSum);

    int jarvisFingers = 0;
    int jarvisSum = 0;

    Difficulties aiBot = AiFactory.createAiBot(difficulty);
    jarvisFingers = aiBot.generateFingers();
    jarvisSum = aiBot.generateSum(jarvisFingers, roundNumber, numbersPlayed);

    MessageCli.PRINT_INFO_HAND.printMessage(
        "Jarvis", String.valueOf(jarvisFingers), String.valueOf(jarvisSum));

    int humanFingers = Integer.parseInt(stringHumanFingers);
    int humanSum = Integer.parseInt(stringHumanSum);

    boolean isHumanCorrect = (humanSum == humanFingers + jarvisFingers);
    boolean isJarvisCorrect = (jarvisSum == humanFingers + jarvisFingers);

    if (isHumanCorrect && !isJarvisCorrect) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("HUMAN_WINS");
      humanPoints++;
    } else if (isJarvisCorrect && !isHumanCorrect) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("AI_WINS");
      jarvisPoints++;
    } else {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
    }

    // Check if someone has won

    if (humanPoints == pointsToWin) {
      MessageCli.END_GAME.printMessage(name, roundNumberString);
      resetGame();
      return;
    } else if (jarvisPoints == pointsToWin) {
      MessageCli.END_GAME.printMessage("Jarvis", roundNumberString);
      resetGame();
      return;
    }

    // Store number that player played in the arraylist
    numbersPlayed.add(humanFingers);
    roundNumber++;
    return;
  }

  public void showStats() {
    // If round number has not started, show the error message
    if (roundNumber < 0) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    MessageCli.PRINT_PLAYER_WINS.printMessage(
        name, String.valueOf(humanPoints), String.valueOf(pointsToWin - humanPoints));
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        "Jarvis", String.valueOf(jarvisPoints), String.valueOf(pointsToWin - jarvisPoints));
  }

  private boolean readAndCheckFingersAndSum() {
    // Read input from the console
    String input = Utils.scanner.nextLine();

    // Split the input into two individual arguments
    String[] args = input.split(" ");
    stringHumanFingers = args[0];
    stringHumanSum = args[1];

    // Check that number of fingers is between 0 and 5 (inclusive)
    // And that sum is between 1 and 10 (inclusive)

    return Utils.isInteger(stringHumanFingers)
        && Utils.isInteger(stringHumanSum)
        && Integer.parseInt(stringHumanFingers) > 0
        && Integer.parseInt(stringHumanFingers) <= 5
        && Integer.parseInt(stringHumanSum) >= 1
        && Integer.parseInt(stringHumanSum) <= 10;
  }

  private void resetGame() {
    humanPoints = 0;
    jarvisPoints = 0;
    roundNumber = -1;
  }
}
