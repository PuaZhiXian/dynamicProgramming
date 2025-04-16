import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class No128 {
    public static void main(String[] args) {
        No128 obj = new No128();
//        System.out.println(obj.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
//        System.out.println(obj.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
        System.out.println(obj.longestConsecutive(new int[]{0, 1, 1, 2}));

    }

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int max = 1;
//        System.out.println(Arrays.toString(nums));
        int cnt = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                continue;
            }
            if (nums[i] - nums[i + 1] == -1) {
                cnt++;
                max = Math.max(max, cnt);
            } else {
                cnt = 1;
            }
        }
        return max;
    }
}
