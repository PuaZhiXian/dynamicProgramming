import java.util.Arrays;
import java.util.Stack;

public class No735 {
    public static void main(String[] args) {
        System.out.println((Arrays.toString(asteroidCollision(new int[]{5, 10, -5}))));
    }

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();


        for (int i = 0; i < asteroids.length; i++) {
            if (stack.isEmpty()) {
                stack.add(asteroids[i]);
            } else {
                if (isPositive(asteroids[i])) {
                    stack.add(asteroids[i]);
                } else {
                    if (isPositive(stack.peek())) {
                        if (Math.abs(asteroids[i]) > stack.peek()) {
                            stack.pop();
                            i--;
                        } else if (Math.abs(asteroids[i]) == stack.peek()) {
                            stack.pop();
                        }
                    } else {
                        stack.add(asteroids[i]);
                    }
                }
            }
        }

        int l = stack.size();
        int[] result = new int[l];
        while (!stack.isEmpty()) {
            result[--l] = stack.pop();
        }
        return result;
    }

    public static boolean isPositive(int val) {
        return val > 0;
    }
}
