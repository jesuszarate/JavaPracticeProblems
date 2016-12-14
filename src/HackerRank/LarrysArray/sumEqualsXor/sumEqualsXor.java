package HackerRank.LarrysArray.sumEqualsXor;

import java.util.Scanner;

/**
 * Created by jesuszarate on 12/14/16.
 */
public class sumEqualsXor {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();

        int count = 0;

        if (n >= 0 && n <= Math.pow(10, 15)) {
            for (int i = 0; i <= n; i++) {
                long res = n + i;
                if ((n ^ i) == res) {
                    System.out.println(i);
                    count++;
                }
            }
            System.out.println("Count: " + count);
        } else {
            System.out.println(n);
        }
    }

}
