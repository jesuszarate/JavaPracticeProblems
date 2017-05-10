package ModerateCCI;

import java.util.HashMap;

/**
 * Created by jesuszarate on 5/10/17.
 */
public class EnglishInt {
    static HashMap<Integer, String> numMap;
    static HashMap<Integer, String> placeMap;

    public static void main(String[] a){
        placeMap = new HashMap<Integer, String>();
        placeMap.put(100, "hundred");
        placeMap.put(1000, "thousand");

        numMap = new HashMap<Integer, String>();
        numMap.put(1, "one");
        numMap.put(2, "two");
        numMap.put(3, "three");
        numMap.put(4, "four");
        numMap.put(5, "five");
        numMap.put(6, "six");
        numMap.put(7, "seven");
        numMap.put(8, "eight");
        numMap.put(9, "nine");
        numMap.put(10, "ten");
        numMap.put(11, "eleven");
        numMap.put(12, "twelve");
        numMap.put(13, "thirteen");
        numMap.put(14, "fourteen");
        numMap.put(15, "fifteen");
        numMap.put(16, "sixteen");
        numMap.put(17, "seventeen");
        numMap.put(18, "eighteen");
        numMap.put(19, "nineteen");
        numMap.put(20, "twenty");
        numMap.put(30, "thirty");
        numMap.put(40, "fourty");
        numMap.put(50, "fifty");
        numMap.put(60, "sixty");
        numMap.put(70, "seventy");
        numMap.put(80, "eighty");
        numMap.put(90, "ninety");

        System.out.println(engInt(1132));
        System.out.println(engInt(5));
        System.out.println(engInt(101));
        System.out.println(engInt(0));

    }



    static String engInt(int num){
        return num == 0 ? "zero" : engInt(num, 1);
    }

    static String engInt(int num, int pos){

        int n = pos * 10;
        int curr = (num % n) / pos;

        String word = (curr * pos) < 100 ? numMap.get(curr * pos) : numMap.get(curr);

        if(curr * pos < 100){
            word = numMap.get(curr * pos) != null ? numMap.get(curr * pos) : "";
        }
        else word = numMap.get(curr) != null ? numMap.get(curr) + " " : "";

        word += placeMap.get(pos) != null ? placeMap.get(pos) : "";

        if (num % n == num) return word;

        return engInt(num, n) + " " + word;
    }
}
