import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by jesuszarate on 12/22/15.
 */
public class Equalibrium
{

    public static void main(String args[])
    {
        int[] A = new int[]{-1, 3, -4, 5, 1, -6, 2, 1};
        int a = 1234;
        a = 12511;
        a = -12511;

        String s = "dir1\n" +
                " dir11\n" +
                " dir12\n" +
                "  picture.jpeg\n" +
                "  dir121\n" +
                "  file1.txt\n" +
                "dir2\n" +
                " file2.gif";
        System.out.println(solution(a));
        System.out.println(solution2(s));
    }

    public static int solution(int X)
    {
        boolean isNeg = false;
        if (X < 0)
        {
            X = Math.abs(X);
            isNeg = true;
        }

        String num = X + "";

        int max = X;

        for (int i = 0; i < num.length(); i++)
        {
            String upper;
            upper = num.substring(0, i);

            String lower = num.substring(i, num.length());

            int current = Integer.parseInt(upper + num.charAt(i) + lower);

            current = isNeg ? current * -1 : current;
            if (i == 0)
            {
                max = current;
            }
            else if (current > max)
            {
                max = current;
            }
        }
        return max;
    }

    public static int solution2(String S)
    {
        ArrayList<Node> dirs = new ArrayList<Node>();

        // Split them by line
        String[] depth = S.split("\n");


        Node current = new Node();
        for (int i = 0; i < S.length(); i++)
        {
            //dirs.aa
            //if(S.charAt(i) == '\n')

        }

        return -1;
    }

    public static class Node
    {
        String parent;
        String[] children;
    }
}
