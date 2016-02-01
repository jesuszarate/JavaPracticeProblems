package Sorting;

/**
 * Created by Jesus Zarate on 12/27/15.
 *
 * Modification of merge sort to find if two items in an array add up to
 * an integer x
 *
 * */
public class FindSumOfTwoElements
{

    public int[] FindSumOfTwoElements(int[] A, int x){
        int[] temp = new int[A.length];
        mergeSortRec(A, temp, 0, A.length - 1, x);
        return A;
    }

    public void mergeSortRec(int[] A, int[] temp, int begin, int end, int x){
        if(begin >= end){
            return;
        }

        int mid = begin + ((end - begin) / 2);

        mergeSortRec(A, temp, begin, mid, x);
        mergeSortRec(A, temp, mid + 1, end, x);

        merge(A, temp, begin, mid + 1, end, x);
    }

    public void merge(int[] A, int[] temp, int begin, int mid, int end, int x){

        int curr = begin;
        int first = begin;
        int second = mid;

        while(first <= mid && second <= end)
        {
            if(A[first] < A[second]){
                temp[curr] = A[first];
                if((A[first] + A[second]) == x)
                    System.out.println(A[first] + " and " + A[second]);

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
                   // here = "hello";
                }
                curr++;
                //System.out.print(here);
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

//        for(int i = begin; i <= end; i++)
//        {
//            System.out.print(temp[i] + ", ");
//            A[i] = temp[i];
//        }
//        System.out.println();
    }
}
