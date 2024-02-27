import java.util.ArrayList;

public class LongestSubarrayof1AfterDeletingOneElement_1493 {
    public static void main(String[] args) {

        LongestSubarrayof1AfterDeletingOneElement_1493 obj = new LongestSubarrayof1AfterDeletingOneElement_1493();
        int[] arr1 = {1, 1, 0, 1};
        int[] arr2 = {0, 1, 1, 1, 0, 1, 1, 0, 1};
        int[] arr3 = {1, 1, 1};
        int[] arr4 = {1, 1, 0, 0, 1, 1, 1, 0, 1};
        System.out.println(obj.longestSubarray(arr1));
        System.out.println(obj.longestSubarray(arr2));
        System.out.println(obj.longestSubarray(arr3));
        System.out.println(obj.longestSubarray(arr4));

    }

    public int longestSubarray(int[] nums) {
        int cnt = 0;
        ArrayList<Integer> sum = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                sum.add(cnt);
                cnt = 0;
            } else {
                cnt++;
            }
        }
        if (cnt != 0) {
            sum.add(cnt);
        }

        int max = 0;
        for (int i = 0; i < sum.size() - 1; i++) {
            max = Math.max(max, sum.get(i) + sum.get(i + 1));
        }
        return sum.size() == 1 ? nums.length - 1 : max;
    }
}
