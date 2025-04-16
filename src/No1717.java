import java.util.Stack;

public class No1717 {
    public static void main(String[] args) {
    }

    public static int maximumGain(String s, int x, int y) {
        int result = 0;
        Stack<Character> stack = new Stack<>();
        boolean isAB = x > y;

        stack.add((s.charAt(0) == 'b' || s.charAt(0) == 'a') ? s.charAt(0) : '0');
        for (int i = 1; i < s.length(); i++) {
            if (isAB) {
                if (s.charAt(i) == 'b') {
                    if (!stack.isEmpty() && stack.peek() == 'a') {
                        stack.pop();
                        result += x;
                    } else {
                        stack.add(s.charAt(i));
                    }
                } else if (s.charAt(i) == 'a') {
                    stack.add('a');
                } else {
                    if (!stack.isEmpty() && stack.peek() != '0') {
                        stack.add('0');
                    }
                }
            } else {
                if (s.charAt(i) == 'a') {
                    if (!stack.isEmpty() && stack.peek() == 'b') {
                        stack.pop();
                        result += y;
                    } else {
                        stack.add(s.charAt(i));
                    }
                } else if (s.charAt(i) == 'b') {
                    stack.add('b');
                } else {
                    if (!stack.isEmpty() && stack.peek() != '0') {
                        stack.add('0');
                    }
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.insert(0, stack.pop());
        }
        isAB = !isAB;
        if (stringBuilder.length() == 0) {
            return result;
        }
        stack.add(stringBuilder.charAt(0));
        for (int i = 1; i < stringBuilder.length(); i++) {
            if (isAB) {
                if (stringBuilder.charAt(i) == 'b') {
                    if (!stack.isEmpty() && stack.peek() == 'a') {
                        stack.pop();
                        result += x;
                    } else {
                        stack.add(stringBuilder.charAt(i));
                    }
                } else if (stringBuilder.charAt(i) == 'a') {
                    stack.add('a');
                } else {
                    if (!stack.isEmpty() && stack.peek() != '0') {
                        stack.add('0');
                    }
                }
            } else {
                if (stringBuilder.charAt(i) == 'a') {
                    if (!stack.isEmpty() && stack.peek() == 'b') {
                        stack.pop();
                        result += y;
                    } else {
                        stack.add(stringBuilder.charAt(i));
                    }
                } else if (stringBuilder.charAt(i) == 'b') {
                    stack.add('b');
                } else {
                    if (!stack.isEmpty() && stack.peek() != '0') {
                        stack.add('0');
                    }
                }
            }
        }

        return result;
    }

}
