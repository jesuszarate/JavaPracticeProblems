package Sorting;

/**
 * Created by Jesus Zarate on 12/27/15.
 *
 * Implementation of Merge Sort
 */
public class MainSort
{
    public static void main(String args[])
    {
        int[] arr = new int[]{5, 3, 7, 1, 20, 13};
        MergeSort mergeSort = new MergeSort();
        arr = mergeSort.mergeSort(arr);


        for(int i : arr)
            System.out.print(i + " ");


    }
}
