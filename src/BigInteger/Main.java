package BigInteger;

/**
 * Created by jesuszarate on 9/2/16.
 */
public class Main
{
    public static void main(String[] argv){

        BigInt x = new BigInt("123456789123456789");
        BigInt y = new BigInt("123456789123456789");


        BigIntMultiplication multiplication = new BigIntMultiplication();

        System.out.println(multiplication.multiply(x, y).toString());

        int[] xx = new int[]{0, 7};
        int[] yy = new int[]{1, 0};

        xx = new int[]{1,2};
        yy = new int[]{1,2};
        System.out.println(multiplication.karatMult(xx, yy));
    }


}
