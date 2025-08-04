import java.util.Arrays;

public class No2016 {
    public static void main(String[] args) {
        No2016 o = new No2016();
        System.out.println(o.maximumDifference(new int[]{7, 1, 5, 4}));
    }

    public int maximumDifference(int[] nums) {
        int ans = -1;
        int n = nums.length;
        int[] temp = new int[n];
        temp[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            temp[i] = Math.max(nums[i], temp[i + 1]);
        }
        for (int i = 0; i < n - 1; i++) {
            if (temp[i + 1] > nums[i]) {
                ans = Math.max(ans, temp[i + 1] - nums[i]);
            }
        }
        return ans;
    }
}
