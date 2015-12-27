import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jesuszarate on 9/26/15.
 */
public class IsSentencePalindrome
{
    public static void main(String args[])
    {
        System.out.println(isPal("ca ab b aa c"));
        System.out.println(isPal("ca,a c"));
        System.out.println(isPal("A man, a plan, a cat, a ham, a yak, a yam, a hat, a canal-Panama!"));
        System.out.println(isPal("A new order began, a more Roman age bred Rowena."));
        System.out.println(isPal("A new order began, a more Roman age bred Rowena."));
    }

    public static boolean isPal(String word){
        word = word.toLowerCase();
        int len = word.length();

        Pattern pattern = Pattern.compile("[a-zA-Z0-9]");

        for(int i = 0,  j = len - 1; i < j; i++, j--)
        {
            if(i == j) return  true;

            while (!pattern.matcher(word.charAt(i)+"").matches())
            {
                i++;
            }

            while(!pattern.matcher(word.charAt(j)+"").matches())
            {
                j--;
            }

            if(word.charAt(i) != word.charAt(j)){
                return false;
            }
        }

        return true;
    }
}
