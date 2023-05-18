package nz.ac.auckland.se281.aibotdifficulties;

import nz.ac.auckland.se281.strategies.Average;

public class Medium extends AiBot {

  @Override
  public void chooseStrategy(int roundNumber) {
    if (roundNumber > 3) {
      setStrategy(new Average());
    }
  }
}
