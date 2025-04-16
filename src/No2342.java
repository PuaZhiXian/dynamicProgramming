import javafx.util.Pair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No2342 {
    public static void main(String[] args) {
        No2342 obj = new No2342();
        System.out.println(obj.maximumSum(new int[]{18, 43, 36, 13, 7}));
    }

    public int maximumSum(int[] nums) {
        int ans = -1;
        Map<Integer, Model> map = new HashMap<>();
        Map<Integer, Integer> sum = new HashMap<>();


        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            int curDigit = sumDigits(cur);

            Model m = map.getOrDefault(curDigit, new Model());
            if (m.num1 == 0) {
                m.num1 = cur;
            } else if (m.num2 == 0) {
                m.num2 = cur;
                sum.put(curDigit, m.num1 + m.num2);
            } else {
                int min = Math.min(cur, Math.min(m.num1, m.num2));
                if (m.num1 == min) {
                    sum.put(curDigit, sum.get(curDigit) - m.num1 + cur);
                    m.num1 = cur;
                } else if (m.num2 == min) {
                    sum.put(curDigit, sum.get(curDigit) - m.num2 + cur);
                    m.num2 = cur;
                }
            }
            map.put(curDigit, m);
        }

        for (Integer num : sum.values()) {
            ans = Math.max(ans, num);
        }


        return ans;
    }

    public static int sumDigits(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;  // Extract the last digit and add to sum
            num /= 10;         // Remove the last digit
        }
        return sum;
    }

    class Model {

        int num1;
        int num2;
    }


}
