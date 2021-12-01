package fr.syalioune.advent.depth;

import java.util.List;

public class DepthMeter {

    public int countIncreases(List<Integer> measures) {
        if(measures == null) {
            throw new IllegalArgumentException("Cannot provide a null value");
        } else if(measures.size() < 4) {
            return 0;
        }
        int count = 0;
        for (int i = 3; i < measures.size(); i++) {
            int firstCount = measures.get(i-3) + measures.get(i-2) + measures.get(i-1);
            int secondCount = measures.get(i-2) + measures.get(i-1) + measures.get(i);
           if(secondCount > firstCount) {
               count++;
           }
        }
        return count;
    }
}
