public class No2044 {
    public static void main(String[] args) {
        No2044 o = new No2044();
        System.out.println(o.countMaxOrSubsets(new int[]{3, 1}));
    }

    long max = 0;

    public int countMaxOrSubsets(int[] nums) {
        for (int n : nums) {
            max = max | n;
        }

        return rec(nums, 0, 0);
    }

    public int rec(int[] nums, int index, int prev) {
        int cnt = 0;
        if (prev > max) {
            return cnt;
        }
        if (prev == max && index == nums.length) {
            return 1;
        }
        if (index == nums.length) {
            return cnt;
        }

        cnt += rec(nums, index + 1, prev | nums[index]);
        cnt += rec(nums, index + 1, prev);
        return cnt;
    }
}
