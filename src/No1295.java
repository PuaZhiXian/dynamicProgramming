public class No1295 {
    public static void main(String[] args) {

    }

    public int findNumbers(int[] nums) {

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (valid(nums[i])) {
                ans++;
            }

        }
        return ans;
    }

    private boolean valid(int num) {
        int cnt = 0;
        while (num > 0) {
            num = num / 10;
            cnt++;
        }
        return cnt % 2 == 0;
    }
}
