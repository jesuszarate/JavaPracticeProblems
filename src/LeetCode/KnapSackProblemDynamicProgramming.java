package LeetCode;

import java.util.HashMap;

/**
 * Created by jesuszarate on 7/25/17.
 */
public class KnapSackProblemDynamicProgramming {

    public static void main(String[] a){
        int[] weights = { 6, 3, 4, 2 };
        int[] values = { 30, 14, 16, 9 };
        System.out.println( KS(weights, values, 10) );
    }

    static HashMap<Integer, Integer> weightVals = new HashMap<>();
    static int KS(int[] weightList, int[] valueList, int sackWeight){

        if(sackWeight <= 0) return 0;

        if( weightVals.containsKey(sackWeight) ) return weightVals.get(sackWeight);

        int max = Integer.MIN_VALUE;

        for(int i = 0; i < weightList.length; i++){

            if ( weightList[i] <= sackWeight ) {
                int val = valueList[i] + KS(weightList, valueList, sackWeight - weightList[i]);

                max = Math.max(val, max);
            }
        }
        weightVals.put(sackWeight, max);
        return max;
    }
}
