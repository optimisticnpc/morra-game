package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;
import nz.ac.auckland.se281.Main.Difficulty;
import nz.ac.auckland.se281.aibotdifficulties.AiBot;

public class Morra {

  private String name;
  private int roundNumber = -1;
  private String stringHumanFingers;
  private String stringHumanSum;
  private int humanPoints;
  private int aiPoints;
  private int numPointsToWin;
  private Difficulty difficulty;
  private List<Integer> numbersPlayed;

  public Morra() {}

  public void newGame(Difficulty difficulty, int numPointsToWin, String[] options) {
    numbersPlayed = new ArrayList<>();

    // Set difficulty and number of points to win
    this.difficulty = difficulty;
    this.numPointsToWin = numPointsToWin;

    // Set name and display welcome message
    name = options[0];
    MessageCli.WELCOME_PLAYER.printMessage(name);

    resetGame();
    roundNumber = 1;
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

    boolean isValidInput = readAndCheckFingersAndSum();

    // If it is not valid print error messages and ask for input again
    while (!isValidInput) {
      MessageCli.INVALID_INPUT.printMessage();
      MessageCli.ASK_INPUT.printMessage();

      isValidInput = readAndCheckFingersAndSum();
    }

    // Once it is a valid input print out the message
    MessageCli.PRINT_INFO_HAND.printMessage(name, stringHumanFingers, stringHumanSum);

    int aiFingers;
    int aiSum;

    // Create a new ai bot at the specified difficulty
    // Generate a finger and sum
    AiBot aiBot = AiFactory.createAiBot(difficulty);
    aiBot.chooseStrategy(roundNumber);
    aiFingers = aiBot.generateFinger();
    aiSum = aiBot.generateSum(aiFingers, roundNumber, numbersPlayed);

    MessageCli.PRINT_INFO_HAND.printMessage(
        "Jarvis", String.valueOf(aiFingers), String.valueOf(aiSum));

    int humanFingers = Integer.parseInt(stringHumanFingers);
    int humanSum = Integer.parseInt(stringHumanSum);

    // Check who has made a correct guess
    boolean isHumanCorrect = (humanSum == humanFingers + aiFingers);
    boolean isAiCorrect = (aiSum == humanFingers + aiFingers);

    // Print out result and allocate points
    if (isHumanCorrect && !isAiCorrect) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("HUMAN_WINS");
      humanPoints++;
    } else if (isAiCorrect && !isHumanCorrect) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("AI_WINS");
      aiPoints++;
    } else {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
    }

    // Check if someone has won
    if (humanPoints == numPointsToWin) {
      MessageCli.END_GAME.printMessage(name, roundNumberString);
      resetGame();
      return;
    } else if (aiPoints == numPointsToWin) {
      MessageCli.END_GAME.printMessage("Jarvis", roundNumberString);
      resetGame();
      return;
    }

    // Store number that player played in the arraylist
    numbersPlayed.add(humanFingers);
    roundNumber++;
  }

  public void showStats() {
    // If round number has not started, show the error message
    if (roundNumber < 0) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    // Otherwise display the statistics
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        name, String.valueOf(humanPoints), String.valueOf(numPointsToWin - humanPoints));
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        "Jarvis", String.valueOf(aiPoints), String.valueOf(numPointsToWin - aiPoints));
  }

  private boolean readAndCheckFingersAndSum() {
    // Read input from the console
    String input = Utils.scanner.nextLine();

    // Split the input into two individual arguments
    // Check if there are exactly two arguments, if not return false
    String[] args = input.split(" ");
    if (args.length != 2) {
      return false;
    }

    stringHumanFingers = args[0];
    stringHumanSum = args[1];

    // Check that number of fingers is between 0 and 5 (inclusive)
    // And that sum is between 1 and 10 (inclusive)
    return Utils.isInteger(stringHumanFingers)
        && Utils.isInteger(stringHumanSum)
        && Integer.parseInt(stringHumanFingers) >= 1
        && Integer.parseInt(stringHumanFingers) <= 5
        && Integer.parseInt(stringHumanSum) >= 1
        && Integer.parseInt(stringHumanSum) <= 10;
  }

  private void resetGame() {
    humanPoints = 0;
    aiPoints = 0;
    roundNumber = -1;
  }
}
