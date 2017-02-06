package RecursiveMultiplication;

/**
 * Created by jesuszarate on 1/30/17.
 */
public class main {

    public static void main(String[] a){
        //System.out.println(mult(3, 3));

        int[] coins = new int[]{25,10,5,1};

        //System.out.println(wayRepresentNCents(coins, 6, 0));

        System.out.println(steps(4));
    }

    public static int mult(int x, int y){ // 4 * 0

        if(y == 0) return 0; // 0

        return x + mult(x, y - 1);
    }


    public static int wayRepresentNCents(int[] coins, int n, int count){// n = 1


        if(n >= 25)
        if(n >= 10 && n < 25){
            return 4;
        }
        else if(n >= 5 && n < 10){
            return 2;
        }
        else if(n < 5){
            return 1;
        }

        int c = 0;
        for(int coin : coins){
            if(coin <= n){ //1 <= 6
                c += wayRepresentNCents(coins, n - coin, count); // 6 - 1 = 5, 1
            }
        }
        return count;
    }

    public static int countWays(int n){
        if(n < 0){
            return 0;
        }
        else if(n == 0){
            return 1;
        }
        else {
            return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
        }
    }

    public static int steps(int n){// 4

        if(n == 0) return 1;
        if(n < 0) return 0;

        return steps(n - 3) + steps(n - 2) + steps(n - 1) ;
    }
}

// count = 1