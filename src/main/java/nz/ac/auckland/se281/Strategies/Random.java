package nz.ac.auckland.se281.Strategies;

import nz.ac.auckland.se281.Utils;

public class Random implements Strategies {
    
    public static int generateFinger() {
        return Utils.getRandomNumber(1,5);

    } 

    public static int generateSum(int fingers) {
        return fingers + Utils.getRandomNumber(1,5);
    }

}
