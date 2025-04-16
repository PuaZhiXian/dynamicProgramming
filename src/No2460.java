import java.util.ArrayList;
import java.util.List;

public class No2460 {
    public static void main(String[] args) {
        No2460 obj = new No2460();
    }

    public int[] applyOperations(int[] nums) {
        List<Integer> temp = new ArrayList<>();

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] = nums[i] * 2;
                nums[i + 1] = 0;
                if (nums[i] != 0) {
                    temp.add(nums[i]);
                }
            } else if (nums[i] != 0) {
                temp.add(nums[i]);
            }
        }
        if (nums[nums.length - 1] != 0) {
            temp.add(nums[nums.length - 1]);
        }
        int[] ans = new int[nums.length];
        for (int i = 0; i < temp.size(); i++) {
            ans[i] = temp.get(i);
        }

        return ans;
    }
}
