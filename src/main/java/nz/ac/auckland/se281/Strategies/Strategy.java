package nz.ac.auckland.se281.strategies;

import java.util.List;

public interface Strategy {
  public int generateFinger();

  public int generateSum(int fingers, int roundNumber, List<Integer> numbersPlayed);
}
