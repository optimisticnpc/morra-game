package nz.ac.auckland.se281.strategies;

import nz.ac.auckland.se281.Utils;

public class RandomStrategy extends Strategy {

  public int generateSum(int fingers) {
    // Return the sum which is a equal to fingers plus a random number between 1 and 5
    return fingers + Utils.getRandomNumber(1, 5);
  }
}
