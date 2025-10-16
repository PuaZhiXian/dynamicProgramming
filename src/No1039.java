import java.util.*;

public class No1039 {
    public static void main(String[] args) {
        No1039 o = new No1039();
        System.out.println(o.minScoreTriangulation(new int[]{94, 10, 38, 76, 69, 32, 24, 35, 82, 30, 86, 77, 92, 3, 35, 20, 84, 67, 23}));

    }

    int[][] dp = new int[50][50];
    int[] values;

    public int minScoreTriangulation(int[] values) {
        this.values = values;
        int n = values.length;
        return rec(0, n - 1);
    }

    private int rec(int i, int j) {
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        if (i + 2 > j) {
            return 0;
        }
        if (i + 2 == j) {
            return values[i] * values[i + 1] * values[i + 2];
        }

        int min = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            int cur = values[i] * values[k] * values[j] + rec(i, k) + rec(k, j);
            min = Math.min(min, cur);
        }
        dp[i][j] = min;


        return min;
    }


} 
