package nz.ac.auckland.se281.strategies;

import java.util.List;

public class AverageStrategy extends Strategy {

  private List<Integer> numbersPlayed;
  private int roundNumber;

  public AverageStrategy(int roundNumber, List<Integer> numbersPlayed) {
    this.numbersPlayed = numbersPlayed;
    this.roundNumber = roundNumber;
  }

  public int generateSum(int fingers) {
    double total = 0;
    for (int i = 0; i < roundNumber; i++) {
      total = total + numbersPlayed.get(i);
    }

    // Calculate average, use round number of previous round since we only have the numbers for the
    // previous round
    int average = (int) Math.round(total / (roundNumber - 1));

    return fingers + average;
  }
}
