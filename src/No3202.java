import java.util.*;

public class No3202 {
    public static void main(String[] args) {
        No3202 o = new No3202();
//        o.maximumLength(new int[]{1, 4, 2, 3, 1, 4}, 3);
//        o.maximumLength(new int[]{7, 9}, 8);
        System.out.println(o.maximumLength(new int[]{10, 5}, 6));
    }

    public int maximumLength(int[] nums, int k) {
        int max = 0;
        int[][] dp = new int[k][k];

        for (int n : nums) {
            int temp = n % k;
            for (int i = 0; i < k; i++) {
                int re = (i - temp + k) % k;
                dp[temp][re] = dp[re][temp] + 1;
                max = Math.max(dp[temp][re], max);
            }
        }


        return max;
    }

}
