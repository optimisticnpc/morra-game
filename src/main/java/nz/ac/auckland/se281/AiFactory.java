package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;
import nz.ac.auckland.se281.gamedifficulties.AiBot;
import nz.ac.auckland.se281.gamedifficulties.Easy;
import nz.ac.auckland.se281.gamedifficulties.Hard;
import nz.ac.auckland.se281.gamedifficulties.Master;
import nz.ac.auckland.se281.gamedifficulties.Medium;

public class AiFactory {

  public static AiBot createAiBot(Difficulty difficulty) {
    // Return an ai bot for the specified difficulty
    // TODO: fix this error
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
