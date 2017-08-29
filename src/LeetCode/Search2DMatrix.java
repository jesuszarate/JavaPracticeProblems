package LeetCode;

public class Search2DMatrix {

    public static void main(String[] a) {

        int[][] m = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};

        //m = new int[][]{{1,6,10,13,14,16,21},{3,10,12,18,22,27,29},{3,15,19,20,23,29,34},{8,15,19,25,27,29,39},{12,17,24,25,28,29,41},{16,22,27,31,31,33,44},{20,26,28,35,39,41,45},{25,31,34,39,44,45,47}}
        //m = new int[][]{{-5}};
        System.out.println(searchMatrix(m, 19));
        System.out.println(searchMatrix(m, 16));
        System.out.println(searchMatrix(m, -5));

    }

    static boolean searchMatrix(int[][] matrix, int target) {

        for (int row = 0; row < matrix.length; row++) {
            int lastCol = matrix[0].length - 1;
            if (lastCol >= 0 && target <= matrix[row][lastCol] ) {
                if (binSearch(matrix[row], 0, lastCol, target)) return true;
            }
        }
        return false;
    }

    static boolean binSearch(int[] arr, int start, int end, int target) {

        //[2, 1]
        // 0 1 -> (1-0)/2 = 0
        // 1, 1 -> (1-1)/2 = 0
        int mid = start + ((end - start) / 2);
        if (end - start < 0) return false;

        if(arr[mid] == target) return true;

        if (target < arr[mid])
            return binSearch(arr, start, mid - 1, target);

        if (target > arr[mid])
            return binSearch(arr, mid + 1, end, target);
        return false;
    }

}
