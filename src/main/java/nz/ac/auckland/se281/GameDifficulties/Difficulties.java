package nz.ac.auckland.se281.GameDifficulties;

import java.util.List;

public interface Difficulties {

  public int generateFingers();

  public int generateSum(int fingers, int roundNumber, List<Integer> numbersPlayed);
}
