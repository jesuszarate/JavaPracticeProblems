package LucidSoftware;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {

    // nonDecreasing
    public Tests(){

    }

    @Test
    public void test() {
        int[][] grid = {{1, 6, 2}, {8, 3, 7}, {4, 9, 5}}; // 9 good
        assertEquals(NonDecreasing.longestSequence(grid), 9);
    }
    @Test
    public void test2() {
        int[][] grid = new int[][]{{4, 2, 4}, {0, 3, 1}, {3, 7, 9}}; // 6 good
        assertEquals(NonDecreasing.longestSequence(grid), 6);
    }
    @Test
    public void test3() {
        int[][] grid = new int[][]{{8, 2, 4}, {0, 6, 1}, {3, 7, 9}}; // 8 bad return 7
        assertEquals(NonDecreasing.longestSequence(grid), 8);
    }
    @Test
    public void test4() {
        int[][] grid = new int[][]{{8, 2}, {0, 6}};
        assertEquals(NonDecreasing.longestSequence(grid), 4);
    }
    @Test
    public void test5() {
        int[][] grid = new int[][]{{1, 5}};
        assertEquals(NonDecreasing.longestSequence(grid), 2);
    }
    @Test
    public void test6() {
        int[][] grid = new int[][]{{8}};
        assertEquals(NonDecreasing.longestSequence(grid), 1);
    }
    @Test
    public void test7() {
        int[][] grid = new int[][]{};
        assertEquals(NonDecreasing.longestSequence(grid), 0);
    }
    @Test
    public void test8() {
        int[][] grid = null;
        assertEquals(NonDecreasing.longestSequence(grid), 0);
    }
}
