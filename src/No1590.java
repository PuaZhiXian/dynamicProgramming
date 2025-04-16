import java.util.Arrays;

public class No1590 {
    public static void main(String[] args) {
        No1590 obj = new No1590();
//        System.out.println(obj.minSubarray(new int[]{6, 3, 5, 2}, 9));
//        System.out.println(obj.minSubarray(new int[]{1000000000, 1000000000, 1000000000}, 3));
//        System.out.println(obj.minSubarray(new int[]{4, 4, 2}, 7));
        System.out.println(obj.minSubarray(new int[]{8, 32, 31, 18, 34, 20, 21, 13, 1, 27, 23, 22, 11, 15, 30, 4, 2}, 148));

    }

    public int minSubarray(int[] nums, int p) {
        long sum = Arrays.stream(nums).asLongStream().sum();
        if (sum % p == 0) {
            return 0;
        }

        long[] prefixSum = generatePrefixSum(nums);

        int minLen = nums.length;
        for (int i = 0; i < prefixSum.length; i++) {
            if ((sum - prefixSum[i]) % p == 0) {
                minLen = Math.min(i + 1, minLen);
            }
        }

        for (int i = 1; i < prefixSum.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int curLen = i - j;
                if (curLen > minLen) {
                    break;
                }
                if ((sum - (prefixSum[i] - prefixSum[j])) % p == 0) {
                    minLen = Math.min(minLen, curLen);
//                    System.out.println(minLen);
//                    System.out.printf("%s - %s (%s len)\n", i, j, curLen);
                    break;
                }
//                System.out.printf("%s - %s (%s len)\n", i, j, curLen);
            }
        }
//        System.out.println(Arrays.toString(prefixSum));
        return minLen == nums.length ? -1 : minLen;
    }

    private long[] generatePrefixSum(int[] nums) {
        long[] prefixSum = new long[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        return prefixSum;
    }
}
