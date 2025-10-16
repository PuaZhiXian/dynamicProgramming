import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class No1751 {
    public static void main(String[] args) {
        No1751 o = new No1751();
        System.out.println(o.maxValue(new int[][]{{1, 1, 1}, {2, 2, 2}, {3, 3, 3}, {4, 4, 4}}, 3));
    }

    int[][] events;
    int n;
    int[][] dp;

    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, Comparator.comparingInt(value -> value[0]));
        this.events = events;
        this.n = events.length;
        dp = new int[k + 1][n];
        for (int[] temp : dp) {
            Arrays.fill(temp, -1);
        }

        return rec(0, k);
    }

    //return val
    private int rec(int cur, int k) {
        if (k == 0 || cur == n) {
            return 0;
        }

        if (dp[k][cur] != -1) {
            return dp[k][cur];
        }

        int noSelect = rec(cur + 1, k);
        int nextIndex = getNextIndex(events[cur][1], cur);
        int select = events[cur][2] + rec(nextIndex, k - 1);

        dp[k][cur] = Math.max(select, noSelect);
        return dp[k][cur];
    }


    private int getNextIndex(int target, int start) {
        int left = start;
        int right = n;

        while (left < right) {
            int mid = (right + left) / 2;
            if (events[mid][0] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
