package nz.ac.auckland.se281.gamedifficulties;

import java.util.List;
import nz.ac.auckland.se281.strategies.Random;
import nz.ac.auckland.se281.strategies.Strategy;

public abstract class AiBot {

  private Strategy strategy;

  public AiBot() {
    // Every difficulty starts with the random strategy
    this.strategy = new Random();
  }

  public void chooseStrategy(int roundNumber) {}

  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  public int generateFinger() {
    return strategy.generateFinger();
  }

  // TODO: Is there a problem to have extra inputs
  public int generateSum(int fingers, int roundNumber, List<Integer> numbersPlayed) {
    return strategy.generateSum(fingers, roundNumber, numbersPlayed);
  }
}
