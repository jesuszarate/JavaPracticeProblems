package LeetCode;

import java.util.ArrayList;

/**
 * 694. Number of Distinct Islands My SubmissionsBack to Contest
 User Accepted: 0
 User Tried: 0
 Total Accepted: 0
 Total Submissions: 0
 Difficulty: Medium
 Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

 Count the number of distinct islands. An island is considered to be the same as another if and only if one island can be translated (and not rotated or reflected) to equal the other.

 Example 1:
 11000
 11000
 00011
 00011
 Given the above grid map, return 1.
 Example 2:
 11011
 10000
 00001
 11011
 Given the above grid map, return 3.

 Notice that:
 11
 1
 and
 1
 11
 */
public class NumberOfDistinctIslands {

    public static void main(String[] a)
    {
        int[][] grid = {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
        numDistinctIslands(grid);
    }

    // 0 1 ->
    // 1 1

    //   0 1 2 3 4
    // 0 1 1
    // 1 1 1   1 1
    // 2       1 1
    // 3

    //(0, 0) (0, 1) => (0 - 0) + (0 - 1) = -1
    //(1, 0) (1, 1) => (1 - 0) + (1 - 1) = 1

    //(2, 2) (2, 3) => (2-2 = 0, 3-2 = 1)
    //(3, 2) (3, 3) => (3-2 = 1, 2-2 = 0) (3-2=1, 3-2=1)

    // (1, 3) (1, 4) = (1 - 1, 3, 1)
    // (2, 3) (2, 4) =

    // 01 (0, 1)        => 0 - 1 = -1
    // 11 (1, 0) (1, 1) => (1 - 0 = 1) + (1 - 1) = 0

    // 01 (3, 3)        => ()
    // 11 (3, 2) (3, 3) => 1 + 0

    // 10 (0, 0)      => 0 + 0 = 0
    // 11 (1, 0) (1 1)=> 0 + 0, 1 + 1 = 1
    public static int numDistinctIslands(int[][] grid) {

        int max = Integer.MAX_VALUE;
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if(grid[row][col] == 1){
                    ArrayList<int[]> islands = new ArrayList<int[]>();
                    markIsland(grid, islands, row, col);
                    Math.max(islands.size(), max);
                }
            }
        }
        return max;
    }

    public static void markIsland(int[][] grid, ArrayList<int[]> islands, int row, int col){

        // 0 1 0
        // 1 1 1
        // 0 1 0

        // 1, 1
        // 0, 1
        // 2, 1

        // 1, 0
        // 1, 1
        // 1, 2

        // Mark current node as visited with -1
        if(grid[row][col] == 1) {
            grid[row][col] = -1;
            int[] token = {row, col};
            islands.add(token);


            if (row - 1 > -1 && grid[row - 1][col] > -1) {
                markIsland(grid, islands, row - 1, col);
            }
            if (row + 1 < grid.length && grid[row + 1][col] > -1) {
                markIsland(grid, islands, row + 1, col);
            }
            if (col - 1 > -1 && grid[row][col - 1] > 0) {
                markIsland(grid, islands, row, col - 1);
            }
            if (col + 1 < grid[0].length && grid[row][col + 1] > -1) {
                markIsland(grid, islands, row, col + 1);
            }
        }
    }
}
