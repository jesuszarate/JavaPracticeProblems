/**
 * Created by jesuszarate on 10/7/15.
 */
public class ThreadExample implements Runnable
{
    int count = 0;

    @Override
    public void run()
    {
        System.out.println("Starting thread");

        try{
            while(count < 5){
                Thread.sleep(500);
                System.out.println("In thread, count is " + count);
                count++;
            }
        }catch (InterruptedException e){
            System.out.println("Thread interrupted");
        }
        System.out.println("Thread terminating");
    }
}
