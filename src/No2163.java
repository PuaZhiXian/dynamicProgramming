import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class No2163 {
    public static void main(String[] args) {
        No2163 o = new No2163();
        System.out.println(o.minimumDifference(new int[]{3,1,2}));
    }

    public long minimumDifference(int[] nums) {
        int l = nums.length;
        int n = l / 3;
        int[][] minSum = new int[l - n + 1][2];
        int[][] maxSum = new int[l - n + 1][2];
        PriorityQueue<Integer> minpq = new PriorityQueue<>(Collections.reverseOrder());
        int sum = 0;
        int index = 0;
        for (int i = 0; i < l; i++) {
            if (i < n) {
                minpq.add(nums[i]);
                sum += nums[i];
                if (i == n - 1) {
                    minSum[index] = new int[]{sum, i};
                    index++;
                }
            } else {
                if (minpq.peek() > nums[i]) {
                    sum -= minpq.poll();
                    minpq.add(nums[i]);
                    sum += nums[i];
                    minSum[index] = new int[]{sum, i};
                } else {
                    minSum[index] = minSum[index - 1];
                }
                index++;
            }
        }


        PriorityQueue<Integer> maxpq = new PriorityQueue<>();
        sum = 0;
        index = 0;
        for (int i = l - 1; i >= 0; i--) {
            if (i >= l - n) {
                sum += nums[i];
                maxpq.add(nums[i]);
                if (i == l - n) {
                    maxSum[index] = new int[]{sum, i};
                    index++;
                }
            } else {
                if (maxpq.peek() < nums[i]) {
                    sum -= maxpq.poll();
                    maxpq.add(nums[i]);
                    sum += nums[i];
                    maxSum[index] = new int[]{sum, i};
                } else {
                    maxSum[index] = maxSum[index - 1];
                }
                index++;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < minSum.length; i++) {
            if (minSum[i][1] >= maxSum[i][1]) {
                break;
            }
            min = Math.min(min, minSum[i][0] - maxSum[i][0]);
        }
        return min;
    }
}
