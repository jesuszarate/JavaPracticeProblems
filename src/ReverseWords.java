/**
 * Created by Jesus Zarate on 12/28/15.
 *
 */
public class ReverseWords
{
    public static String reverse(String lst){

        String[] separatedWords = lst.split(" ");

        StringBuilder result = new StringBuilder(lst.length());

        for(int i = separatedWords.length - 1; i >= 0; i--)
        {
            if(i == 0)
                result.append(separatedWords[i]);
            else
                result.append(separatedWords[i]).append(" ");
        }

        return result.toString();
    }


}
