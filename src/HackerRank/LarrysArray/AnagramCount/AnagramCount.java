package HackerRank.LarrysArray.AnagramCount;

import java.util.Arrays;

import static java.util.Arrays.*;

/**
 * Created by jesuszarate on 2/5/17.
 */
public class AnagramCount {

    public static void main(String[] a){
        System.out.println(numberNeeded("abc", "cde"));
        System.out.println(numberNeeded("alloha", "hello"));
        System.out.println(numberNeeded("hi", "hello"));

    }

    public static int numberNeeded(char[] first, char[] second, int fPos, int sPos) {// abc, cde, 3, 1

        // f.len = 3
        // s.len = 3
        // Base case when I get to one of the strings reaching the length
        if(first.length <= fPos){
            return second.length - sPos; // 3 - 1 = 2
        }
        else if (second.length <= sPos){
            return first.length - fPos;
        }

        if(first[fPos] != second[sPos]){ // charAt(fpos) = c, charAt(spos) = c
            if(first[fPos] < second[sPos]){// b < c
                fPos++;
                return 1 + numberNeeded(first, second, fPos, sPos);
            }
            else{
                sPos++;
                return 1 + numberNeeded(first, second, fPos, sPos);
            }
        }

        // Meaning they’re equal so don’t increment count
        return numberNeeded(first, second, ++fPos, ++sPos);
    }

    public static int numberNeeded(String first, String second) {
        //Sort the string first
        char[] fchar = first.toCharArray();
        char[] schar = second.toCharArray();
        Arrays.sort(fchar);
        Arrays.sort(schar);
        return numberNeeded(fchar, schar, 0, 0);
    }

}
