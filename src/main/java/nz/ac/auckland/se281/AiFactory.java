package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;
import nz.ac.auckland.se281.aibotdifficulties.AiBot;
import nz.ac.auckland.se281.aibotdifficulties.EasyBot;
import nz.ac.auckland.se281.aibotdifficulties.HardBot;
import nz.ac.auckland.se281.aibotdifficulties.MasterBot;
import nz.ac.auckland.se281.aibotdifficulties.MediumBot;

public class AiFactory {

  public static AiBot createAiBot(Difficulty difficulty) {
    // Return an ai bot for the specified difficulty

    switch (difficulty) {
      case EASY:
        return new EasyBot();

      case MEDIUM:
        return new MediumBot();

      case HARD:
        return new HardBot();

      case MASTER:
        return new MasterBot();

      default:
        return null;
    }
  }
}
