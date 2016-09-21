package DominantElements;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Created by jesuszarate on 9/17/16.
 */
public class MajorityElements
{
    public String majority(int[] data, String oddOneOut)
    {
        int length = data.length;
        if (length == 0)
        {
            return "NO";
        }

        // If length is odd
        if (length % 2 == 1)
        {
            oddOneOut = data[length-1] + "";
        }

        int[] pairs = getPairs(data);

        String major = majority(pairs, oddOneOut);

        if (major.equals("NO"))
        {
            return oddOneOut;
        }

        int count = getCount(data, major);

        if (2 * count > length || (2 * count == length && major.equals(oddOneOut)))
        {
            return major;
        }

        return "NO";
    }

    public int[] getPairs(int[] data){
        ArrayList<Integer> pairs = new ArrayList<Integer>();
        for (int i = 0; i < data.length - 1; i += 2)
        {
            if (data[i] == data[i + 1])
            {
                pairs.add(data[i]);
            }
        }
        return toArray(pairs);
    }

    public int getCount(int[] data, String majority){
        int count = 0;
        for (int i : data)
        {
            if ((i + "").equals(majority))
            {
                count++;
            }
        }
        return count;
    }

    public int[] toArray(ArrayList<Integer> list){
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }
}
