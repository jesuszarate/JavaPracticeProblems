package BigInteger;

import java.lang.reflect.Array;

/**
 * Created by jesuszarate on 9/1/16.
 */
public class BigIntMultiplication
{

    //   34
    // x121
    //------
    //   34
    //  68
    // 34
    //------
    // 4114

    //    34
    // x9211
    // ------
    //    34
    //   34
    //  68
    //306
    //------
    // 4114

    // bottom number is the rows
    // top number is the columns
    //
    // 0 0 3 4
    // 0 6 8 0
    // 3 4 0 0

    // 32
    //
    public BigInt multiply(BigInt x, BigInt y){

        int[] result = new int[x.length() + y.length()];
        int yLastPos = y.length() - 1;
        int xLastPos = x.length() - 1;
        int currPos;

        for(int i = yLastPos; i >= 0; i--){
            for(int j = xLastPos; j >= 0; j--){
                currPos = yLastPos - i + xLastPos - j;
                int currRes = y.getDigitAt(i) * x.getDigitAt(j) + result[currPos];

                if(currRes > 9){
                    int over = currRes;
                    currRes = over % 10;
                    result[currPos + 1] += over / 10;
                }
                result[currPos] = currRes;
            }
        }
        return new BigInt(reverseArray(result));
    }

    public int[] reverseArray(int[] array){
        int temp;
        for(int i = 0; i < array.length/2; i++){
            int opPlace = array.length - i - 1;
            temp = array[i];
            array[i] = array[opPlace];
            array[opPlace] = temp;
        }
        return array;
    }


    public int karatMult(int[] x, int[] y){
        return karatMult(x, y, 0, x.length, 0, y.length);
    }

    private int karatMult(int[] x, int[] y, int xs, int xe, int ys, int ye){

        if(xe == xs){
            return x[xs] * y[ys];
        }

        int n = xe - xs;
        int mid = n/2;
        int xmid = xs + mid;
        int ymid = ys + mid;

        int powNby2 = (int)Math.pow(10, n/2);
        int powN = (int)Math.pow(10, n);

        int first = (karatMult(x, y, xs, xmid - 1, ys, ymid - 1) * powN);
        int second = (karatMult(x, y, xs, xmid - 1, ymid, ye -1 ) + karatMult(x, y, xmid, xe - 1, ys, ymid - 1) * powNby2);
        int third = karatMult(x, y, xmid, xe - 1, ymid, ye - 1);

        return first + second + third;

    }

}
