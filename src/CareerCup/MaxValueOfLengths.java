package CareerCup;

/**
 * Created by Jesus Zarate on 1/7/16.
 *
 * Given an array of words (i.e. ["ABCW", "BAZ", "FOO", "BAR", "XTFN", "ABCDEF"]), find the max value of
 * length(s) * length(t), where s and t are words from the array. The catch here is that the two words cannot share
 * any characters.
 *
 * Assume that there are many words in the array (N words) and average length of word is M.
 *
 * Answer for the example above is "ABCW" and "XTFN" as the result is 4 * 4 = 12.
 *
 * "ABCW" and "ABCDEF" do not work since they share similar characters.
 *
 *
 */
public class MaxValueOfLengths
{
    public static void main(String[] args)
    {
        String[] arr = new String[]{"ABCW", "BAZ", "FOO", "BAR", "XTFN", "ABCDEF"};

        System.out.println(findMax(arr));
    }

    public static int findMax(String[] words)
    {
        int max = 0;
        int tempMax = 0;
        for (int i = 0; i < words.length; i++)
        {
            String currentWord = words[i];

            for(int j = i + 1; j < words.length; j++)
            {
                if(checkSimilarity(currentWord, words[j]))
                {
                    tempMax = currentWord.length() * words[j].length();
                    if(tempMax > max)
                    {
                        max = tempMax;
                        System.out.println(currentWord + " & " + words[j]);
                    }
                }

            }
        }
        return max;
    }

    private static boolean checkSimilarity(String currentWord, String nextWord)
    {
        for(int i = 0; i < currentWord.length(); i++)
        {
            if(nextWord.contains(currentWord.charAt(i) + "")){
                return false;
            }
        }
        return true;
    }


}
