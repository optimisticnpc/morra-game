package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;
import nz.ac.auckland.se281.Strategies.RandomStrategy;

public class Morra {

  private String name;
  private int roundNumber;
  private String stringHumanFingers;
  private String stringHumanSum;
  private int humanPoints;
  private int jarvisPoints;
  private int pointsToWin;


  public Morra() {}

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    // TODO: UM WHAT???
    name = options[0];
    MessageCli.WELCOME_PLAYER.printMessage(name);
    this.pointsToWin = pointsToWin;
    humanPoints = 0;
    jarvisPoints = 0;
    roundNumber = 1;
    return;
    
  }

  

  public void play() {
    // Convert round number to string and display
    String roundNumberString = String.valueOf(roundNumber);
    MessageCli.START_ROUND.printMessage(roundNumberString);
    MessageCli.ASK_INPUT.printMessage();
  
    // TODO: Is the naming of this ok?
    boolean isValidInput =  readAndCheckFingersAndSum();
    
    // Iif it is not valid print error messages and ask for input again
    while (!isValidInput) {
      MessageCli.INVALID_INPUT.printMessage();
      MessageCli.ASK_INPUT.printMessage();

    isValidInput =  readAndCheckFingersAndSum();
    }

    // TODO: is it okay to use variable declared at the top
    // Once it is a valid input print out the message 
    MessageCli.PRINT_INFO_HAND.printMessage(name, stringHumanFingers, stringHumanSum);

    // Generate and display AI ouput
    int jarvisFingers = RandomStrategy.generateFinger();
    int jarvisSum = RandomStrategy.generateSum(jarvisFingers);

    MessageCli.PRINT_INFO_HAND.printMessage("Jarvis", String.valueOf(jarvisFingers), String.valueOf(jarvisSum));

    int humanFingers = Integer.parseInt(stringHumanFingers);
    int humanSum = Integer.parseInt(stringHumanSum);
    
    boolean isHumanCorrect = (humanSum == humanFingers + jarvisFingers);
    boolean isJarvisCorrect = (jarvisSum == humanFingers + jarvisFingers);

    if (isHumanCorrect && !isJarvisCorrect ){
       MessageCli.PRINT_OUTCOME_ROUND.printMessage("HUMAN_WINS");
    } else if (isJarvisCorrect && !isHumanCorrect){
        MessageCli.PRINT_OUTCOME_ROUND.printMessage("AI_WINS");
    } else {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
    }

    roundNumber++;
    return;
    
  }

  public void showStats() {}


  private boolean readAndCheckFingersAndSum () {
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
    &&  Integer.parseInt(stringHumanFingers) > 0 
    && Integer.parseInt(stringHumanFingers) <= 5 
    && Integer.parseInt(stringHumanSum) >= 1
    && Integer.parseInt(stringHumanSum) <= 10;

  }
}
