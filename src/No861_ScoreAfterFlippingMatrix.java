public class No861_ScoreAfterFlippingMatrix {
    public static void main(String[] args) {
        int[][] n = {
                {0, 0, 1, 1},
                {1, 0, 1, 0},
                {1, 1, 0, 0}
        };
        System.out.println(matrixScore(n));
        System.out.println(matrixScore(new int[][]{{0}}));
    }

    public static int matrixScore(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == 0) {
                for (int j = 0; j < grid[i].length; j++) {
                    grid[i][j] ^= 1;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < grid[0].length; i++) {
            int zeroCnt = 0;
            int oneCnt = 0;
            for (int j = 0; j < grid.length; j++) {
                if (grid[j][i] == 1) {
                    oneCnt++;
                } else {
                    zeroCnt++;
                }
            }
            sum = sum + (Math.max(zeroCnt, oneCnt) * (int) Math.pow(2, grid[0].length - i - 1));
        }
        return sum;
    }
}
