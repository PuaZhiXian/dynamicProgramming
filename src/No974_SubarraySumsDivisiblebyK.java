import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class No974_SubarraySumsDivisiblebyK {
    public static void main(String[] args) {
//        System.out.println(subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5));
        System.out.println(subarraysDivByK(new int[]{-1, 2, 9}, 2));
//        System.out.println(subarraysDivByK(new int[]{2, -2, 2, -4}, 6));
    }

    public static int subarraysDivByK(int[] nums, int k) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int[] cum = new int[nums.length];
        cum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            cum[i] = nums[i] + cum[i - 1];
        }
        System.out.println(Arrays.toString(cum));
        for (int i = 0; i < cum.length; i++) {
            cum[i] = cum[i] % k;
            int cnt = map.getOrDefault(cum[i], 0);
            map.put(cum[i], cnt + 1);
        }
        System.out.println(Arrays.toString(cum));

        for (Integer val : map.values()) {
            if (val > 1) {
                sum = sum + (int) ((Math.pow(val, 2) + val) / 2) - val;
            }
        }
        if (map.get(0) != null && map.get(0) == 1) {
            sum++;
        }
        return sum;
    }
}

