import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class No2197 {
    public static void main(String[] args) {
        No2197 o = new No2197();
//        System.out.println(o.replaceNonCoprimes(new int[]{6, 4, 3, 2, 7, 6, 2}));//12,7,6
        System.out.println(o.replaceNonCoprimes(new int[]{31, 97561, 97561, 97561, 97561, 97561, 97561, 97561, 97561}));//31,97561
//        System.out.println(97561 * 97561 /97561);
    }

    public List<Integer> replaceNonCoprimes(int[] nums) {

        Stack<Integer> stack = new Stack<>();
        int index = 1;
        stack.add(nums[0]);
        while (index < nums.length) {
//            System.out.println("processing to next index " + index);
            int b = nums[index];
            int lcm = b;
            while (!stack.isEmpty()) {
                int a = stack.pop();
                int gcd = getGCD(a, b);

                if (gcd > 1) {
//                    System.out.printf("lcm %s : %s  ", a, b);
                    b = (int) (((long) (a) * (long) (b)) / (long) (gcd));
//                    b = (a * b) / gcd;
                    lcm = b;
//                    System.out.printf(" >> %s\n", lcm);

                } else {
                    stack.add(a);
                    break;
                }
            }

            stack.add(lcm);
            index++;
        }
        List<Integer> ans = new ArrayList<>();
        while (!stack.isEmpty()) {
            ans.add(0, stack.pop());
        }
        return ans;

    }

    private int getGCD(int a, int b) {
        return b == 0 ? a: getGCD(b, a % b);
    }
} 
