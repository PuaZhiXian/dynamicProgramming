import java.util.Arrays;

public class No3191 {
    public static void main(String[] args) {
//        System.out.println(minOperations(new int[]{0, 1, 1, 1, 0, 0}));
//        System.out.println(minOperations(new int[]{0, 1, 1, 1}));
//        System.out.println(minOperations(new int[]{0, 1, 1, 0, 1, 0, 0}));
        System.out.println(minOperations(new int[]{1, 0, 0, 1, 1, 0, 1, 1, 1}));
    }

    public static int minOperations(int[] nums) {
        int result = 0;
        int start = 0;
        while (start + 2 < nums.length) {
//            System.out.println(Arrays.toString(nums));
            if (nums[start] == 1) {
                start++;
            } else {
                result++;
                nums[start] = 1;
                int small = start;
                for (int i = 1; i < 3; i++) {
                    if (nums[start + i] == 1 && small == start) {
                        small = start + i;
                    }
                    nums[start + i] = Math.abs(nums[start + i] - 1);
                }
                if (start + 2 == nums.length - 1 && small != start) {
                    return -1;
                }
                start = small;
            }
        }
        if (nums[nums.length - 1] == 0 || nums[nums.length - 2] == 0) {
            return -1;
        }
        return result;
    }
}
