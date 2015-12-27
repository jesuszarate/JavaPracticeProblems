/**
 * Created by Jesus Zarate on 9/8/15.
 */
public class IsNumPalindrome
{

    // A function that reurns true only if num contains one digit
    public static boolean oneDigit(int num)
    {
        // comparison operation is faster than division operation.
        // So using following instead of "return num / 10 == 0;"
        return (num >= 0 && num < 10);
    }

    // A recursive function to find out whether num is palindrome
    // or not. Initially, dupNum contains address of a copy of num.
    public static boolean isPalUtil(int num, int dupNum)
    {
        // Base case (needed for recursion termination): This statement
        // mainly compares the first digit with the last digit
        if (oneDigit(num))
            return (num == (dupNum) % 10);

        // This is the key line in this method. Note that all recursive
        // calls have a separate copy of num, but they all share same copy
        // of *dupNum. We divide num while moving up the recursion tree
        if (!isPalUtil(num/10, dupNum))
            return false;

        // The following statements are executed when we move up the
        // recursion call tree
        dupNum /= 10;

        // At this point, if num%10 contains i'th digit from beiginning,
        // then (*dupNum)%10 contains i'th digit from end
        return (num % 10 == (dupNum) % 10);
    }

    // The main function that uses recursive function isPalUtil() to
    // find out whether num is palindrome or not
    public static boolean isPal(int num)
    {
        // If num is negative, make it positive
        if (num < 0)
            num = -num;

        int dupNum = num; // *dupNum = num

        return isPalUtil(num, dupNum);
    }
}
