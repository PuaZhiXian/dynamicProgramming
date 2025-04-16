import java.util.Arrays;
import java.util.Stack;

public class No1190 {
    public static void main(String[] args) {
        System.out.println(reverseParentheses("(ed(et(oc))el)"));
        System.out.println(reverseParentheses("(h(eee)o)"));
//        System.out.println(reverseParentheses("(hello)"));
    }

    public static String reverseParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int[] bracketPointer = new int[s.length()];
        int[] visited = new int[s.length()];
        Arrays.fill(bracketPointer, -1);

        //get bracket
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.add(i);
            } else if (s.charAt(i) == ')') {
                int correspondingOpenBracket = stack.pop();
                bracketPointer[i] = correspondingOpenBracket;
                bracketPointer[correspondingOpenBracket] = i;
            }
        }

        //reverse operation
        int direction = 1;
        int index = 0;
        while (index < s.length() && index >= 0) {
            if (s.charAt(index) == '(') {
                if (visited[bracketPointer[index]] != 1) {
                    direction = -1;
                    visited[bracketPointer[index]] = 1;
                } else {
                    direction = 1;
                }

                index = bracketPointer[index];
            } else if (s.charAt(index) == ')') {
                if (visited[bracketPointer[index]] != 1) {
                    direction = 1;
                    visited[bracketPointer[index]] = 1;
                } else {
                    direction = -1;
                }

                index = bracketPointer[index];
            } else {
                result.append(s.charAt(index));
            }
            index += direction;
        }

        return result.toString();
    }
}
