package Sorting;

import java.util.Arrays;

public class QuickSort2 {
    static QuickSort q;
    public static void main(String[] a) {
        int[] arr = {5, 3, 9, 1, 2, 4};

        q = new QuickSort();
        q.QuickSort(arr);

        //Arrays.stream(arr).forEach(System.out::println);
        quickSort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length-1);
    }

    static void quickSort(int[] arr, int s, int e) {
        if (s >= e) return;

        int partition = partition(arr, s, e);
        quickSort(arr, s, partition - 1);
        quickSort(arr, partition + 1, e);

    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static int partition(int[] arr, int s, int e) {
        int piv = s + ((e - s) / 2);
        q.swap(arr, piv, e);

        int l = s;
        int r = e - 1;

        while (l <= r) {

            while (arr[l] < arr[piv]) {
                l++;
            }

            while (arr[r] > arr[piv]) {
                r--;
            }
            q.swap(arr, l, r);
            l++;
            r--;
        }
        swap(arr, l , e);
        return l;
    }



}
