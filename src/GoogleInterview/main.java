package GoogleInterview;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

/**
 * Created by Jesus Zarate on 1/9/16.
 */
public class main
{
    public static void main(String[] args){
        Iterator<Object> iterator = new HashSet<Object>().iterator();
        myIterator itr = new myIterator(iterator);

    }

    /**
     * Number of integers to return, max value
     *
     * collection of unique random integers
     */
    public HashSet<Integer> randomCollection(int numOfInts, int maxVal) throws Exception
    {
        Random r = new Random();

        HashSet<Integer> results = new HashSet<Integer>();
        for(int i = 0; i < numOfInts; i++)
        {
            int temp = r.nextInt(maxVal);
            while (results.contains(temp)){
                temp = r.nextInt(maxVal);
            }
            results.add(temp);
        }

        if(results.size() < numOfInts)
        {
            throw new Exception("Cannot return the specified number of ints");
        }
        return results;
    }

}
