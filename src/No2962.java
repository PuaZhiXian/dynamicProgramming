import java.util.Arrays;

public class No2962 {
    public static void main(String[] args) {
        No2962 obj = new No2962();
        System.out.println(obj.countSubarrays(new int[]{1, 3, 2, 3, 3}, 2)); //6
    }

    public long countSubarrays(int[] nums, int k) {
        int cnt = 0;
        long ans = 0;

        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] == max) {
                cnt++;
            }

            while (cnt >= k) {
                ans += nums.length - right;
                if (nums[left] == max) {
                    cnt--;
                }
                left++;
            }
            right++;
        }

        return ans;
    }
}
