package nz.ac.auckland.se281.Strategies;

import java.util.List;

public class Top implements Strategies {

    public static int useTopStrategy(int fingers, int roundNumber, List<Integer> numbersPlayed)
    {
        int currentMostCommonNumber = -1;

        int countOfCurrentMostCommonNumber = 0;

        int numberCount = 0;
        
        // Finds the value of the most common number
        // If there are more than one if finds the alst oen in the arraylist
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
