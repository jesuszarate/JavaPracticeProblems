package HackerRank.LarrysArray.NaturalLanguageTranslator;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static Map<Integer, String> trans;

    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */

        initMap();
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();

        // Make sure it's a number
        int num = Integer.parseInt(line);

        StringBuilder translation = new StringBuilder();

        translate(num, line.length(), translation);

        System.out.println(translation.toString());
    }

    public static void translate(int num, int length, StringBuilder translation){
        if (num == 0){
            translation.append("Zero");
            return;
        }
        for(int i = length - 1; i >= 0; i--){
            if(num <= 20){
                translation.append(trans.get(num));
               break;
            }
            int mult = (int)Math.pow(10, i);
            if(mult >= 10000){

                translate(num / 1000, (num/1000+"").length(), translation);
                translation.append(" ");
                translation.append(trans.get(1000));
                translation.append(" ");

                num = num % 1000;
                i = (num +"").length();
                continue;
            }

            int toWord = num / mult;
            num = num % mult;


            if((num * mult) >= 100)
            {
                translation.append(trans.get(toWord));

                translation.append(" ");
                translation.append(trans.get(mult));
                translation.append(" ");
            }
            else {
                translation.append(trans.get(toWord * mult));
                translation.append(" ");
            }
        }

    }

    public static void initMap(){
        if(trans == null){
            trans = new HashMap<Integer, String>();
            trans.put(0, "");
            trans.put(1, "One");
            trans.put(2, "Two");
            trans.put(3, "Three");
            trans.put(4, "Four");
            trans.put(5, "Five");
            trans.put(6, "Six");
            trans.put(7, "Seven");
            trans.put(8, "Eight");
            trans.put(9, "Nine");
            trans.put(10, "Ten");
            trans.put(11, "Eleven");
            trans.put(12, "Twelve");
            trans.put(13, "Thirteen");
            trans.put(14, "Fourteen");
            trans.put(15, "Fifteen");
            trans.put(16, "Sixteen");
            trans.put(17, "Seventeen");
            trans.put(18, "Eighteen");
            trans.put(19, "Nineteen");
            trans.put(20, "Twenty");
            trans.put(30, "Thirty");
            trans.put(40, "Forty");
            trans.put(50, "Fifty");
            trans.put(60, "Sixty");
            trans.put(70, "Seventy");
            trans.put(80, "Eighty");
            trans.put(90, "Ninety");

            trans.put(100, "Hundred");
            trans.put(1000, "Thousand");

//            trans.put(200, "Nineteen");
//            trans.put(300, "Nineteen");
//            trans.put(400, "Nineteen");
//            trans.put(500, "Nineteen");
//            trans.put(600, "Nineteen");
//            trans.put(700, "Nineteen");
//            trans.put(800, "Nineteen");
//            trans.put(900, "Nineteen");
//            trans.put(1000, "Nineteen");
//            trans.put(2000, "Nineteen");
//            trans.put(3000, "Nineteen");
//            trans.put(4000, "Nineteen");
//            trans.put(5000, "Nineteen");
//            trans.put(6000, "Nineteen");
//            trans.put(7000, "Nineteen");
//            trans.put(8000, "Nineteen");
//            trans.put(9000, "Nineteen");





        }
    }

}