public class No2419 {
    public static void main(String[] args) {
        No2419 o = new No2419();
        System.out.println(o.longestSubarray(new int[]{1, 2, 3, 3, 2, 2}));
    }

    public int longestSubarray(int[] nums) {
        int longest = 0;
        int maxAnd = 0;
        for (int n : nums) {
            maxAnd = Math.max(maxAnd, n);
        }

        int l = 0;
        int r = 0;
        while (l < nums.length) {
            if (nums[l] != maxAnd) {
                l++;
                r = l;
                continue;
            }

            while (r < nums.length && nums[r] == maxAnd) {
                r++;
            }

            longest = Math.max(longest, r - l);
            l = r;
        }


        return longest;
    }
}
