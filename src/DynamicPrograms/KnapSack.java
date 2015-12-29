package DynamicPrograms;

/**
 * Created by Jesus Zarate on 12/29/15.
 *
 * Dynamic solution to the knapsack problem
 */
public class KnapSack
{

    public int knapSack(int[] items, int[] weights, int[] values)
    {
        int[][] data = new int[items.length][items.length];
        for (int item = 1; item < items.length; item++){
            for (int weight = 1; weight < weights.length; weight++)
            {

            }
        }
        return data[items.length - 1][weights.length - 1];
    }
}
