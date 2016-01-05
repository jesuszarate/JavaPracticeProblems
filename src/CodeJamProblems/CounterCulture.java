package CodeJamProblems;

/**
 * Created by Jesus Zarate on 1/4/16.
 *
 * Problem
 *
 * In the Counting Poetry Slam, a performer takes the microphone, chooses a number N, and counts aloud from 1 to N.That
 * is, she starts by saying 1, and then repeatedly says the number that is 1 greater than the previous number she said,
 * stopping after she has said N.
 *
 * It's your turn to perform, but you find this process tedious, and you want to add a twist to speed it up: sometimes,
 * instead of adding 1 to the previous number, you might reverse the digits of the number (removing any leading zeroes
 * that this creates). For example, after saying "16", you could next say either "17" or "61"; after saying "2300", you
 * could next say either "2301" or "32". You may reverse as many times as you want (or not at all) within a performance.
 *
 * The first number you say must be 1; what is the fewest number of numbers you will need to say in order to reach the
 * number N? 1 and N count toward this total. If you say the same number multiple times, each of those times counts
 * separately.
 *
 * Input
 *
 * The first line of the input gives the number of test cases, T. T lines follow. Each has one integer N, the number
 * you must reach.
 *
 * Output
 *
 * For each test case, output one line containing "Case #x: y", where x is the test case number (starting from 1) and
 * y is the minimum number of numbers you need to say.
 *
 * Limits
 *
 * 1 ≤ T ≤ 100.
 * Small dataset
 *
 * 1 ≤ N ≤ 106.
 * Large dataset
 *
 * 1 ≤ N ≤ 1014.
 * Sample
 *
 * Input
 * 3
 * 1
 * 19
 * 23
 *
 * Output
 * Case #1: 1
 * Case #2: 19
 * Case #3: 15
 *
 *
 */
public class CounterCulture
{
    public static void main(String args[])
    {
        String s = "32003";

        s = removeTrailingZeros(s);
        s = flip(s);

        System.out.println(s);

        String input = "3\n" +
                "1\n" +
                "19\n" +
                "23";
        runCounterCulture(input);

        System.out.println(countCulture("1"));
    }
    public static void runCounterCulture(String input)
    {
        String[] lines = input.split("\n");


        int cases = Integer.parseInt(lines[0]);

        int curCase = cases;

        for(int i = 1; i < lines.length; i++)
        {
            //int item = Integer.parseInt(lines[i]);
            System.out.println("Case #" + (cases - curCase--)  + " " + countCulture(lines[i]));
        }

    }

    private static int countCulture(String item)
    {
        int totCount = 0;
        int itemNum = Integer.parseInt(item);
        for(int i = 1; i <= itemNum; i++)
        {
            String currentS = removeTrailingZeros(i + "");
            currentS = flip(currentS);

            int currentInt = Integer.parseInt(currentS);
            if(currentInt > i && currentInt <= itemNum){
                i = currentInt - 1;
            }
            totCount++;
        }
        return totCount;
    }

    private static String removeTrailingZeros (String current)
    {

        for(int i = current.length() - 1; i >= 0; i--)
        {
            if(current.charAt(i) != '0')
                return current;

            current = current.substring(0, i);
        }
        return current;
    }

    private static String flip (String item)
    {
        String result = "";
        for(int i = item.length() - 1; i >= 0; i--)
        {
            result += item.charAt(i);
        }

        return result;
    }
}
