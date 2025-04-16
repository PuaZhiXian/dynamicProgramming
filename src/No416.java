import java.util.*;

public class No416 {
    public static void main(String[] args) {
        No416 obj = new No416();

    }

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        Set<Integer> set = new HashSet<>();
        set.add(0);
        set.add(nums[0]);

        if (nums[0] == target || 0 == target) {
            return true;
        }
        for (int i = 1; i < nums.length; i++) {
            Set<Integer> temp = new HashSet<>();
            for (Integer num : set) {
                if (num + nums[i] == target) {
                    return true;
                }
                if (num + nums[i] < target) {
                    temp.add(num + nums[i]);
                }
            }

            set.addAll(temp);
        }

        return false;
    }
}
