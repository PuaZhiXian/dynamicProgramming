import java.util.HashMap;
import java.util.Map;

public class No2348 {
    public static void main(String[] args) {
        No2348 o = new No2348();
        System.out.println(o.zeroFilledSubarray(new int[]{1, 3, 0, 0, 2, 0, 0, 4}));
    }

    public long zeroFilledSubarray(int[] nums) {
        int cnt = 0;
        long ans = 0;

        for (int num : nums) {
            if (num == 0) {
                cnt++;
            } else {
                if (cnt > 0) {
                    ans += getSum(cnt);
                    cnt = 0;
                }
            }
        }
        if (cnt > 0)
            ans += getSum(cnt);
        return ans;
    }

    private long getSum(int num) {
        return (long) num * (num + 1) / 2;
    }
} 
