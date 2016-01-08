package CareerCup;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Jesus Zarate on 1/7/16.
 *
 * Write a method that takes in 2 int arrays of any size and returns an array that calculates the sum of both.
 * for example, [1,2,3] and [2,3,4] will return [3,5,7]
 *
 * Or [1,2,3] and [2,3,5,5] will return [2,4,7,8]
 * however, if it's like [9,9,2] and [0,1,3] you need to carry the sum so it returns as [1,0,0,5]
 *
 * SINGLE DIGIT ONLY
 *
 */
public class SumOfArray
{
    public static void main(String[] args)
    {
        int[] arr1 = new int[]{1,2,3};
        int[] arr2 = new int[]{2,3,4};

        printArr(arraySum(arr1, arr2), "[3 5 7 ]");

        arr1 = new int[]  {1,2,3};
        arr2 = new int[]{2,3,5,5};

        System.out.println();
        printArr(arraySum(arr1, arr2), "[2 4 7 8 ]");

        arr1 = new int[]{9,9,2};
        arr2 = new int[]{0,1,3};

        System.out.println();
        printArr(arraySum(arr1, arr2), "[1 0 0 5 ]");

    }

    public static void printArr(int[] arr, String result)
    {
        System.out.print("[");
        for(int i : arr)
        {
            System.out.print(i + " ");
        }

        System.out.print("]");
        System.out.println(" => " + result);
    }

    public static int[] arraySum(int[] arr1, int[] arr2)
    {
        Stack<Integer> result = new Stack<Integer>();

        int arr1End = arr1.length - 1;
        int arr2End = arr2.length - 1;

        int carry = 0;
        int place;
        while (arr1End >= 0 && arr2End >= 0)
        {
            int sum = arr1[arr1End] + arr2[arr2End] + carry;
            place = sum % 10;
            carry = sum / 10;

            result.push(place);

            arr1End--;
            arr2End--;
        }

        if(arr1End >= 0)
        {
            for (int i = arr1End; i >= 0; i--)
            {
                result.push(arr1[i] + carry);
                carry = 0;
            }
        }
        else if(arr2End >= 0)
        {
            for (int i = arr2End; i >= 0; i--)
            {
                result.push(arr2[i] + carry);
                carry = 0;
            }

        }

        if(carry > 0)
            result.push(carry);

        int[] arrRes = new int[result.size()];
        for(int i = 0; i < arrRes.length; i++)
        {
            arrRes[i] = result.pop();
        }
        return arrRes;
    }
}
