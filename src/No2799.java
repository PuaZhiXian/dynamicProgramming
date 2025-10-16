import java.util.HashSet;
import java.util.Set;

public class No2799 {
    public static void main(String[] args) {
        No2799 obj = new No2799();
        System.out.println(obj.countCompleteSubarrays(new int[]{1, 3, 1, 2, 2}));

    }

    public int countCompleteSubarrays(int[] nums) {
        int left = 0;
        int right = 0;
        int ans = 0;
        int[] cnt = new int[2001];

        boolean[] set = new boolean[2001];
        int size = 0;
        for (int num : nums) {
            if (!set[num]) {
                size++;
                set[num]= true;
            }
        }
        int cur = 0;

        while (right < nums.length) {
            cnt[nums[right]]++;
            if (cnt[nums[right]] == 1) {
                cur++;
            }

            while (cur == size) {
                ans += (nums.length - right);
                cnt[nums[left]]--;
                if (cnt[nums[left]] == 0) {
                    cur--;
                }
                left++;
            }

            right++;
        }
        return ans;
    }
}
