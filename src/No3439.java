import java.util.Arrays;

public class No3439 {
    public static void main(String[] args) {
        No3439 o = new No3439();
        System.out.println(o.maxFreeTime(21, 1, new int[]{7, 10, 16}, new int[]{10, 14, 18}));
    }

    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int max = 0;
        int[] free = new int[startTime.length + 1];
        int prev = 0;
        for (int i = 0; i < startTime.length; i++) {
            free[i] = startTime[i] - prev;
            prev = endTime[i];
        }

        free[free.length - 1] = eventTime - endTime[endTime.length - 1];

        int sum = free[0];
        max = sum;
        int start = 0;
        for (int i = 1; i < free.length; i++) {
            if (i - start >= k + 1) {
                sum -= free[start];
                start++;
            }
            sum += free[i];

            max = Math.max(sum, max);
        }


        return max;
    }
}
