public class No3392 {
    public static void main(String[] args) {
        No3392 obj = new No3392();
    }

    public int countSubarrays(int[] nums) {
        int ans = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] % 2 == 0 && nums[i] / 2 == (nums[i - 1] + nums[i + 1])) {
                ans++;
            }
        }

        return ans;
    }
}
