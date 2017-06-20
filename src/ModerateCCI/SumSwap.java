package ModerateCCI;

import java.util.Arrays;

/**
 * Created by jesuszarate on 6/19/17.
 */
public class SumSwap {

    public static void main(String[] argv){

        //() and ()
        int[] a = {4, 1,2, 1, 1, 2};
        int[] b = {3, 6, 3, 3};

        a = swapNumber(a, b);
        Arrays.stream(swapNumber(a, b)).forEach(System.out::println);
    }

    private static int getSum(int[] nums){
        return Arrays.stream(nums).sum();
    }

    private static int[] swapNumber(int[] a, int[] b){
        int bPos = 0, aPos = 0;
        int diff = getDifference(a, b);
        while(aPos < a.length && bPos < b.length){

            if(a[aPos] + b[bPos] == diff){
                return new int[]{a[aPos], b[bPos]};
            }
            else if(a[aPos] > b[bPos]){ aPos++; }
            else { bPos++; }
        }
        return new int[0];
    }

    private static int getDifference(int[] a, int[] b){
        return Math.abs(getSum(a) - getSum(b));
    }
}
