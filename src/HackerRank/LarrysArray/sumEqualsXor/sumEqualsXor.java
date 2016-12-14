package HackerRank.LarrysArray.sumEqualsXor;

import java.util.Scanner;

/**
 * Created by jesuszarate on 12/14/16.
 */
public class sumEqualsXor {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();

        long count = 0;

        while(n > 0){
            count += (n % 2 == 1)? 0 : 1;
            n /= 2;
        }

        System.out.printf((long)Math.pow(2, count) + "");
    }

}
