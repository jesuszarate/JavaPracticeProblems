package LeetCode;

public class BinaryNumberWithAlternatingBit {

    public static void main(String[] argv){
        System.out.println(hasAlternatingBits(5));
        System.out.println(hasAlternatingBits(7));
    }


    public static boolean hasAlternatingBits(int n) {

        int mask = 1;
        int current = (n & mask);
        n = n >> 1;
        while(n != 0){
            if(current == (n & mask)){
                return false;
            }
            current = (n & mask);
            n = n >> 1;
        }
        return true;
    }
}
