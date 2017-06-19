package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by jesuszarate on 6/16/17.
 */
public class PathSum {

    static int TotSum = 0;
    public static void main(String[] a) {
        //findSum(new );
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);

        findSum(root, 5);
        System.out.println(TotSum);

    }

    public int pathSum(TreeNode root, int sum) {
        return 1;
    }

    private static List<Integer> findSum(TreeNode current, int sum) {

        List<Integer> newVals = new ArrayList<>();
        newVals.add(current.val);

        if (current.left != null) {
            List<Integer> leftValues = findSum(current.left, sum);
            leftValues.forEach(i->{
                if(i == sum) TotSum++;
                newVals.add(i+current.val);
            });
        }

        if (current.right != null) {
            List<Integer> rightValues = findSum(current.right, sum);
            rightValues.forEach(i->{
                if(i == sum) TotSum++;
                newVals.add(i+current.val);
            });
        }


        return newVals;
    }
}

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

