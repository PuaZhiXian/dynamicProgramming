import java.util.HashSet;

/**
 * https://leetcode.com/problems/contains-duplicate-ii/description/
 */
public class No219_ContainsNearbyDuplicate {
    public static void main(String[] args) {
        No219_ContainsNearbyDuplicate obj = new No219_ContainsNearbyDuplicate();
        int[] nums1 = {1, 2, 3, 1};
        int k1 = 3;
        int[] nums2 = {1, 0, 1, 1};
        int k2 = 1;
        int[] nums3 = {1, 2, 3, 1, 2, 3};
        int k3 = 2;
        int[] nums4 = {99, 99};
        int k4 = 2;
//
        System.out.println(obj.containsNearbyDuplicate(nums1, k1));
        System.out.println(obj.containsNearbyDuplicate(nums2, k2));
        System.out.println(obj.containsNearbyDuplicate(nums3, k3));
        System.out.println(obj.containsNearbyDuplicate(nums4, k4));


    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        int first = 0;
        if (nums.length == 1) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return true;
            }
            if (set.size() >= k + 1) {
                set.remove(nums[first]);
                first++;
            }
        }
        return false;
    }
}
