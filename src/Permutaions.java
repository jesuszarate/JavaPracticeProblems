import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by jesuszarate on 10/5/15.
 */
public class Permutaions
{
    public static void main(String arg[])
    {
        String ab = "ab";
        System.out.println(ab.substring(0, 0));

        getPerms("abc");
    }

    public static ArrayList<String> getPerms(String remainder){
        int len = remainder.length();
        ArrayList<String> result = new ArrayList<String>();

        // Base Case
        if (len == 0){
            result.add(""); // Be sure to return empty string
            return result;
        }

        for(int i = 0; i < len; i++)
        {
            // Remove char i and find permutations of remaining chars
            String before = remainder.substring(0, i);
            String after = remainder.substring(i + 1, len);
            ArrayList<String> partials = getPerms(before + after);

            // Prepend char i to each permutation
            for(String s : partials)
            {
                result.add(remainder.charAt(i) + s);
            }
        }
        return result;
    }

    class nFactorialPermutation
    {
        ArrayList<String> getPerms(String str)
        {
            if (str == null) return null;

            ArrayList<String> permutations = new ArrayList<String>();

            if (str.length() == 0)
            {
                permutations.add("");
                return permutations;
            }

            char first = str.charAt(0); // Get first char
            String remainder = str.substring(1); // remove the first char
            ArrayList<String> words = getPerms(remainder);

            for (String word : words)
            {
                for (int j = 0; j <= word.length(); j++)
                {
                    String s = insertCharAt(word, first, j);
                    permutations.add(s);
                }
            }
            return permutations;
        }

        public String insertCharAt(String word, char c, int i)
        {
            String start = word.substring(0, i);
            String end = word.substring(i);
            return start + c + end;
        }
    }
}