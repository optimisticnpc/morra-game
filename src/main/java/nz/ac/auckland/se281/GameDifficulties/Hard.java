package nz.ac.auckland.se281.GameDifficulties;

import java.util.List;
import nz.ac.auckland.se281.Strategies.Random;
import nz.ac.auckland.se281.Strategies.Top;

public class Hard implements Difficulties {

  public static int generateFinger() {
    return Random.generateFinger();
  }

  public static int generateSum(int fingers, int roundNumber, List<Integer> numbersPlayed) {
    if (roundNumber < 4) {
      return Random.generateSum(fingers);
    }

    return Top.useTopStrategy(fingers, roundNumber, numbersPlayed);
  }
}
