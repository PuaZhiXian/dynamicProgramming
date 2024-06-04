import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/sum-of-all-subset-xor-totals
 */
public class No1863_SumofAllSubsetXORTotals {
    public static void main(String[] args) {
        System.out.println(subsetXORSum(new int[]{1, 3}));//6
        System.out.println(subsetXORSum(new int[]{5, 1, 6}));//28
        System.out.println(subsetXORSum(new int[]{3, 4, 5, 6, 7, 8}));//480
    }

    public static int subsetXORSum(int[] nums) {
        return recurv3(nums, 0, 0);
    }

    public static List<Integer> recurv2(int[] nums, int start) {
        if (start == nums.length - 1) {
            List<Integer> result = new ArrayList<>();
            result.add(nums[start]);
            result.add(0);
            return result;
        }
        List<Integer> includeList = recurv2(nums, start + 1);
        List<Integer> excludeList = recurv2(nums, start + 1);

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < includeList.size(); i++) {
            int temp = includeList.get(i);
            result.add(temp ^ nums[start]);
        }
        result.addAll(excludeList);
        return result;
    }

    public static int recurv3(int[] nums, int start, int curValue) {
        if (start == nums.length) {
            return curValue;
        }
        int includePoint = recurv3(nums, start + 1, curValue ^ nums[start]);
        int excludePoint = recurv3(nums, start + 1, curValue);

        return includePoint + excludePoint;
    }
}
