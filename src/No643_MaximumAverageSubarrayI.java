/**
 * https://leetcode.com/problemset/?search=643&page=1&status=AC
 */
public class No643_MaximumAverageSubarrayI {
    public static void main(String[] args) {
        No643_MaximumAverageSubarrayI obj = new No643_MaximumAverageSubarrayI();
        int[] arr1 = {1, 12, -5, -6, 50, 3};
        int[] arr2 = {5};

        System.out.println(obj.findMaxAverage(arr1, 4));
        System.out.println(obj.findMaxAverage(arr2, 1));
    }

    public double findMaxAverage(int[] nums, int k) {

        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            result[0] += nums[i];
        }
        int max = result[0];
        for (int i = 1; i < result.length; i++) {
            result[i] = result[i - 1] - nums[i - 1] + nums[i + k - 1];
            max = Math.max(max, result[i]);
        }
        return (double) max / k;
    }
}
