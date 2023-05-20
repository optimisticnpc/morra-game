package nz.ac.auckland.se281.strategies;

import java.util.List;
import nz.ac.auckland.se281.Utils;

public abstract class Strategy {

  public int generateFinger() {
    return Utils.getRandomNumber(1, 5);
  }

  // TODO: Think about this
  public abstract int generateSum(int fingers, int roundNumber, List<Integer> numbersPlayed);
}
