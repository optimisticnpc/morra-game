package nz.ac.auckland.se281.strategies;

import java.util.List;

public class TopStrategy extends Strategy {

  private List<Integer> numbersPlayed;

  public TopStrategy(List<Integer> numbersPlayed) {
    this.numbersPlayed = numbersPlayed;
  }

  public int generateSum(int fingers) {
    int currentMostCommonNumber = -1;

    int countOfCurrentMostCommonNumber = 0;

    int numberCount = 0;

    // Finds the value of the most common number
    // If there two numbers that have been played the same amount of times then
    // our function returns the one that appears first in the list
    for (int i = 0; i < numbersPlayed.size(); i++) {
      int currentNumber = numbersPlayed.get(i);

      for (int j = 0; j < numbersPlayed.size(); j++) {
        if (numbersPlayed.get(j) == currentNumber) {
          numberCount++;
        }
      }

      if (numberCount > countOfCurrentMostCommonNumber) {
        currentMostCommonNumber = currentNumber;
        countOfCurrentMostCommonNumber = numberCount;
      }
      numberCount = 0;
    }

    return fingers + currentMostCommonNumber;
  }
}
