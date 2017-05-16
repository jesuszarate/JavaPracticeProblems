package ModerateCCI;

import java.util.HashSet;

/**
 *
 * Created by jesuszarate on 5/16/17.
 */
public class DivingBoard {


    public static HashSet<Integer> getLengths(int k, int longer, int shorter){
        HashSet<Integer> lens = new HashSet<Integer>();
        getLengths(k, 0, longer, shorter, lens);
        return lens;
    }

    private static void getLengths(int k, int total, int longer, int shorter, HashSet<Integer> lens) {

        if(k == 0){
            lens.add(total);
            return;
        }

        getLengths(k-1, total + longer, longer, shorter, lens);
        getLengths(k-1, total + shorter, longer, shorter, lens);
    }
}
