package HackerRank.LarrysArray;

import java.util.Scanner;

/**
 * Created by jesuszarate on 9/30/16.
 */
public class Solution1
{
    public static void main(String[] args)
    {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        int numTests = 0;
        //boolean isNum = Int32.TryParse(Console.ReadLine(), out numTests);

        Scanner scanner = new Scanner(System.in);

        numTests = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numTests; i++)
        {
            int arrSize = 0;

            arrSize = Integer.parseInt(scanner.nextLine());

            int[] arr = toIntArr(scanner.nextLine().split(" "));
            if (arrSize == arr.length)
            {
                if (trySort(arr)) System.out.println("YES");

                else System.out.println("NO");
            }

        }
    }

    public static boolean trySort(int[] arr){

        int i = 0;
        for(; i < arr.length - 2; i++){
            if(!isSorted(arr, i, i + 2)){
                return false;
            }
        }

        return isSorted(arr, i);
    }

    private static boolean isSorted(int[] arr, int start)
    {
        int prev = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(prev > arr[i]) return false;
        }
        return true;
    }


    private static boolean isSorted(int[] arr, int start, int end)
    {
        int count = 0;
        while (count < 3 && (arr[start] > arr[start+1] || arr[start+1] > arr[start+2])){

            int tmp = arr[start];
            for (int i = start; i < end; i++)
            {
                arr[i] = arr[i + 1];
            }
            arr[end] = tmp;
            count++;
        }
        return count != 3;

    }

    public static int[] toIntArr(String[] strArr)
    {
        int[] intArr = new int[strArr.length];
        int currNum = 0;
        for (int i = 0; i < intArr.length; i++)
        {
            currNum = Integer.parseInt(strArr[i]);
            intArr[i] = currNum;
        }
        return intArr;
    }
}
