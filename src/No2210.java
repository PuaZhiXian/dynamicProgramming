public class No2210 {
    public static void main(String[] args) {
        No2210 o = new No2210();
        System.out.println(o.countHillValley(new int[]{2, 4, 1, 1, 6, 5}));
    }

    public int countHillValley(int[] nums) {

        int ans = 0;
        int prev = -1;
        for (int i = 1; i < nums.length - 1; i++) {
            if (prev == nums[i]) {
                continue;
            }
            int index = i - 1;
            while (index > 0 && nums[index] == nums[i]) {
                index--;
            }

            int l = nums[index];
            index = i + 1;

            while (index < nums.length - 1 && nums[index] == nums[i]) {
                index++;
            }
            int r = nums[index];

            if (nums[i] > l && nums[i] > r) {
                ans++;
                prev = nums[i];
            }
            if (nums[i] < l && nums[i] < r) {
                ans++;
                prev = nums[i];
            }
        }
        return ans;
    }
}
