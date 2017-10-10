package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of distinct numbers, return all possible permutations.

 For example,
 [1,2,3] have the following permutations:

 [
 [1,2,3],
 [1,3,2],
 [2,1,3],
 [2,3,1],
 [3,1,2],
 [3,2,1]
 ]

 */
public class Permutations {

    public static void main(String[] args){

        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));

    }

    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }


    // 1, 2, 3
    public static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums){

        // list = {[1,2,3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2] }
        // tempList = {}
        // nums = [1, 2, 3]
        //         0  1  2

        // If the tempList is full then we can add it to the list because it's a complete list
        if(tempList.size() == list.size()){
            list.add(new ArrayList<>(tempList));
            return;
        }

        for(int i = 0; i < nums.length; i++){ // (i = 0, 1, 2 (i = 0, (i = 0, 1, 2)))

            if(tempList.contains(nums[i])) continue;
            tempList.add(nums[i]); // [ 3, 1]
            backtrack(list, tempList, nums); //
            tempList.remove(tempList.size() - 1); //
        }
    }

}
