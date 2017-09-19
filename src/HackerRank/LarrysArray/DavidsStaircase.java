package HackerRank.LarrysArray;

import java.util.HashMap;
import java.util.Scanner;

public class DavidsStaircase {

    /**
     * Davis has  staircases in his house and he likes to climb each staircase , , or  steps at a time. Being a very precocious child, he wonders how many ways there are to reach the top of the staircase.

     Given the respective heights for each of the  staircases in his house, find and print the number of ways he can climb each staircase on a new line.

     Input Format

     The first line contains a single integer, , denoting the number of staircases in his house.
     Each line  of the  subsequent lines contains a single integer, , denoting the height of staircase .

     Constraints

     Subtasks

     for  of the maximum score.
     Output Format

     For each staircase, print the number of ways Davis can climb it in a new line.
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();
        for(int a0 = 0; a0 < s; a0++){
            int n = in.nextInt();
            System.out.println(DStairCase(n, cache));
        }
    }

    public static int DStairCase(int x, HashMap<Integer, Integer> cache){
        if(x <= 0) return 0;
        if(cache.containsKey(x)) return cache.get(x);

        int tot = 0;
        if(x == 1 || x == 2 || x == 3){
            tot += 1;
        }
        tot += DStairCase(x - 1, cache) + DStairCase(x - 2, cache) + DStairCase(x - 3, cache);
        cache.put(x, tot);
        return tot;
    }
}
