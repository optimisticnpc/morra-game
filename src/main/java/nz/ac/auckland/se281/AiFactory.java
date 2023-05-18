package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;
import nz.ac.auckland.se281.aibotdifficulties.AiBot;
import nz.ac.auckland.se281.aibotdifficulties.Easy;
import nz.ac.auckland.se281.aibotdifficulties.Hard;
import nz.ac.auckland.se281.aibotdifficulties.Master;
import nz.ac.auckland.se281.aibotdifficulties.Medium;

public class AiFactory {

  public static AiBot createAiBot(Difficulty difficulty) {
    // Return an ai bot for the specified difficulty

    switch (difficulty) {
      case EASY:
        return new Easy();

      case MEDIUM:
        return new Medium();

      case HARD:
        return new Hard();

      case MASTER:
        return new Master();

      default:
        return null;
    }
  }
}
