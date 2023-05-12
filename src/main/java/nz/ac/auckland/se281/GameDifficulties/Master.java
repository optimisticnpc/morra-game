package nz.ac.auckland.se281.GameDifficulties;

import java.util.List;
import nz.ac.auckland.se281.Strategies.Average;
import nz.ac.auckland.se281.Strategies.Random;
import nz.ac.auckland.se281.Strategies.Top;

public class Master implements Difficulties {

  @Override
  public int generateFingers() {
    return Random.generateFinger();
  }

  @Override
  public int generateSum(int fingers, int roundNumber, List<Integer> numbersPlayed) {
    if (roundNumber < 4) {
      return Random.generateSum(fingers);
    }

    if (roundNumber % 2 == 0) {
      return Average.useAverageStrategy(fingers, roundNumber, numbersPlayed);
    }
    return Top.useTopStrategy(fingers, roundNumber, numbersPlayed);
  }
}
