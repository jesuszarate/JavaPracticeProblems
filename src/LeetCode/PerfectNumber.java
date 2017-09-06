package LeetCode;

public class PerfectNumber {

    public static void main(String[] a) {
        System.out.println((checkPerfectNumber(28)));
    }

    public static boolean checkPerfectNumber(int num) {
        if (num == 1) return false;

        int sum = 0;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                sum += i;
                if (i != num / i) {
                    sum += num / i;
                }
            }
        }
        sum++;

        return sum == num;
    }


}
