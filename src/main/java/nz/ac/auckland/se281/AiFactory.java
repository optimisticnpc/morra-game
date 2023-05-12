package nz.ac.auckland.se281;

import nz.ac.auckland.se281.GameDifficulties.Difficulties;
import nz.ac.auckland.se281.GameDifficulties.Easy;
import nz.ac.auckland.se281.GameDifficulties.Hard;
import nz.ac.auckland.se281.GameDifficulties.Master;
import nz.ac.auckland.se281.GameDifficulties.Medium;
import nz.ac.auckland.se281.Main.Difficulty;

public class AiFactory {

  public static Difficulties createAiBot(Difficulty difficulty) {
    if (difficulty.equals(difficulty.EASY)) {
      return new Easy();

    } else if (difficulty.equals(difficulty.MEDIUM)) {
      return new Medium();

    } else if (difficulty.equals(difficulty.HARD)) {
      return new Hard();

    } else {
      return new Master();
    }
  }
}
