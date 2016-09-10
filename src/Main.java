import java.sql.*;
import java.util.HashMap;


/**
 * Created by Jesus Zarate on 9/8/15.
 */
public class Main
{

    public static void main(String args[])
    {
        Statement statement;
        try
        {
            Connection connection = DriverManager.getConnection ("", "", "");
            statement = connection.createStatement();

            //PreparedStatement preparedStatement = connection.prepareStatement();

        } catch (SQLException e)
        {
            e.printStackTrace();
        }


        System.out.println(ReverseString.compute2("hello world how are you"));
        System.out.println(IsNumPalindrome.isPal(12321));

        // Test ReverseWords
        String result = ReverseWords.reverse("this is a test");
        System.out.println(result);
        System.out.print(result.equals("test a is this") ? "Correct" : "Incorrect");
    }
}
