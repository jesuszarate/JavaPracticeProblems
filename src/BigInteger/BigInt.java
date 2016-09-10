package BigInteger;

/**
 * Created by jesuszarate on 9/1/16.
 */
public class BigInt
{
    private int[] bigInteger;

    public BigInt(int[] bigIntegerArray){
        bigInteger = bigIntegerArray;
    }

    public BigInt(String bigInteger){
        this.bigInteger = toIntArray(bigInteger);
    }

    public void setValue(String value){
        bigInteger = toIntArray(value);
    }

    public String getValue(){
        return toString();
    }

    public int getDigitAt(int i){
        return bigInteger[i];
    }

    public int length(){
        return bigInteger.length;
    }


    public String toString()
    {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i : bigInteger)
        {
            stringBuilder.append(i);
        }
        return stringBuilder.toString();
    }

    public int[] toIntArray(String value){
        int[] result = new int[value.length()];
        for (int charInd = 0; charInd < value.length(); charInd++){
            result[charInd] = Character.getNumericValue(value.charAt(charInd));
        }
        return result;
    }

}
