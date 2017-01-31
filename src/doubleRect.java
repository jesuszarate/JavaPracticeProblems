import java.util.concurrent.Callable;

/**
 * Created by jesuszarate on 1/10/17.
 */
public class doubleRect {

    public static void main(String[] argv){
        System.out.println(fact(5));
    }

    public static int fact(int x){
        if(x == 1){
            return 1;
        }

        if(x == 0){
            return 1;
        }

        return x + fact(x - 1) + fact(x - 2);
    }
}
