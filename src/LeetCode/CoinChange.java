package LeetCode;

import java.util.HashMap;

/**
 * Created by jesuszarate on 4/13/17.
 */
public class CoinChange {
    public static HashMap<Integer, Integer> coinMap = new HashMap<Integer, Integer>();
    public static void main(String[] a) {
        System.out.println(coinChange(new int[]{1,2,5}, 11));
    }

    public static int coinChange(int[] coins, int amount) {

        if(coinMap.containsKey(amount)) return coinMap.get(amount);

        if(amount < 0) return -1;

        if (amount == 0) return 0;

        int min = Integer.MAX_VALUE;

        for(int coin : coins){
            int result = coinChange(coins, amount - coin) + 1;
            if(result > 0){
                min = Math.min(min, result);
            }
        }

        coinMap.put(amount, min);
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}

