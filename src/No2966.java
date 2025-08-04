import java.util.Arrays;

public class No2966 {
    public static void main(String[] args) {
        No2966 o = new No2966();
        System.out.println(Arrays.deepToString(o.divideArray(new int[]{4, 2, 9, 8, 2, 12, 7, 12, 10, 5, 8, 5, 5, 7, 9, 2, 5, 11}, 14)));
    }

    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int l = nums.length;
        int[][] ans = new int[l / 3][];
        int index = 0;
        for (int i = 0; i < l; i = i + 3) {
            int diff1 = nums[i + 1] - nums[i];
            int diff2 = nums[i + 2] - nums[i];
            int diff3 = nums[i + 2] - nums[i + 1];

            if (diff1 <= k && diff2 <= k && diff3 <= k) {
                ans[index] = new int[]{nums[i], nums[i + 1], nums[i + 2]};
                index++;
            } else {
                return new int[0][];
            }
        }

        return ans;
    }
}
