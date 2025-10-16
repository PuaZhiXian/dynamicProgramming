public class No2176 {
    public static void main(String[] args) {
        No2176 obj = new No2176();
    }

    public int countPairs(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j ++) {
                if (nums[i] == nums[j] && (i * j) % k == 0) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
