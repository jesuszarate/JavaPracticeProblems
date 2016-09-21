package DominantElements;

/**
 * Created by jesuszarate on 9/16/16.
 */
public class DominantElements
{
    public String findMajority(int[] A, int loA, int hiA)
    {
        if (hiA - loA == 0)
        {
            return "NO";
        }
        else if (hiA - loA == 1)
        {
            return A[loA] + "";
        }
        else
        {
            if(hiA < loA)
            {
                int x = 1;
            }
            int mid = (hiA - loA) / 2;
            String x = findMajority(A, loA, loA + mid);
            String y = findMajority(A, loA + mid + 1, hiA);
            if (x.equals("NO") && y.equals("NO"))
            {
                return "NO";
            }
            else if (x.equals("NO"))
            {
                int count = 0;
                for (int i = loA; i < hiA; i++)
                {
                    if ((A[loA]+"").equals(y))
                    {
                        count++;
                    }
                }
                if (count > (hiA - loA) / 2)
                {
                    return y;
                }
                return "NO";
            }
            else if (y.equals("NO"))
            {
                int count = 0;
                for (int i = loA; i < hiA; i++)
                {
                    if ((A[loA]+"").equals(x))
                    {
                        count++;
                    }
                }
                if (count > (hiA - loA) / 2)
                {
                    return x;
                }
                return "NO";
            }
            else
            {
                int countX = 0;
                int countY = 0;
                for (int i = loA; i < hiA; i++)
                {
                    if ((A[loA]+"").toString().equals(x))
                    {
                        countX++;
                    }
                    else if ((A[loA]+"").toString().equals(y))
                    {
                        countY++;
                    }
                }
                if (countX > (hiA - loA) / 2)
                {
                    return x;
                }
                else if (countY > (hiA - loA) / 2)
                {
                    return y;
                }
                return "NO";
            }
        }
    }


}
