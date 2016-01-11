package GoogleInterview;

/**
 * Created by Jesus Zarate on 1/11/16.
 *
 * Given an integer print every positive integer that is either divisible by 5 or 6
 */
public class Divisibleby5or6
{

    /**
     * Able to use % (modulus)
     * @param num
     * @return
     */
    public void withMod(int num)
    {
        for(int i = 1; i <= num; i++){
            if(num % 5 == 0 || num % 6 == 0){
                print(i, num);
            }
        }
    }

    /**
     * Not able to use % (modulus)
     * @param num
     * @return
     */
    public void withOutMod(int num)
    {
        int fives = 5;
        int sixes = 6;
        for(int i = 1; i <= num; i++){
            if(num == fives)
            {
                print(i, num);
                if(fives == sixes)
                    sixes+=6;

                fives+=5;
            }
            else if(num == sixes)
            {
                print(i, num);
                sixes+=6;
            }
        }
    }

    private void print(int i, int num){
        if(i != num) System.out.println(i + ", ");
        else System.out.println(i);
    }
}
