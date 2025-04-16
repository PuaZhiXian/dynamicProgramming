import java.util.Arrays;

public class No719 {
    public static void main(String[] args) {
        No719 obj = new No719();
        System.out.println(obj.smallestDistancePair(new int[]{1, 2, 2, 4, 5, 6, 7}, 7)); //2
        System.out.println(obj.smallestDistancePair(new int[]{1, 3, 1}, 1)); //0
        System.out.println(obj.smallestDistancePair(new int[]{1, 1, 1}, 3));//0
        System.out.println(obj.smallestDistancePair(new int[]{1, 6, 1}, 2));//5
        System.out.println(obj.smallestDistancePair(new int[]{1, 4, 5, 6, 7, 8, 9, 9, 10, 10}, 18)); //2
//        System.out.println(obj.helper(new int[]{1, 4, 5, 6, 7, 8, 9, 9, 10, 10}, 2, 18));
    }

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums[nums.length - 1];

        while (left != right) {
            int middle = (right + left) / 2;
//            System.out.println(middle);
            int cnt = helper(nums, middle, k);
            if (cnt >= k) {
                right = middle;
//                System.out.println("move middle to right");
            } else {
                left = middle + 1;
//                System.out.println("move middle to left");
            }
//            System.out.println("left : " + left + " right : " + right);
        }

        return left;
    }

    public int helper(int[] nums, int target, int limit) {
        int cnt = 0;

        int left = 0;
        int right = 1;

        while (right < nums.length) {
//            System.out.println("right " + right + " left " + left);
            if (Math.abs(nums[left] - nums[right]) <= target) {
                cnt += (right - left);
                right++;
                if (cnt > limit) {
                    return cnt;
                }
            } else {
                left++;
            }
        }

        return cnt;
    }
}
