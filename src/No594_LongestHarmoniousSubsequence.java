import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-harmonious-subsequence/description/
 */
public class No594_LongestHarmoniousSubsequence {

    public static void main(String[] args) {
        No594_LongestHarmoniousSubsequence obj = new No594_LongestHarmoniousSubsequence();
        int[] nums1 = {1, 3, 2, 2, 5, 2, 3, 7}; //5
        int[] nums2 = {1, 2, 2, 1}; //4
        int[] nums3 = {1, 1, 1, 1};//0
        int[] nums4 = {-1, 0, -1, 0, -1, 0, -1};//7
        System.out.println(obj.findLHSV2(nums1));
        System.out.println(obj.findLHS(nums2));
        System.out.println(obj.findLHS(nums3));
        System.out.println(obj.findLHS(nums4));
    }

    public int findLHS(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        int[][] ht = new int[Math.max(max + 1, Math.abs(min) + 1)][2];

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                ht[nums[i]][1]++;
            }
            if (nums[i] < 0) {
                ht[Math.abs(nums[i])][0]++;
            }
            if (nums[i] == 0) {
                ht[nums[i]][1]++;
                ht[nums[i]][0]++;
            }
        }

        max = 0;
        for (int i = 1; i < ht.length; i++) {
            if (ht[i - 1][0] == 0 || ht[i][0] == 0) {
                max = Math.max(max, 0);
            } else {
                max = Math.max(max, ht[i][0] + ht[i - 1][0]);
            }

            if (ht[i - 1][1] == 0 || ht[i][1] == 0) {
                max = Math.max(max, 0);
            } else {
                max = Math.max(max, ht[i][1] + ht[i - 1][1]);
            }
        }

        return max;
    }

    public int findLHSV2(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            boolean has = hm.containsKey(nums[i]);
            if (has) {
                int temp = hm.get(nums[i]);
                hm.put(nums[i], temp + 1);
            } else {
                hm.put(nums[i], 1);
            }
        }

        int max = 0;
        for (Map.Entry<Integer, Integer> set : hm.entrySet()) {
            if (hm.containsKey(set.getKey() + 1)) {
                max = Math.max(max, hm.get(set.getKey() + 1) + set.getValue());
            }
//            System.out.println(set.getKey() + " = " + set.getValue());
        }

        return max;
    }
}
