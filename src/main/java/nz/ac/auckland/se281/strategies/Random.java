package nz.ac.auckland.se281.strategies;

import java.util.List;
import nz.ac.auckland.se281.Utils;

public class Random implements Strategy {

  public int generateFinger() {
    return Utils.getRandomNumber(1, 5);
  }

  public int generateSum(int fingers, int roundNumber, List<Integer> numbersPlayed) {
    // Return the sum which is a equal to fingers plus a random number between 1 and 5
    return fingers + Utils.getRandomNumber(1, 5);
  }
}
