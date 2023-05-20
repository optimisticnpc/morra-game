package nz.ac.auckland.se281.aibotdifficulties;

import nz.ac.auckland.se281.strategies.AverageStrategy;

public class MediumBot extends AiBot {

  @Override
  public void chooseStrategy(int roundNumber) {
    if (roundNumber > 3) {
      setStrategy(new AverageStrategy());
    }
  }
}
