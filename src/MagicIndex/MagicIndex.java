package MagicIndex;

/**
 * Created by jesuszarate on 1/30/17.
 */
public class MagicIndex {

    public static void main(String[] a){
        int[] A = new int[]{ -4, 0, 3, 4, 4, 8, 11}; // -1, 0, 2


        System.out.println(findMagicNum(A));
    }

    public static int findMagicNum(int[] A){
        return findMagicNum(A, 0, A.length - 1);
    }

    public static int findMagicNum(int[] A, int start, int end){
        if(start > end){
            return -1;
        }

        int mid = (start + end)/2; // 4/2 = 2
        if(A[mid] == mid){
            return mid;
        }

        int res = findMagicNum(A, start, mid - 1);
        if(res != -1)
            return res;

        return findMagicNum(A, mid + 1, end);
    }
}
