import java.util.HashMap;
import java.util.Map;

public class No930_BinarySubarraysWithSum {

    public static void main(String[] args) {

        System.out.println(numberOfSubarrays(new int[]{1, 0, 1, 0, 1}, 2));
//        System.out.println(numSubarraysWithSum(new int[]{0, 0, 0, 0, 0}, 0));
        System.out.println(numberOfSubarrays(new int[]{0, 0, 0, 0, 0}, 0));
    }

    public static int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;

        int cnt = 0;
        int sum = 0;

        while (end < nums.length) {
            sum += nums[end];
            if (sum == k) {
                System.out.println("sum == k");
                int temp = 0;
                if (nums[start] != 1) {
                    System.out.printf("Start with 0 ==> start : %s, end : %s\n", start, end);
                }
                while ((sum - nums[start] == k) && start != end) {
                    temp++;
                    start++;
                }
                map.putIfAbsent(start, map.getOrDefault(start - 1, 0) + temp);
                cnt += map.get(start) + 1;
                System.out.printf("start : %s, end : %s  added: %s\n", start, end, map.get(start) + 1);
            }
            if (sum > k) {
                System.out.println("sum > k");
                if (nums[start] == 1) {
                    System.out.printf("Start with 1 ==> start : %s, end : %s\n", start, end);
                    sum -= nums[start];
                    start++;
                }

                int temp = 0;
                if (nums[start] != 1) {
                    System.out.printf("Start with 0 ==> start : %s, end : %s\n", start, end);
                }
                while (nums[start] != 1) {
                    temp++;
                    start++;
                }
                map.putIfAbsent(start, map.getOrDefault(start - 1, 0) + temp);
                cnt += map.get(start) + 1;
                System.out.printf("start : %s, end : %s, edded: %s\n", start, end, map.get(start) + 1);
            }
            end++;
        }
        System.out.println(map);

        return cnt;
    }

    public static int numSubarraysWithSum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;

        int cnt = 0;
        int sum = 0;

        while (end < nums.length) {
            sum += nums[end];
            if (sum == k) {
                int temp = 0;
                while ((sum - nums[start] == k) && start != end) {
                    temp++;
                    start++;
                }
                map.putIfAbsent(start, map.getOrDefault(start - 1, 0) + temp);
                cnt += map.get(start) + 1;
            }
            if (sum > k) {
                if (nums[start] == 1) {
                    sum -= nums[start];
                    start++;
                }

                int temp = 0;
                while (nums[start] != 1) {
                    temp++;
                    start++;
                }
                map.putIfAbsent(start, map.getOrDefault(start - 1, 0) + temp);
                cnt += map.get(start) + 1;
            }
            end++;
        }

        return cnt;
    }
}
