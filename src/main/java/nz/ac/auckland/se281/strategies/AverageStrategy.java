package nz.ac.auckland.se281.strategies;

import java.util.List;

public class AverageStrategy extends Strategy {

  private List<Integer> numbersPlayed;

  public AverageStrategy(List<Integer> numbersPlayed) {
    this.numbersPlayed = numbersPlayed;
  }

  public int generateSum(int fingers) {
    // Loop through the list and sum up the numbers
    double total = 0;
    for (int i = 0; i < numbersPlayed.size(); i++) {
      total = total + numbersPlayed.get(i);
    }

    // Calculate average
    int average = (int) Math.round(total / numbersPlayed.size());

    return fingers + average;
  }
}
