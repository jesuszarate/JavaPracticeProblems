package Sorting;

/**
 * Created by jesuszarate on 12/28/15.
 */
public class QuickSort
{
    public void QuickSort(int[] A){
        QuickSortRec(A, 0, A.length - 1);
    }

    public void QuickSortRec(int[] A, int leftBound, int rightBound){
        if(leftBound >= rightBound)
        {
            return;
        }

        int pivotInd = partition(A, leftBound, rightBound);
        QuickSortRec(A, leftBound, pivotInd - 1); // Left recur
        QuickSortRec(A, pivotInd + 1, rightBound); // right recur
    }

    private int partition(int[] A, int leftBound, int rightBound)
    {
        int pivotInd = getPivot(A, leftBound, rightBound);
        int pivot = A[pivotInd];
        swap(A, pivotInd,rightBound);


        int L = leftBound, R = rightBound - 1;

        while (L <= R)
        {
            // Find the left swap
            if(A[L] <= pivot)
            {
                L++; continue;
            }

            // Find the right swap
            if(A[R] >= pivot)
            {
                R--; continue;
            }

            swap(A, L, R);
            L++; R--;
        }

        swap(A, L, rightBound);

        return L;
    }

    public void swap(int[] A, int ind1, int ind2)
    {
        int temp = A[ind1];
        A[ind1] = A[ind2];
        A[ind2] = temp;
    }


    public int getPivot(int[] A, int leftBound, int rightBound)
    {
        int first = A[leftBound];
        int mid = (leftBound + rightBound) / 2;
        int last = A[rightBound];

        int median = first > A[mid] ? leftBound : mid;

        if(A[median] > last){
            median = rightBound;
            if(first > A[median]){
                median = leftBound;
            }
        }

        return median;
    }

}
