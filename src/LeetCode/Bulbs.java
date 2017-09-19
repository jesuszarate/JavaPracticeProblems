package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class Bulbs {

    public static void main(String[] a){
        //ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 1, 0, 0, 1, 1, 0, 0, 1 ));
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(
         0, 1, 0, 1 ));
        System.out.println(bulbs(arr));
    }

    public static int bulbs(ArrayList<Integer> a) {

        if(a.size() < 1)
            return 0;

        int S = a.get(0);


        int flips = 0;
        for (int bi = 0; bi < a.size(); bi++){

            if (a.get(bi) == 0){ //# subA[bulbInd] = 0
                flip(a, bi, a.size()); //# 1 - 3
                flips++;
            }
        }
        return flips;

    }

    public static void flip(ArrayList<Integer> a, int start, int end){

        for(int i = start; i < end; i++){
            a.set(i, a.get(i) == 0 ? 1 : 0);
        }
    }
}
