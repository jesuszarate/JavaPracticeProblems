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
        //arr = mergeSort.mergeSort(arr);


        //for(int i : arr)
            //System.out.print(i + " ");
        QuickSort quickSort = new QuickSort();

        quickSort.QuickSort(arr);

//        for(int i : arr)
//            System.out.print(i + " ");

//        System.out.println();
//        System.out.println(quickSort.getPivot(arr, 0, 5) + " = 7");
//        System.out.println(quickSort.getPivot(arr, 0, 2) + " = 5");
//        System.out.println(quickSort.getPivot(arr, 1, 3) + " = 3");
//        System.out.println(quickSort.getPivot(arr, 2, 4) + " = 7");
//        System.out.println(quickSort.getPivot(arr, 3, 5) + " = 13");


        arr = new int[]{6,3,6,1,4,8,5,8};
        FindSumOfTwoElements fs = new FindSumOfTwoElements();
        for(int i = 0; i < 17; i++)
        {
            fs.find(arr, i);
        }
    }
}
