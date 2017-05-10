package ModerateCCI;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by jesuszarate on 5/10/17.
 */
public class SmallestDifference {

    public static void main(String[] a){

        //int[] arr1 = {1, 3, 15, 11, 2};
        //int[] arr2 = {23, 127, 235, 19, 8};

        int[] arr1 = {1, 2, 3};
        int[] arr2 = {8, 19, 23, 127};

        System.out.println(smallestDiff(arr1, arr2));
    }

    public static int smallestDiff(int[] arr1, int[] arr2){
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int a = 0;
        int b = 0;

        int min = Integer.MAX_VALUE;

        while (a < arr1.length && b < arr2.length){

            int dif = Math.abs(arr1[a] - arr2[b]);

            if(dif < min)
                min = dif;

            if (arr1[a] < arr2[b])
                a++;
            else b++;
        }
        return min;
    }
}
