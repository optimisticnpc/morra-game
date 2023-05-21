package nz.ac.auckland.se281.aibotdifficulties;

import java.util.List;
import nz.ac.auckland.se281.strategies.AverageStrategy;

public class MediumBot extends AiBot {

  @Override
  public void chooseStrategy(int roundNumber, List<Integer> numbersPlayed) {
    if (roundNumber > 3) {
      setStrategy(new AverageStrategy(numbersPlayed));
    }
  }
}
