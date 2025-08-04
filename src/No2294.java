import java.util.Arrays;

public class No2294 {
    public static void main(String[] args) {
        No2294 o = new No2294();
    }

    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int cnt = 0;
        int min = nums[0];
        for (int num : nums) {
            if (num - min > k) {
                cnt++;
                min = num;
            }
        }
        cnt++;

        return cnt;
    }
}
