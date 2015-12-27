/**
 * Created by jesuszarate on 10/7/15.
 */
public class Threads
{
    public static void main(String args[])
    {
        ThreadExample obj1 = new ThreadExample();
        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj1);

        t1.start();
        t2.start();


        int[] i = new int[5];

        int in = i.length;

    }
}