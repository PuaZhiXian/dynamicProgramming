public class No2874 {
    public static void main(String[] args) {
        No2874 obj = new No2874();
    }

    public long maximumTripletValue(int[] nums) {
        long ans = 0;
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];

        int[] smax = new int[nums.length];
        int[] smin = new int[nums.length];

        smax[0] = nums[0];
        smin[0] = nums[0];
        max[nums.length - 1] = nums[nums.length - 1];
        min[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            max[i] = Math.max(nums[i], max[i + 1]);
            min[i] = Math.min(nums[i], min[i + 1]);
        }

        for (int i = 1; i < nums.length; i++) {
            smax[i] = Math.max(smax[i - 1], nums[i]);
            smin[i] = Math.min(smin[i - 1], nums[i]);
        }

        for (int j = 1; j < nums.length - 1; j++) {
            long tempMax = smax[j - 1] - nums[j];
            long tempMin = smin[j - 1] - nums[j];

            if (tempMax > 0) {
                tempMax = tempMax * max[j + 1];
            } else if (tempMax < 0) {
                tempMax = tempMax * min[j + 1];
            }

            if (tempMin > 0) {
                tempMin = tempMin * max[j + 1];
            } else if (tempMin < 0) {
                tempMin = tempMin * min[j + 1];
            }
            ans = Math.max(ans, Math.max(tempMax, tempMin));
        }

        return ans;
    }
}
