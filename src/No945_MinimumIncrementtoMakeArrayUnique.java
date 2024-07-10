import java.util.Arrays;

public class No945_MinimumIncrementtoMakeArrayUnique {
    public static void main(String[] args) {
        System.out.println(minIncrementForUnique(new int[]{3, 2, 1, 2, 1, 7}));
    }

    public static int minIncrementForUnique(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            int init = nums[i];
            nums[i] = Math.max(nums[i], nums[i - 1] + 1);
            sum += Math.abs(init - nums[i]);
        }
        return sum;
    }


}
