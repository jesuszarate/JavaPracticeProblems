import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Jesus Zarate on 9/20/15.
 */
public class Part4
{
    public static void main(String args[])
    {
        Scanner s = new Scanner(System.in);

        String input = "";
        while(s.hasNext())
        {
            input += s.nextLine() + "\n";
        }

        Pattern p = Pattern.compile("(\"(\\.)*.*?(\\.)*(?<!\\\\)\")|(\"(\\.)*.*?(\\.)*(?<=\\\\\\\\)\")");

        Matcher m = p.matcher(input);
        String output = "";
        while(m.find())
        {
            if(m.group() != null)
                output += m.group() + "\n";
            else
                output += m.group(4) + "\n";
        }

        System.out.println(output);
    }
}
