package Sorting;

import java.util.Arrays;

/**
 * Created by Jesus Zarate on 12/27/15.
 *
 * Modification of merge sort to find if two items in an array add up to
 * an integer x
 *
 * */
public class FindSumOfTwoElements
{

    public void find(int[] A, int x)
    {
        Arrays.sort(A); // Would use merge sort in this case

        int start = 0;
        int end = A.length - 1;
        int sum;
        while(start < A.length - 1 && end >= 0)
        {
            sum = A[start] + A[end];
            if(sum > x)
                end--;
            else if(sum < x)
                start++;
            else {
                System.out.println(A[start] + " and " + A[end]);
                return;
            }

        }
        System.out.println("No two numbers add up to: " + x);
    }
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
