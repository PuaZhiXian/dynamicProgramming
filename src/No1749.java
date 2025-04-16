import java.security.SecureRandom;

public class No1749 {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public static void main(String[] args) {
        No1749 obj = new No1749();

    }

    public int maxAbsoluteSum(int[] nums) {
        int max = 0;
        int prev = 0;

        int min = 0;
        int minPrev = 0;

        for (int i = 0; i < nums.length; i++) {
            if (prev + nums[i] > nums[i]) {
                prev += nums[i];
            } else {
                prev = nums[i];
            }
            max = Math.max(prev, max);

            if (minPrev + nums[i] < nums[i]) {
                minPrev += nums[i];
            } else {
                minPrev = nums[i];
            }
            min = Math.min(minPrev, min);
        }

        return (int) Math.max(Math.abs(max), Math.abs(min));
    }
}
