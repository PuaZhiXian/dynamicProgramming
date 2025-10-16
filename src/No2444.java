import java.util.Map;

public class No2444 {
    public static void main(String[] args) {
        No2444 obj = new No2444();
        System.out.println(obj.countSubarrays(new int[]{1, 3, 5, 2, 7, 5}, 1, 5));//2
        System.out.println(obj.countSubarrays(new int[]{1, 1, 1, 1}, 1, 1));//10
    }

    public long countSubarrays(int[] nums, int minK, int maxK) {
        long ans = 0;
        int minIndex = -1, maxIndex = -1;
        int invalid = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxK || nums[i] < minK) {
                invalid = i;
            }
            if (nums[i] == minK) {
                minIndex = i;
            }

            if (nums[i] == maxK) {
                maxIndex = i;
            }
            ans = ans + Math.max(0, Math.min(minIndex, maxIndex) - invalid);
        }
        return ans;
    }

}
