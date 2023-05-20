package nz.ac.auckland.se281.strategies;

import nz.ac.auckland.se281.Utils;

public abstract class Strategy {

  public int generateFinger() {
    return Utils.getRandomNumber(1, 5);
  }

  public abstract int generateSum(int fingers);
}
