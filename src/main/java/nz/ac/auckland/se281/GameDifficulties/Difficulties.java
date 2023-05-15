package nz.ac.auckland.se281.gamedifficulties;

import java.util.List;
import nz.ac.auckland.se281.strategies.Random;
import nz.ac.auckland.se281.strategies.Strategy;

public abstract class Difficulties {

  protected Strategy strategy;

  public Difficulties() {
    this.strategy = new Random();
  }

  public void setStrategy(int roundNumber) {}

  public int generateFinger() {
    return strategy.generateFinger();
  }

  public int generateSum(int fingers, int roundNumber, List<Integer> numbersPlayed) {
    return strategy.generateSum(fingers, roundNumber, numbersPlayed);
  }
}
