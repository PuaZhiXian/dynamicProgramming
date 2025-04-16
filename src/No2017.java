import java.util.Arrays;

public class No2017 {
    public static void main(String[] args) {
//[[1, 3, 1, 15],[1, 3, 3, 1]]
        No2017 obj = new No2017();
//        System.out.println(obj.gridGame(new int[][]{{20, 3, 20, 17, 2, 12, 15, 17, 4, 15}, {20, 10, 13, 14, 15, 5, 2, 3, 14, 3}})); //63
        System.out.println(obj.gridGame(new int[][]{{1, 3, 1, 15}, {1, 3, 3, 1}})); //63
    }

    public long gridGame(int[][] grid) {
        long ans = Long.MAX_VALUE;
        int n = grid[0].length;

        long[] a = new long[n];
        long[] b = new long[n];

        a[n - 1] = grid[0][n - 1];
        for (int i = n - 2; i > 0; i--) {
            a[i] = a[i + 1] + grid[0][i];
        }

        b[0] = grid[1][0];
        for (int i = 1; i < n - 1; i++) {
            b[i] = b[i - 1] + grid[1][i];
        }


        int aIndex = 1;
        int bIndex = -1;
        for (int i = 0; i < n; i++) {
            long num1 = 0;
            long num2 = 0;
            if (aIndex != n) {
                num1 = a[aIndex];
            }
            if (bIndex != -1) {
                num2 = b[bIndex];
            }

            aIndex++;
            bIndex++;
            ans = Math.min(Math.max(num2, num1), ans);
        }

        return ans;


    }

}
