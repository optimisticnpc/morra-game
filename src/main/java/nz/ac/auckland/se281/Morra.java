package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class Morra {

  // TODO: should this really be []
  private String name;
  private int roundNumber;

  public Morra() {}

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    // TODO: UM WHAT???
    name = options[0];
    MessageCli.WELCOME_PLAYER.printMessage(name);
    roundNumber = 1;
    return;
    
  }

  

  public void play() {
    // Convert round number to string and display
    String roundNumberString = String.valueOf(roundNumber);
    MessageCli.START_ROUND.printMessage(roundNumberString);
    MessageCli.ASK_INPUT.printMessage();
  
    // Read input from the console
    String input = Utils.scanner.nextLine();

    // Split the input into two individual arguments
    String[] args = input.split(" ");
    String stringFingers = args[0];
    String stringSum = args[1];

    
    boolean isValidInput =  checkValidFingersAndSum(stringFingers, stringSum);
    
    // Iif it is not valid print error messages and ask for input again
    while (!isValidInput) {
      MessageCli.INVALID_INPUT.printMessage();
      MessageCli.ASK_INPUT.printMessage();

      // Read input from the console
    input = Utils.scanner.nextLine();

    // Split the input into two individual arguments
    args = input.split(" ");
    stringFingers = args[0];
    stringSum = args[1];

    isValidInput =  checkValidFingersAndSum(stringFingers, stringSum);
    }

    // Once it is a valid input print out the message 
    MessageCli.PRINT_INFO_HAND.printMessage(name, stringFingers, stringSum);
    roundNumber++;
    return;
    
  }

  public void showStats() {}


  private boolean checkValidFingersAndSum (String stringFingers, String stringSum) {
    return Utils.isInteger(stringFingers) 
    && Utils.isInteger(stringSum) 
    &&  Integer.parseInt(stringFingers)>0 
    && Integer.parseInt(stringFingers) <= 6 
    && Integer.parseInt(stringSum) >= 1
    && Integer.parseInt(stringSum) <= 10;

  }
}
