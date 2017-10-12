package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * <p>
 * Return all possible palindrome partitioning of s.
 * <p>
 * For example, given s = "aab",
 * Return
 * <p>
 * [
 *  ["aa","b"],
 *  ["a","a","b"]
 * ]
 */
public class PalindromePartitioning {

    // a a b
    // aa b
    // a ab
    //

    // aab
    // a ab
    // aa b
    // aab

    public static void main(String[] args){

        System.out.println(partition("aab"));
    }

    public static List<List<String>> partition(String s) {

        List<List<String>> list = new ArrayList<>();
        backtrack(s, list, new ArrayList<>(), 0);
        return list;
    }

    public static void backtrack(String s, List<List<String>> list, List<String> temp, int start){

        if(temp.size() > 0 && !isPalindrome(temp.get(temp.size() - 1))) return;

        if(start == s.length()){
            list.add(new ArrayList<>(temp));
            return;
        }

        for(int i = start; i < s.length(); i++){ // i = 1

            temp.add(s.substring(start, i + 1));
            backtrack(s, list, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public static boolean isPalindrome(String s){

        for(int i = 0; i < s.length()/2; i++){
            if(s.charAt(i) != s.charAt(s.length() - 1 - i)){
                return false;
            }
        }
        return true;
    }

}
