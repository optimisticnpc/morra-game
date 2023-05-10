package nz.ac.auckland.se281.GameDifficulties;

import nz.ac.auckland.se281.Strategies.RandomStrategy;

public class Easy implements Difficulties{


	public static int generateFinger() {
		return RandomStrategy.generateFinger();
	}

	public static int generateSum(int fingers) {
		return RandomStrategy.generateSum(fingers);
	}
    
}
