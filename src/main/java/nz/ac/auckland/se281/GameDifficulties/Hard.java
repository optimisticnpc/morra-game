package nz.ac.auckland.se281.gamedifficulties;

import nz.ac.auckland.se281.strategies.Top;

public class Hard extends Difficulties {

  @Override
  public void setStrategy(int roundNumber) {
    if (roundNumber > 3) {
      this.strategy = new Top();
    }
  }
}
