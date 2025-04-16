import java.util.Stack;

public class No2211 {
    public static void main(String[] args) {
//        System.out.println(new No2211().countCollisions("RLRSLL"));
//        System.out.println(new No2211().countCollisions("LLRR"));
        System.out.println(new No2211().countCollisions("RRRS"));
//        System.out.println(new No2211().countCollisions("SSRSSRLLRSLLRSRSSRLRRRRLLRRLSSRR"));
    }

    public int countCollisions(String directions) {
        int result = 0;
        Stack<Character> stack = new Stack<>();

        char[] chars = directions.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (stack.isEmpty()) {
                stack.add(chars[i]);
                continue;
            }

            char cur = chars[i];

            if (cur == 'R') {
                stack.add('R');
            } else if (cur == 'S') {
                if (stack.peek() == 'R') {
                    stack.pop();
                    i--;
                    result = result + 1;
                } else {
                    stack.add('S');
                }
            } else {
                if (stack.peek() == 'R') {
                    result = result + 2;
                    chars[i] = 'S';
                    i--;
                    stack.pop();
                }else{
                    stack.add('L');
                }
            }
        }

        return result;
    }
}
