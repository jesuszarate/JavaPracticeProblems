/**
 * Created by jesuszarate on 3/3/16.
 */
public class AlgsPracticeTest
{
    public static void main(String args[])
    {
        for (int k = 1; k < 20; k++)
        {
            System.out.println(f(2 * k));
        }
    }
    public static int f (int n) {
        int total = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j+=2) {
                total++;
            } }
        return total;
    }
}
