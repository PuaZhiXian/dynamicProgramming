import java.util.Arrays;

public class No1509 {
    public static void main(String[] args) {
//        System.out.println(minDifference(new int[]{5, 3, 2, 4, 10}));
//        System.out.println(minDifference(new int[]{1, 5, 0, 10, 14}));
//        System.out.println(minDifference(new int[]{9, 48, 92, 48, 81, 31}));//17
        System.out.println(minDifference(new int[]{9, 31, 48, 48, 81, 92}));//17
    }

    public static int minDifference(int[] nums) {
        if (nums.length <= 4) {
            return 0;
        }
        Arrays.sort(nums);
        int[] temp = new int[8];
        int start = 0;
        int end = nums.length - 1;
        for (int i = 0; i < 4; i++) {
            temp[i] = nums[start];
            start++;
        }
        for (int i = 7; i >= 4; i--) {
            temp[i] = nums[end];
            end--;
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            result = Math.min(result, Math.abs(temp[i] - temp[i + 4]));
        }
        return result;
    }
}
