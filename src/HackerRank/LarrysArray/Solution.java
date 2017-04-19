package HackerRank.LarrysArray;

import java.util.*;

public class Solution
{
    public static void main(String[] args)
    {
        twoSum(new int[]{3, 2, 4}, 6);
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
//
//        int numTests = 0;
//        //boolean isNum = Int32.TryParse(Console.ReadLine(), out numTests);
//
//        Scanner scanner = new Scanner(System.in);
//
//        numTests = Integer.parseInt(scanner.nextLine());
//
//        for (int i = 0; i < numTests; i++)
//        {
//            int arrSize = 0;
//
//            arrSize = Integer.parseInt(scanner.nextLine());
//
//            int[] arr = toIntArr(scanner.nextLine().split(" "));
//            if (arrSize == arr.length)
//            {
//                if (trySort(arr)) System.out.println("YES");
//
//                else System.out.println("NO");
//            }
//
//        }
    }

    public static boolean trySort(int[] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            if (i + 1 < arr.length && arr[i] > arr[i + 1])
            {
                if (!tryRotate(arr, i)) return false;
            }
        }
        return true;
    }

    public static boolean tryRotate(int[] arr, int start)
    {
        int end = start + 2;
        if (end >= arr.length) return false;

        int tmp = arr[start];

        for (int count = 0; count < 3; count++)
        {
            for (int i = start; i <= end; i++)
            {
                if (i + 1 <= end) arr[i] = arr[i + 1];
            }
            arr[end] = tmp;
            if (arr[start] <= arr[start + 1]) return true;
        }
        return false;
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


    public static int[] twoSum(int[] nums, int target) {

        //(3, 0), (4, 1), ()
        HashMap<Integer, Integer> l = new HashMap<Integer, Integer>();

        for(int i = 0;  i < nums.length; i++){
            int num = target - nums[i];

            if(l.containsKey(nums[i])){
                //return new int[]{l.get(num), i};// (1, 2)
                int[] a = new int[2];
                a[0] = l.get(nums[i]);
                a[1] = i;
                return a;
            }

            l.put(num, i);
        }
        return null;
    }

}
