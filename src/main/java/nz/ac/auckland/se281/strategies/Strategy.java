package nz.ac.auckland.se281.strategies;

import java.util.List;

public interface Strategy {
  // TODO: should i make an abstract class so the strategies can share a generateFinger
  public int generateFinger();

  public int generateSum(int fingers, int roundNumber, List<Integer> numbersPlayed);
}

