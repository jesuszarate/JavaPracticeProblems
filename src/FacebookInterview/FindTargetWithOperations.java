package FacebookInterview;

import java.util.HashSet;

public class FindTargetWithOperations {


    /**
     * Given an array with N numbers determine is you can get a target K
     * performing only the following operations: +, -, *, /
     *
     * Must use every number exactly once and in any order
     *
     * e.g [7, 3, 3, 1] target 24
     *
     * @param a
     */
    public static void main(String[] a){

        int[] N = {7, 3, 3, 1};
        System.out.println(isTarget(N, 24));

    }

    public static boolean isTarget(int[] N, int target) {

        for (int i = 0; i < N.length; i++) {

            HashSet<Integer> hs = isTarget(N, 0, i);
            if (isTarget(N, 0, i).contains(target)) {
                return true;
            }
        }
        return false;
    }

    public static HashSet<Integer> isTarget(int[] N, int start, int boundry) {

        HashSet<Integer> cache = new HashSet<Integer>();
        if(N.length <= start) {
            cache.add(0);
        }

        for (int i = start; i < N.length; i++) {

            int ind = (i + boundry) % N.length;

            HashSet<Integer> values = isTarget(N, i + 1, boundry);

            for (int v : values) {
                cache.add(N[ind] + v);
                cache.add(N[ind] * v);
                cache.add(N[ind] - v);

                if (v != 0) cache.add(N[ind] / v);
            }
        }
        return cache;
    }
}
