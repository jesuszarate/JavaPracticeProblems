package CodeJamProblems;

/**
 * Created by Jesus Zarate on 1/1/16.
 *
 *
 * Problem
 *
 * You receive a credit C at a local store and would like to buy two items. You first walk through the store and create
 * a list L of all available items. From this list you would like to buy two items that add up to the entire value of
 * the credit. The solution you provide will consist of the two integers indicating the positions of the items in your
 * list (smaller number first).
 *
 * Input
 *
 * The first line of input gives the number of cases, N. N test cases follow. For each test case there will be:
 *
 * One line containing the value C, the amount of credit you have at the store.
 * One line containing the value I, the number of items in the store.
 * One line containing a space separated list of I integers. Each integer P indicates the price of an item in the store.
 * Each test case will have exactly one solution.
 * Output
 *
 * For each test case, output one line containing "Case #x: " followed by the indices of the two items whose price adds
 * up to the store credit. The lower index should be output first.
 *
 * Limits
 *
 * 5 ≤ C ≤ 1000
 * 1 ≤ P ≤ 1000
 *
 * Small dataset
 * N = 10
 * 3 ≤ I ≤ 100
 *
 * Large dataset
 * N = 50
 * 3 ≤ I ≤ 2000
 *
 * Sample
 *
 * Input:
 * 3
 * 100
 * 3
 * 5 75 25
 * 200
 * 7
 * 150 24 79 50 88 345 3
 * 8
 * 8
 * 2 1 9 4 4 56 90 3
 *
 * Output:
 * Case #1: 2 3
 * Case #2: 1 4
 * Case #3: 4 5
 */
public class StoreCredit
{
    public static void main(String[] args){
        String input = "3\n" +
                "100\n" +
                "3\n" +
                "5 75 25\n" +
                "200\n" +
                "7\n" +
                "150 24 79 50 88 345 3\n" +
                "8\n" +
                "8\n" +
                "2 1 9 4 4 56 90 3";
        parseData(input);
    }

    public static void parseData(String input){

        // Split by line
        String[] lines = input.split("\n");
        int c = 3;

        try
        {
            // First line gives number of cases
            int cases = Integer.parseInt(lines[0]);


            for(int item = 1; item < lines.length; item+=3)
            {
                // Second line gives the credit
                int credit = Integer.parseInt(lines[item]);

                // Number of items in the store
                int numOfItems = Integer.parseInt(lines[item+1]);

                // Price of items in the store
                String[] itemsS = lines[item+2].split(" ");

                int[] items = new int[itemsS.length];
                for (int i = 0; i < itemsS.length; i++)
                {
                    items[i] = Integer.parseInt(itemsS[i]);
                }

                String itms = getItems(credit, numOfItems, items);
                System.out.println("Case #" + (cases - c--) + " " + itms);
            }

        }
        catch (Exception e){
            System.out.println("Could not parse line to integer");
        }
    }

    private static String getItems(int credit, int numOfItems, int[] items)
    {
        StringBuilder stringBuilder = new StringBuilder();

        for(int currItem = 0; currItem < numOfItems; currItem++)
        {
            if (items[currItem] > credit)
                continue;
            for (int i = currItem + 1; i < numOfItems; i++)
            {
                if(i == currItem)
                    continue;

                if ((items[currItem] + items[i]) == credit)
                    return stringBuilder.append(currItem + 1).
                            append(" ").append(i + 1).toString();
            }
        }
        return null;
    }
}
