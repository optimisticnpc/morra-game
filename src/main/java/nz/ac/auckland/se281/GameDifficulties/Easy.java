package nz.ac.auckland.se281.GameDifficulties;

import java.util.List;
import nz.ac.auckland.se281.Strategies.Random;

public class Easy implements Difficulties {

  @Override
  public int generateFingers() {
    return Random.generateFinger();
  }

  @Override
  public int generateSum(int fingers, int roundNumber, List<Integer> numbersPlayed) {
    return Random.generateSum(fingers);
  }
}
