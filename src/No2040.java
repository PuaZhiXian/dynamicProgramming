import java.util.Arrays;

public class No2040 {
    public static void main(String[] args) {
        No2040 o = new No2040();
        System.out.println(o.kthSmallestProduct(new int[]{2, 5}, new int[]{3, 4}, 2));
    }

    private void temp(int[] n1, int[] n2) {
        int index = 0;
        int[] temp = new int[n1.length * n2.length];
        for (int n : n1) {
            for (int nn : n2) {
                temp[index] = n * nn;
                index++;
            }
        }

        Arrays.sort(temp);
        System.out.println(Arrays.toString(temp));
    }

    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long left = -10000000000L; //-10000000000
        long right = 10000000000L; //10000000000

        while (left <= right) {
            long mid = (left + right) / 2;
            if (getCntSmallerNEqualTarget(mid, nums1, nums2) >= k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public long getCntSmallerNEqualTarget(long target, int[] nums1, int[] nums2) {
        long cnt = 0;
        int num2Len = nums2.length;
        for (int num : nums1) {
            int left = 0;
            int right = num2Len - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                long cur = (long) nums2[mid] * num;
                if ((num >= 0 && cur <= target) || (num < 0 && cur > target)) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            if (num >= 0) {
                cnt += left;
            } else {
                cnt += (num2Len - left);
            }
        }
        return cnt;
    }

}
