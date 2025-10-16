import java.util.Arrays;

public class No1498 {
    public static void main(String[] args) {
        No1498 o = new No1498();
//        System.out.println(o.numSubseq(new int[]{2, 3, 3, 4, 6, 7}, 12));
//        System.out.println(o.numSubseq(new int[]{3,5,6,7}, 9));
//        System.out.println(o.numSubseq(new int[]{3,3,6,8}, 10));
        System.out.println(o.numSubseq(new int[]{14, 4, 6, 6, 20, 8, 5, 6, 8, 12, 6, 10, 14, 9, 17, 16, 9, 7, 14, 11, 14, 15, 13, 11, 10, 18, 13, 17, 17, 14, 17, 7, 9, 5, 10, 13, 8, 5, 18, 20, 7, 5, 5, 15, 19, 14}, 22));
    }

    private static final int MOD = (int) 1e9 + 7;

    public int numSubseq(int[] nums, int target) {
        long ans = 0;
        Arrays.sort(nums);
        int small = 0;
        int large = nums.length - 1;

        int[] prePow = new int[nums.length];
        prePow[0] = 1;
        for (int i = 1; i < prePow.length; i++) {
            prePow[i] = (prePow[i - 1] * 2) % MOD;
        }


        while (small <= large) {
            while (large >= small && nums[large] + nums[small] > target) {
                large--;
            }

            if (small <= large) {
                ans = (ans + (prePow[large - small])) % MOD;
            }
            small++;
        }
        return (int) (ans % MOD);
    }
}
