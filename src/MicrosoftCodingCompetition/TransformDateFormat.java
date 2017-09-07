package MicrosoftCodingCompetition;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TransformDateFormat {

    public static void main(String[] args) {

        BufferedReader br = null;
        FileReader fr = null;

        try {

            fr = new FileReader("PracticeInput.txt");
            br = new BufferedReader(fr);

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {

                formatLine(sCurrentLine);

            }

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (br != null)
                    br.close();

                if (fr != null)
                    fr.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }
    }

    private static void formatLine(String line) {
        String[] input = line.split(" ");

        HashMap<String, Integer> currFormat = getFormatPositions(input[1]);
        HashMap<String, Integer> newFormat = getFormatPositions(input[2]);

        String del = getDelimeter(input[1]);

        String[] date = null;
        if (del.equals("*") || del.equals("\\") || del.equals("#")) {
            date = input[0].split("\\* | \\\\ | \\#");
        } else {
            date = input[0].split(del);
        }

        String res = input[2];
        for (Map.Entry<String, Integer> entry : newFormat.entrySet()) {
            String k = entry.getKey();
            Integer v = entry.getValue();

            if (v >= 0) {
                String rep = input[0].substring(currFormat.get(k), currFormat.get(k) + k.length());
                res = res.replace(k, rep);
            }
        }
    }

    private static HashMap<String, Integer> getFormatPositions(String input) {
        HashMap<String, Integer> res = new HashMap<String, Integer>();
        res.put("mm", input.indexOf("mm"));
        res.put("dd", input.indexOf("dd"));
        res.put("yyyy", input.indexOf("yyyy"));

        return res;
    }

    public static String getDelimeter(String input) {
        int month = input.indexOf("mm");
        int day = input.indexOf("dd");
        int year = (input.indexOf("yyyy"));

        if (day == 0 || month == 0) return input.charAt(2) + "";
        else return input.charAt(4) + "";


    }
}
