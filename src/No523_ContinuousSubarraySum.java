import java.util.HashMap;
import java.util.Map;

public class No523_ContinuousSubarraySum {
    public static void main(String[] args) {
/*        System.out.println(checkSubarraySum(new int[]{4, 1, 2, 3}, 6));//true
        System.out.println(checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6));//true
        System.out.println(checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 6));//true
        System.out.println(checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 13));//false
        System.out.println(checkSubarraySum(new int[]{5, 0, 0, 0}, 3));//true
        System.out.println(checkSubarraySum(new int[]{0}, 3));//true*/
        System.out.println(checkSubarraySum(new int[]{23, 2, 4, 6, 6}, 7));//true
    }

    public static boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length == 1) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int[] cum = new int[nums.length];
        cum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            cum[i] = nums[i] + cum[i - 1];
        }
        for (int i = 0; i < cum.length; i++) {
            cum[i] = cum[i] % k;
            if (map.get(cum[i]) == null) {
                map.put(cum[i], i);
            } else {
                int index = map.get(cum[i]);
                if (index != i - 1) {
                    return true;
                }
            }
            if (cum[i] == 0 && i != 0) {
                return true;
            }
        }
        return false;
    }
}
