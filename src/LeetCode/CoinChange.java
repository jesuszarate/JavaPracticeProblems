package LeetCode;

import java.util.BitSet;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by jesuszarate on 4/13/17.
 */
public class CoinChange {
    public static HashMap<Integer, Integer> coinMap = new HashMap<Integer, Integer>();
    public static void main(String[] a) {
        System.out.println(coinChange(new int[]{1,2,5}, 11));


        LinkedList<Integer> lk = new LinkedList<Integer>();
        // 1 0 1 1

        // 0 1 2 3
        // 0 0 0 0
        // set(1)
        // 0 0 0 1
        // 0 0 0 0 ||
        // 0 0 0 1

        // set(3)
        // 0 1 0 1

        lk.add(1);
        lk.add(0);
        lk.add(1);
        lk.add(1);

        BitSet bitSet = new BitSet();


        for (int i = 0; i < lk.size(); i++){
            if(lk.get(i) == 1)
                bitSet.set(i);
        }

        for(int i = 0; i < bitSet.length(); i++){
            System.out.println(bitSet.get(i));
        }


        System.out.println();
        bitSet.set(3);
        for(int i = 0; i < bitSet.length(); i++){
            System.out.println(bitSet.get(i));
        }

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

