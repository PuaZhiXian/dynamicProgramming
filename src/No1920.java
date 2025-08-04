public class No1920 {
    public static void main(String[] args) {
        No1920 obj = new No1920();
    }

    public int[] buildArray(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[nums[i]];
        }
        return ans;
    }
}
