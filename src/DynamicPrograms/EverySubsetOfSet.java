package DynamicPrograms;

import java.util.HashSet;

/**
 * Created by Jesus Zarate on 1/6/16.
 *
 * Get every subset of a set.
 *
 */
public class EverySubsetOfSet
{
    public static void main(String[] args)
    {

    }

    public static int[] getSubstrings(int[] set)
    {
        HashSet<Integer> subSet = new HashSet<Integer>();
        HashSet<Integer> temp = new HashSet<Integer>();

        for(int i = 0; i < set.length; i++)
        {
            for(int j = 0; j < set.length; j++)
            {
                for (int ss : subSet)
                {
                    //temp.add();
                }
            }
        }
        return  null;
    }
}
