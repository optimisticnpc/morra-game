package nz.ac.auckland.se281.strategies;

import java.util.List;

public class Average extends Strategy {

  public int generateSum(int fingers, int roundNumber, List<Integer> numbersPlayed) {
    double total = 0;
    for (int i = 0; i < numbersPlayed.size(); i++) {
      total = total + numbersPlayed.get(i);
    }

    // Calculate average, use round number of previous round since we only have the numbers for the
    // previous round
    int average = (int) Math.round(total / (roundNumber - 1));

    return fingers + average;
  }
}
