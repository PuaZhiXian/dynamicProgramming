public class No2302 {
    public static void main(String[] args) {
        No2302 obj = new No2302();
        System.out.println(obj.countSubarrays(new int[]{2, 1, 4, 3, 5}, 10));//6
    }

    public long countSubarrays(int[] nums, long k) {
        long ans = 0;
        int left = 0, right = 0;
        long sum = 0L;

        while (left < nums.length) {
            if (right == nums.length) {
                ans += (right - left );
                left++;
                continue;
            }
            sum += nums[right];
            right++;
            if (sum * (right - left) >= k) {
                while (sum * (right - left) >= k) {
                    ans += (right - left - 1);
                    sum -= nums[left];
                    left++;
                }
            }
        }

        return ans;
    }
}
