package nz.ac.auckland.se281.GameDifficulties;

import java.util.List;

import nz.ac.auckland.se281.Strategies.RandomStrategy;

public class Medium  implements Difficulties{

    public static int generateFinger() {
        return RandomStrategy.generateFinger();
	}

	public static int generateSum(int fingers, int roundNumber, List<Integer> numbersPlayed) {
        if (roundNumber < 4) {
            return RandomStrategy.generateSum(fingers);
        }

        double total = 0;
        for (int i = 0; i < numbersPlayed.size(); i++) {
            total = total + numbersPlayed.get(i);
          }


        // Calculate average, use round number of previous round since we do not know the number in this round
        // TODO: why (int) needed?
        int average = (int) Math.round(total/(roundNumber-1));
        
        return fingers + average;  
	}

    
    
}
