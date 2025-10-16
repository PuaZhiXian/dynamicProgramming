import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class No2163 {
    public static void main(String[] args) {
        No2163 o = new No2163();
        System.out.println(o.minimumDifference(new int[]{16, 46, 43, 41, 42, 14, 36, 49, 50, 28, 38, 25, 17, 5, 18, 11, 14, 21, 23, 39, 23}));
    }

    public long minimumDifference(int[] nums) {
        int L = nums.length;
        int n = L / 3;
        long[][] minSum = new long[L - n + 1][2];
        long[][] maxSum = new long[L - n + 1][2];
        PriorityQueue<Integer> minpq = new PriorityQueue<>(Collections.reverseOrder());
        long sum = 0;
        int index = 0;
        for (int i = 0; i < L; i++) {
            if (i < n) {
                minpq.add(nums[i]);
                sum += nums[i];
                if (i == n - 1) {
                    minSum[index] = new long[]{sum, i};
                    index++;
                }
            } else {
                if (minpq.peek() > nums[i]) {
                    sum -= minpq.poll();
                    minpq.add(nums[i]);
                    sum += nums[i];
                    minSum[index] = new long[]{sum, i};
                } else {
                    minSum[index] = minSum[index - 1];
                }
                index++;
            }
        }

        PriorityQueue<Integer> maxpq = new PriorityQueue<>();
        sum = 0;
        index = 0;
        for (int i = L - 1; i >= 0; i--) {
            if (i >= L - n) {
                sum += nums[i];
                maxpq.add(nums[i]);
                if (i == L - n) {
                    maxSum[index] = new long[]{sum, i};
                    index++;
                }
            } else {
                if (maxpq.peek() < nums[i]) {
                    sum -= maxpq.poll();
                    maxpq.add(nums[i]);
                    sum += nums[i];
                    maxSum[index] = new long[]{sum, i};
                } else {
                    maxSum[index] = maxSum[index - 1];
                }
                index++;
            }
        }

        long min = Long.MAX_VALUE;
        for (int i = 0; i < minSum.length; i++) {
            if (minSum[i][1] >= n * 2) {
                break;
            }
            long temp = minSum[i][0] - maxSum[Math.toIntExact(L - n - 1 - minSum[i][1])][0];
            min = Math.min(min, temp);
        }

        return min;
    }
}
