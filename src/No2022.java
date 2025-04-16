import java.util.Arrays;

public class No2022 {
    public static void main(String[] args) {
        No2022 obj = new No2022();
        System.out.println(Arrays.deepToString(obj.construct2DArray(new int[]{1, 2}, 1, 1)));
    }

    public int[][] construct2DArray(int[] original, int m, int n) {
        if (m * n < original.length || m * n > original.length) {
            return new int[0][0];
        }
        int[][] ans = new int[m][n];

        int index = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = original[index];
                index++;
            }
        }
        return ans;
    }
}
