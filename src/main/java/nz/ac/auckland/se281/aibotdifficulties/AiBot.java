package nz.ac.auckland.se281.aibotdifficulties;

import java.util.List;
import nz.ac.auckland.se281.strategies.RandomStrategy;
import nz.ac.auckland.se281.strategies.Strategy;

public abstract class AiBot {

  private Strategy strategy;

  public AiBot() {
    // Every difficulty starts with the random strategy
    this.strategy = new RandomStrategy();
  }

  public void chooseStrategy(int roundNumber, List<Integer> numbersPlayed) {}

  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  public int generateFinger() {
    return strategy.generateFinger();
  }

  public int generateSum(int fingers) {
    return strategy.generateSum(fingers);
  }
}
