import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No2845 {

    public static void main(String[] args) {
        No2845 obj = new No2845();
        System.out.println(obj.countInterestingSubarrays(Arrays.asList(3,2,4), 2, 1));
    }

    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        long ans = 0;
        int[] count = new int[nums.size() + 1];
        int i = 1;
        for (int num : nums) {
            count[i] = count[i - 1] + (num % modulo == k ? 1 : 0);
            i++;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (i = 0; i < count.length; i++) {
            ans += map.getOrDefault((count[i] + modulo - k) % modulo, 0);
            map.put(count[i] % modulo, map.getOrDefault(count[i] % modulo, 0) + 1);
        }
        return ans;
    }
}
