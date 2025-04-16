import java.util.Arrays;
import java.util.Stack;

public class No394 {
    public static int[] bracket;

    public static void main(String[] args) {
        System.out.println(new No394().decodeString("3[a]2[bc]"));
    }

    public String decodeString(String s) {
        bracket = new int[s.length()];
        Stack<Integer> openBracket = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                openBracket.add(i);
            } else if (s.charAt(i) == ']') {
                int openIndex = openBracket.pop();
                bracket[openIndex] = i + 1;
            }
        }

        System.out.println(Arrays.toString(bracket));

        for (int i = 0; i < s.length(); i++) {
            if (bracket[i] != 0) {
                System.out.println(s.substring(i + 1, bracket[i] - 1));
                i = bracket[i] - 1;
            }
        }
        return "";
    }

    public String helper(String s) {

        return "";
    }
}
