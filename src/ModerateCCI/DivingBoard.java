package ModerateCCI;

import java.util.HashSet;

/**
 * You are building a diving board b placing a bunch of plants of words, end-to-end, These are two types of planks,
 * one of length shorter and one of length longer. You must use exactly K planks of wood. Write a method to generate
 * all possible lengths for the diving board.
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
