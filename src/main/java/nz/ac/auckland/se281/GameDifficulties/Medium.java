package nz.ac.auckland.se281.gamedifficulties;

import nz.ac.auckland.se281.strategies.Average;

public class Medium extends AiBot {

  @Override
  public void setStrategy(int roundNumber) {
    if (roundNumber > 3) {
      this.strategy = new Average();
    }
  }
}
