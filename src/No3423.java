public class No3423 {
    public static void main(String[] args) {
        No3423 o = new No3423();
    }

    public int maxAdjacentDistance(int[] nums) {
        int ans = Math.abs(nums[nums.length - 1] - nums[0]);

        for (int i = 1; i < nums.length; i++) {
            ans = Math.max(ans, Math.abs(nums[i] - nums[i - 1]));
        }

        return ans;
    }
}
