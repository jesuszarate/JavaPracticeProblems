package LeetCode;

import java.util.HashMap;

/**
 * Created by jesuszarate on 7/10/17.
 */
public class LongestIncreasingSubSequence {

    public static void main(String[] argv){
        int[] arr = {5, 2, 8, 6, 3, 6, 9, 7};

        System.out.println(longestIncreaingSubsequence(arr));
    }

    public static int longestIncreaingSubsequence(int[] arr) {
        HashMap<Integer, Integer> m = new HashMap<>();

        // i = 5
        // j = 6
        // while 6 < 8
        // max = 0;
        int max = 0;
        for (int i = arr.length - 1; i >= 0; i--) {

            for (int j = i + 1; j < arr.length; j++) {

                if (arr[i] < arr[j]) {//arr[5] = 6, arr[6] = 9
                    int val = m.get(arr[j]);// val = 1
                    max = Math.max(max, val); // max(1,1) = 1
                }

            }
            m.put(arr[i], max + 1); //(6 -> 2)
        }

        return max + 1;
    }
}
