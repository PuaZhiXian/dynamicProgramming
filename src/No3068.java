import java.util.Arrays;
import java.util.Collections;

public class No3068 {

    public static void main(String[] args) {
        No3068 obj = new No3068();
    }

    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long sum = 0;
        long[] diff = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            diff[i] = (nums[i] ^ k) - nums[i];
            sum += nums[i];
        }

        Long[] diffBoxed = Arrays.stream(diff).boxed().toArray(Long[]::new);
        Arrays.sort(diffBoxed, Collections.reverseOrder());
        diff = Arrays.stream(diffBoxed).mapToLong(Long::longValue).toArray();

        for (int i = 0; i < nums.length - 1; i += 2) {
            long temp = diff[i] + diff[i + 1];
            if (temp <= 0) {
                break;
            }
            sum += temp;
        }

        return sum;
    }
}
