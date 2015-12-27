import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jesuszarate on 9/23/15.
 */
public class Part1
{
    public static void main(String args[])
    {
        Scanner s = new Scanner(System.in);

        Pattern p = Pattern.compile("\\b\\d\\d\\d\\-\\d\\d\\-\\d\\d\\d\\d\\b");

        String input = "";
        while(s.hasNext())
        {
            input += s.nextLine() + "\n";
        }

        System.out.println(p.matcher(input).replaceAll("###-##-####"));
    }
}
