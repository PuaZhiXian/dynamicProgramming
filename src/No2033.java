import java.util.Arrays;
import java.util.Map;

public class No2033 {
    public static void main(String[] args) {

    }

    public int minOperations(int[][] grid, int x) {
        int cnt = 0;
        int[] nums = new int[grid.length * grid[0].length];
        int index = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                nums[index] = grid[i][j];
                index++;
            }
        }

        Arrays.sort(nums);
        int mid = nums[nums.length / 2];

        for (int i = 0; i < nums.length; i++) {
            int abs = Math.abs(mid - nums[i]);
            if (abs % x != 0) {
                return -1;
            }

            cnt += (abs / x);
        }

        return cnt;
    }
}
