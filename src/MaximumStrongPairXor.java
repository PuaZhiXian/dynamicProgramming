import java.util.Arrays;

public class MaximumStrongPairXor {
    public static void main(String[] args) {
        MaximumStrongPairXor obj = new MaximumStrongPairXor();
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {1, 1, 10, 3, 9};
        System.out.println(obj.maximumStrongPairXor(nums1));
        System.out.println(obj.maximumStrongPairXor(nums2));
    }

    public int maximumStrongPairXor(int[] arr) {
        Arrays.sort(arr);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j >= i; j--) {
                if (arr[j] - arr[i] <= Math.min(arr[j], arr[i])) {
                    max = Math.max(max, arr[j] ^ arr[i]);
                }
            }
        }
        return max;
    }
}
