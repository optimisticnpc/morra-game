package nz.ac.auckland.se281.aibotdifficulties;

import nz.ac.auckland.se281.strategies.Top;

public class Hard extends AiBot {

  @Override
  public void chooseStrategy(int roundNumber) {
    if (roundNumber > 3) {
      setStrategy(new Top());
    }
  }
}
