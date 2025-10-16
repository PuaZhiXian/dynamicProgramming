import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class No1695 {
    public static void main(String[] args) {
        No1695 o = new No1695();
        System.out.println(o.maximumUniqueSubarray(new int[]{10000, 1, 10000, 1, 1, 1, 1, 1, 1}));

    }

    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> contain = new HashSet<>();
        int finalMax = 0;
        int max = 0;

        int l = 0;
        int r = 0;
        while (r < nums.length) {
            while (contain.contains(nums[r])) {
                max -= nums[l];
                contain.remove(nums[l]);
                l++;
            }
            max += nums[r];
            finalMax = Math.max(finalMax, max);
            contain.add(nums[r]);
            r++;
        }


        return finalMax;
    }
}
