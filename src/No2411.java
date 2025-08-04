import java.util.Arrays;

public class No2411 {
    public static void main(String[] args) {
        No2411 o = new No2411();
        System.out.println(Math.pow(2, 29));
//        1000_000_0000;
        System.out.println(Arrays.toString(o.smallestSubarrays(new int[]{1, 0, 2, 1, 3})));
    }

    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        long[] maxOR = new long[n];
        long cur = 0;

        for (int i = n - 1; i >= 0; i--) {
            cur |= nums[i];
            maxOR[i] = cur;
        }
//        System.out.println(Arrays.toString(maxOR)); [3, 3, 3, 3, 3]

        int left = 0;
        int right = 0;

        int[] bits = new int[30];

        cur = 0;
        for (int i = 0; i < n; i++) {
            while (right > left && cur < maxOR[i]) {
                int[] temp = toBinaryArray(nums[right]);
                for (int j = 0; j < 30; j++) {
                    bits[j] += temp[j];
                }
                cur |= nums[right];
                right++;
            }

            ans[i] = right <= left ? 1 : right - left;
            //remove prev
            cur = 0;
            int[] temp = toBinaryArray(nums[left]);
            for (int j = 0; j < 30; j++) {
                bits[j] -= temp[j];
                if (bits[j] > 0) {
//                    cur += (long) Math.pow(2, 30 - j - 1);
                    cur |= (1 << 30 - j - 1);
                }
            }

            left++;
        }


        return ans;
    }

    public static int[] toBinaryArray(int number) {
        int[] bits = new int[30];
        for (int i = 0; i < 30; i++) {
            bits[i] = (number >>> (30 - 1 - i)) & 1;
        }
        return bits;
    }
}
