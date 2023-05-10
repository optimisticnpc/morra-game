package nz.ac.auckland.se281.GameDifficulties;

import java.util.List;

import nz.ac.auckland.se281.Strategies.Average;
import nz.ac.auckland.se281.Strategies.RandomStrategy;

public class Medium  implements Difficulties{

    public static int generateFinger() {
        return RandomStrategy.generateFinger();
	}

	public static int generateSum(int fingers, int roundNumber, List<Integer> numbersPlayed) {
        if (roundNumber < 4) {
            return RandomStrategy.generateSum(fingers);
        }


		return Average.useAverageStrategy(fingers,roundNumber, numbersPlayed);
	}

    
    
}
