import java.util.HashSet;
import java.util.Set;

public class No349 {
    public static void main(String[] args) {
        No349 obj = new No349();

    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> a = new HashSet<>();

        for (int num : nums1) {
            set.add(num);
        }

        for (int num : nums2) {
            if (set.contains(num)) {
                a.add(num);
            }
        }

        int[] ans = new int[a.size()];
        int index = 0;
        for (int n : a) {
            ans[index] = n;
            index++;
        }

        return ans;
    }
}
