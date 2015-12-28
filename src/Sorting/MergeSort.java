package Sorting;

/**
 * Created by jesuszarate on 12/27/15.
 *
 * Implementation of Merge Sort
 */
public class MergeSort
{
    public int[] mergeSort(int[] A){
        return mergeSortRec(A, 0, A.length);
    }

    public int[] mergeSortRec(int[] A, int begin, int end){

        int mid = begin + ((end - begin) / 2);

        if(mid <= 0){
            return new int[]{A[begin]};
        }

        int[] A1 = mergeSortRec(A, begin, mid);
        int[] A2 = mergeSortRec(A, mid + 1, end);

        return merge(A1, A2);
    }

    public int[] merge(int[] A1, int[] A2){

        int[] temp = new int[A1.length + A2.length];

        int ind1 = 0, ind2 = 0, curr = 0;

        while(ind1 < A1.length && ind2 < A2.length)
        {
            if(A1[ind1] < A2[ind2]){
                temp[curr] = A1[ind1];
                curr++; ind1++;
            }
            else {
                temp[curr] = A2[ind2];
                curr++; ind2++;
            }
        }

        if(ind1 < A1.length)
        {
            for(int i = ind1; i < A1.length; i++)
            {
                temp[curr] = A1[i];
                curr++;
            }
        }
        else if(ind2 < A2.length)
        {
            for(int i = ind2; i < A2.length; i++)
            {
                temp[curr] = A2[i];
                curr++;
            }
        }
        return temp;
    }
}
