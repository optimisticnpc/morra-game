package nz.ac.auckland.se281.aibotdifficulties;

import nz.ac.auckland.se281.strategies.Average;
import nz.ac.auckland.se281.strategies.Top;

public class Master extends AiBot {

  @Override
  public void chooseStrategy(int roundNumber) {
    // If the round number is greater than 3 start alternating between the Average and Top
    // strategies
    if (roundNumber > 3) {
      if (roundNumber % 2 == 0) {
        setStrategy(new Average());
      } else if (roundNumber % 2 == 1) {
        setStrategy(new Top());
      }
    }
  }
}
