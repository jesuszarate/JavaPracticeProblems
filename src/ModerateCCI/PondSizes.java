package ModerateCCI;

import java.util.ArrayList;
import java.util.stream.Collector;

/**
 * Created by jesuszarate on 6/18/17.
 */
public class PondSizes {
    private static ArrayList<Integer> ponds = new ArrayList<Integer>();

    public static void main(String[] a){
        int[][] m = {
                {0, 2, 1, 0},
                {0, 1, 0, 1},
                {1, 1, 0, 1},
                {0, 1, 0, 1}};

        int[][] m1 = {
                {0, 2, 1, 0},
                {2, 1, 0, 1},
                {1, 1, 1, 1},
                {0, 1, 0, 1}};

        getPonds(m).forEach(System.out::println);
    }


    private static ArrayList<Integer> getPonds(int[][] m){
        boolean[][] visited = new boolean[m.length][m[0].length];
        //int res = getPondsRec(m, visited, 0, 0);

        for(int row = 0; row < m.length; row++){
            for(int col = 0; col < m[0].length; col++){
                if(isPond(m[row][col]) && !visited[row][col]){
                    visited[row][col] = true;
                    ponds.add(getPondsRec(m, visited, row, col));
                }
            }
        }

        return ponds;
    }

    private static boolean isPond(int val){
        return val == 0;
    }

    private static int getPondsRec(int[][] m, boolean[][] visited, int row, int col){


        int currentPondSize = m[row][col] == 0 ? 1 : 0;
        for(int i =  -1; i <= 1; i++){
            int r = row + i;
            //if(i == 0) continue;

            if(r > -1 && r < m.length){
                for (int j = - 1; j <=  1; j++){
                    int c = col + j;
                    if(r == row && c == col) continue;
                    if(c > -1 && c < m[0].length && !visited[r][c]){
                        visited[r][c] = true;
                        if(isPond(m[r][c])){
                            int pondSize = getPondsRec(m, visited, r, c);

                            if(m[row][col] == 0){
                                currentPondSize += pondSize;
                            }
                        }
                    }
                }
            }
        }
        return currentPondSize;
    }
}
