package LeetCode;

public class findIslands {

    //Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water
    // and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid
    // are all surrounded by water.

    public static void main(String[] a) {
//        char[][] grid = {
//                {'1', '1', '1', '1', '0'},
//                {'1', '1', '0', '1', '0'},
//                {'1', '1', '0', '0', '0'},
//                {'0', '0', '0', '0', '0'}};
        char[][] grid = {
                {'1', '1'}};

        System.out.println(numIslands(grid));
    }
    // vv000
    // vv000
    // 00100
    // 00011

    public static int numIslands(char[][] grid) {
        int islandCount = 0; // 1
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {

                // row = 0
                // col = 0
                if (!isVisited(grid[row][col]) && isIsland(grid[row][col])) {
                    islandCount++;
                    markIsland(grid, row, col);
                }
            }
        }
        return islandCount;
    }

    public static boolean isIsland(char l) {
        return l == '1';
    }

    public static boolean isVisited(char l) {
        return l == 'v';
    }

    public static void markIsland(char[][] grid, int row, int col) { // row : 0, col : 0
        if (row > -1 && row < grid.length &&
                col > -1 && col < grid.length) {

            if (grid[row][col] == '1') {
                grid[row][col] = 'v';
                markIsland(grid, row + 1, col); // row :  1,  col :  => row : 1, col : 1 => row : 2, col : 1
                markIsland(grid, row - 1, col); // row : -1,  col :  0 X
                markIsland(grid, row, col + 1); // row :  0,  col :  1 X
                markIsland(grid, row, col - 1); // row :  0,  col : -1 X
            }
        }
    }

}
