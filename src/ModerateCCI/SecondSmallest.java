package ModerateCCI;

import java.util.Arrays;

/**
 * Created by jesuszarate on 7/5/17.
 */
public class SecondSmallest {
    // 8 5 3 6 2 9 7
    //         *
    // one -> 2
    // two -> 3

    // 3 2 0
    // -> 2
    // -> 0

    // 3, 2, 2, 3
    // -> 2
    // -> 3

    public static void main(String[] arg){
        int[] arr = { 8, 5, 3, 6, 4, 9, 1};
        //arr = new int[]{3, 2, 2, 3};

        System.out.println(secondSmallest(arr));
    }

    public static int secondSmallest(int[] arr){

        final int[] smallest = {Integer.MAX_VALUE};
        final int[] secSmallest = {Integer.MAX_VALUE};

        for (int i : arr){
            if(i < smallest[0]){
                secSmallest[0] = smallest[0];
                smallest[0] = i;
            }
            else if(i > smallest[0] && i < secSmallest[0]){
                secSmallest[0] = i;
            }
        }

        return secSmallest[0];
    }
}
