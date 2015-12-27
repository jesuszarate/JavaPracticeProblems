/**
 * Created by Jesus Zarate on 9/8/15.
 */
public class ReverseString
{
    public static String[] compute(String expression)
    {
        int length = expression.length();
        String[] rest = new String[length];

        for (int i = 0; i < expression.length(); i++)
        {

            rest[i] = expression.charAt((length - 1) - i) + "";
        }
        return rest;
    }

    public static char[] compute2(String expression)
    {
        int length = expression.length();
        char arr[] = expression.toCharArray();

        for(int i = 0, j = length - 1; i < j; i++, j--)
        {
            if(arr[i] == ' ')
                i++;
            if(arr[j] == ' ')
                j--;

            char tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }

        //System.out.print(arr);
        return arr;
    }
}
