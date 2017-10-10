package LeetCode;

import java.util.*;


/**
 * Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * <p>
 * The same repeated number may be chosen from C unlimited number of times.
 * <p>
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set [2, 3, 6, 7] and target 7,
 * A solution set is:
 * [
 * [7],
 * [2, 2, 3]
 * ]
 */
public class CombinationSum {

    public static void main(String[] args) {

        int[] cand = {2, 3, 6, 7};
        System.out.println(combinationSum(cand, 7));

    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> list = new ArrayList<>();

        backtrack(candidates, list, new ArrayList<>(), target, 0);

        return list;
    }

    public static void backtrack(int[] candidates, List<List<Integer>> list,
                                 List<Integer> tempList, int remaining, int start) {

        if(remaining < 0) return;
        // If it's ever equal add to list
        if (remaining == 0) list.add(new ArrayList<>(tempList));

        // If it's over then ignore it
        else {

            for (int i = start; i < candidates.length; i++) {

                tempList.add(candidates[i]);
                backtrack(candidates, list, tempList, remaining - candidates[i], i);
                tempList.remove(tempList.size() - 1);

            }

        }

    }
}
