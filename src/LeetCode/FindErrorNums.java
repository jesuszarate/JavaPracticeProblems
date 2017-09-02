package LeetCode;

import java.util.Arrays;

public class FindErrorNums {

    public static void main(String[] a) {
        int[] nums = {1, 1};
        int[] res = findErrorNums(nums);
        System.out.println("[" + res[0] + ", " + res[1] + "]" );
    }

    public static int[] findErrorNums(int[] nums) {
        int[] check = new int[nums.length + 1];
        int[] res = new int[2];

        Arrays.stream(nums).forEach(i -> {
            if (check[i] == 1) res[0] = i;
            else check[i] = 1;
        });

        for (int i = 1; i < check.length; i++) {
            if (check[i] != 1) res[1] = i;
        }

        return res;
    }

}

