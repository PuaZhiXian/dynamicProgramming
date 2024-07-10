import java.util.HashMap;
import java.util.Map;

public class No1248_CountNumberofNiceSubarrays {
    public static void main(String[] args) {

//        System.out.println(numberOfSubarrays(new int[]{1, 1, 2, 1, 1}, 3));//2
//        System.out.println(numberOfSubarrays(new int[]{2, 4, 6}, 1));//0
//        System.out.println(numberOfSubarrays(new int[]{2, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 1}, 2));//23
//        System.out.println(numberOfSubarrays(new int[]{2, 2, 2, 1, 2, 2, 1, 2, 2, 2}, 2));//16
        System.out.println(numberOfSubarrays(new int[]{45627, 50891, 94884, 11286, 35337, 46414, 62029, 20247, 72789, 89158, 54203, 79628, 25920, 16832, 47469, 80909}, 1));//16
    }



    public static int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;

        int cnt = 0;
        int sum = 0;

        while (end < nums.length) {
            nums[end] = nums[end] % 2 == 0 ? 0 : 1;
            sum += nums[end];
            if (sum >= k) {
                if (sum > k) {
                    if (nums[start] == 1) {
                        sum -= nums[start];
                        start++;
                    }
                }

                int temp = 0;
                while (nums[start] != 1) {
                    temp++;
                    start++;
                }
                map.putIfAbsent(start, temp);
                cnt += map.get(start) + 1;
            }
            end++;
        }

        return cnt;
    }
}
