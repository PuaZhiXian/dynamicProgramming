import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class No3375 {
    public static void main(String[] args) {
        No3375 obj = new No3375();

    }

    public int minOperations(int[] nums, int k) {
        int cnt = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        for (int num : set) {
            if (num < k) {
                return -1;
            }
            if (num > k) {
                cnt++;
            }
        }

        return cnt;


    }
}
