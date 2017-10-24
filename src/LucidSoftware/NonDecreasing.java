package LucidSoftware;

import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.utilities.Assert;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NonDecreasing {

    static class Node {

        int row;
        int col;

        Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    /**
     * Take a rectangular grid of numbers and find the length
     * of the longest sub-sequence.
     *
     * @return the length as an integer.
     */
    public static int longestSequence(int[][] grid) {

        if (grid == null || grid.length == 0) return 0;

        int[][] cache = new int[grid.length][grid[0].length];
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        int max = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                int currmax = longestSequence(grid, visited, cache, new Node(row, col));
                visited = new boolean[grid.length][grid[0].length];
                max = Math.max(currmax, max);
            }
        }
        return max;
    }

    public static int longestSequence(int[][] grid, boolean[][] visited, int[][] cache, Node root) {

        visited[root.row][root.col] = true;
        List<Node> neighbors = getChildren(grid, visited, root);

        int max = 0;
//        if (cache[root.row][root.col] > max) {
//            return cache[root.row][root.col];
//        }

        for (Node n : neighbors) {
            if (!visited[n.row][n.col]) {
//                if (cache[n.row][n.col] > max) {
//                    max = Math.max(cache[n.row][n.col], max);
//                    continue;
//                }
                max = Math.max(longestSequence(grid, visited, cache, n), max);
            }
        }

        cache[root.row][root.col] = Math.max(cache[root.row][root.col], max + 1);
        return max+1;
    }

    public static List<Node> getChildren(int[][] grid, boolean[][]visited, Node node) {
        List<Node> children = new ArrayList<>();
        for (int row = node.row - 1; row <= node.row + 1; row++) {
            for (int col = node.col - 1; col <= node.col + 1; col++) {
                if ((row < 0 || row >= grid.length) || (col < 0 || col >= grid[0].length) ||
                        (node.row == row && node.col == col) )
                    continue;

                if ((Math.abs(grid[node.row][node.col] - grid[row][col]) > 3)) {
                    children.add(new Node(row, col));
                }
            }
        }
        return children;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numRows = 0;
        int numCols = 0;

//        int[][] grid = {{1, 6, 2}, {8, 3, 7}, {4, 9, 5}}; // 9 good
//        int[][] grid = {{4, 2, 4}, {0, 3, 1}, {3, 7, 9}}; // 6 good
        int[][] grid = {{8, 2, 4},{0, 6, 1},{3, 7, 9}}; // 8 bad return 7
//        int[][] grid = {{8, 2},{0, 6}};
//          int[][] grid = {{1, 5}};
//        int[][] grid = null;
//
        int length = longestSequence(grid);
        System.out.println("length " + length);


//        List<Node> ns = getChildren(grid, n);
//        for(Node node : ns){
//            System.out.println(grid[node.row][node.col]);
//        }

    }




}
