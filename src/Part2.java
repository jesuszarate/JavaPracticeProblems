import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by jesuszarate on 9/23/15.
 */
public class Part2
{
    public static void main(String args[]){

        Scanner s = new Scanner(System.in);

        Pattern p = Pattern.compile("//.*");

        String line = "";
        while(s.hasNextLine())
        {
            line += s.nextLine() + "\n";
        }

        System.out.println(p.matcher(line).replaceAll(""));
    }
}
