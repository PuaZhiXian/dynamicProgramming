public class No2873 {
    public static void main(String[] args) {
        No2873 obj = new No2873();

    }

    public long maximumTripletValue(int[] nums) {
        long ans = 0;
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];


        max[nums.length - 1] = nums[nums.length - 1];
        min[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            max[i] = Math.max(nums[i], max[i + 1]);
            min[i] = Math.min(nums[i], min[i + 1]);
        }


        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                long temp = nums[i] - nums[j];
                if (temp > 0) {
                    temp = temp * max[j + 1];
                } else if (temp < 0) {
                    temp = temp * min[j + 1];
                }
                ans = Math.max(ans, temp);
            }
        }


        return Math.max(0, ans);
    }
}
