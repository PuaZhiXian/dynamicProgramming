public class No2226 {
    public static void main(String[] args) {
        No2226 obj = new No2226();
//        System.out.println(obj.maximumCandies(new int[]{5, 8, 6}, 3));
        System.out.println(obj.maximumCandies(new int[]{1}, 1));
    }

    public int maximumCandies(int[] candies, long k) {
        int max = 0;
        int low = 1;
        int high = 0;

        for (int n : candies) {
            high = Math.max(high, n);
        }
        int mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (helper(candies, mid, k)) {
                low = mid + 1;
                max = mid;
            } else {
                high = mid - 1;
            }
        }

        return max;
    }

    private boolean helper(int[] nums, int mid, long tar) {
        if (mid == 0) {
            return false;
        }
        for (int num : nums) {
            int c = num / mid;
            tar -= c;
            if (tar <= 0) {
                return true;
            }
        }
        return false;
    }
}
