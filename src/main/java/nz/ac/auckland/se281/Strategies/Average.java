package nz.ac.auckland.se281.Strategies;

import java.util.List;

public class Average implements Strategies {

    public static int useAverageStrategy(int fingers, int roundNumber, List<Integer> numbersPlayed)
    {
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
