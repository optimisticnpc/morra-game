package nz.ac.auckland.se281.strategies;

import java.util.List;
import nz.ac.auckland.se281.Utils;

public class Average implements Strategy {

  public int generateFinger() {
    return Utils.getRandomNumber(1, 5);
  }

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


