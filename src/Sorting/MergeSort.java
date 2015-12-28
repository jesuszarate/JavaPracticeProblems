package Sorting;

/**
 * Created by Jesus Zarate on 12/27/15.
 *
 * Implementation of Merge Sort
 */
public class MergeSort
{
    public int[] mergeSort(int[] A){
        int[] temp = new int[A.length];
        mergeSortRec(A, temp, 0, A.length - 1);
        return A;
    }

    public void mergeSortRec(int[] A, int[] temp, int begin, int end){
        if(begin >= end){
            return;
        }

        int mid = begin + ((end - begin) / 2);

        mergeSortRec(A, temp, begin, mid);
        mergeSortRec(A, temp, mid + 1, end);

        merge(A, temp, begin, mid + 1, end);
    }

    public void merge(int[] A, int[] temp, int begin, int mid, int end){

        int curr = begin;
        int first = begin;
        int second = mid;

        while(first <= mid && second <= end)
        {
            if(A[first] < A[second]){
                temp[curr] = A[first];
                curr++; first++;
            }
            else {
                temp[curr] = A[second];
                curr++; second++;
            }
        }

        if(first <= mid)
        {
            String here = "";
            for(int i = first; i <= mid; i++)
            {
                try
                {
                    temp[curr] = A[i];
                }
                catch (Exception e)
                {
                    here = "hello";
                }
                curr++;
                System.out.print(here);
            }
        }
        else if(second < end)
        {
            for(int i = second; i < end; i++)
            {
                temp[curr] = A[i];
                curr++;
            }
        }

        for(int i = begin; i <= end; i++)
        {
            System.out.print(temp[i] + ", ");
            A[i] = temp[i];
        }
        System.out.println();
    }
}
