package DominantElements;

/**
 * Created by jesuszarate on 9/16/16.
 */
public class DominantElementsMain
{
    public static void main(String[] argv){

        DominantElements dominantElements = new DominantElements();

        int[] A = new int[]{1, 2, 3, 1, 2, 1, 4, 1, 1};
        //System.out.println(dominantElements.findMajority(A, 0, A.length-1));

        MajorityElements majorityElements = new MajorityElements();

        System.out.println(majorityElements.majority(A, "None"));
    }
}
