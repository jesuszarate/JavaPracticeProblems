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
        QuickSortRec(A, leftBound, pivotInd); // Left recur
        QuickSortRec(A, pivotInd + 1, rightBound); // right recur
    }

    private int partition(int[] A, int leftBound, int rightBound)
    {
        int pivotInd = getPivot(A, leftBound, rightBound);
        int pivot = A[pivotInd];
        swap(A, pivotInd,rightBound);


        int L = leftBound, R = rightBound;

        while (L <= R)
        {
            // Find the left swap
            if(A[L] >= pivot)
            {
                L++; continue;
            }

            // Find the right swap
            if(A[R] <= pivot)
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
        int mid = (leftBound + rightBound) / 2;

        int median;
        int max1 = A[leftBound] > A[mid] ? A[leftBound] : A[mid];
        int max2 = A[rightBound] < A[mid] ? A[rightBound] : A[mid];

        return max1 < max2 ? max1 : max2;

        //median = median < A[rightBound] ? median: A[rightBound];
        //return median > A[mid] ? median : A[mid];
    }

 //3 4 5 -> 4 < 5 -> 4
   //  6 5
    // 5 3


}
