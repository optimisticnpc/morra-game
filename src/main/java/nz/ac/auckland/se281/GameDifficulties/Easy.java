package nz.ac.auckland.se281.GameDifficulties;

import nz.ac.auckland.se281.Strategies.Random;

public class Easy implements Difficulties {

  public static int generateFinger() {
    return Random.generateFinger();
  }

  public static int generateSum(int fingers) {
    return Random.generateSum(fingers);
  }
}
