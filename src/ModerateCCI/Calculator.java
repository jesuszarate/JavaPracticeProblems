package ModerateCCI;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by jesuszarate on 7/13/17.
 */
public class Calculator {

    static Stack<Double> st = new Stack<>();
    static Stack<Character> ops = new Stack<>();

    public static void main(String[] args) {
        System.out.println(calculator("2*3+5/6*3+15"));
    }

    static double performOp(String num, char c) {
        double curr = Double.parseDouble(num);
        if (!ops.empty()) {
            if (ops.peek() == '*') {
                curr = st.pop() * curr;
            } else if (ops.peek() == '/') {
                curr = st.pop() / curr;
            } else if (ops.peek() == '-') {
                curr *= -1;
            }
            ops.pop();
        }
        st.push(curr);
        ops.push(c);
        return curr;
    }

    static double calculator(String s) {
        String num = "";
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (Character.isDigit(c)) {
                num += c;
            } else {
                performOp(num, c);
                num = "";
            }
        }
        double curr = performOp(num, '\0');

        double sum = 0;
        while (!st.empty()) {
            sum += st.pop();
        }
        return sum;
    }
}
