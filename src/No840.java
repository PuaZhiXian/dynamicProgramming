import java.util.HashSet;
import java.util.Set;

public class No840 {
    public static void main(String[] args) {
        No840 obj = new No840();
    }

    public int numMagicSquaresInside(int[][] grid) {
        int ans = 0;
        if (grid.length < 3 || grid[0].length < 3) {
            return 0;
        }

        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[i].length - 1; j++) {
                ans += helper(i, j, grid);
            }
        }
        return ans;
    }

    public int helper(int rIndex, int cIndex, int[][] grid) {
        Set<Integer> set = new HashSet<>();

        int[] rowSum = new int[3];
        int[] colSum = new int[3];
        int[] diagonalSum = new int[2];

        int checked = 0;
        for (int i = rIndex - 1; i <= rIndex + 1; i++) {
            for (int j = cIndex - 1; j <= cIndex + 1; j++) {
                if (grid[i][j] > 9 || grid[i][j] < 1) {
                    return 0;
                }
                checked++;
                set.add(grid[i][j]);
                if (set.size() != checked) {
                    return 0;
                }

                rowSum[i - rIndex + 1] += grid[i][j];
                colSum[j - cIndex + 1] += grid[i][j];
            }
        }

        diagonalSum[0] = grid[rIndex][cIndex] + grid[rIndex - 1][cIndex - 1] + grid[rIndex + 1][cIndex + 1];
        diagonalSum[1] = grid[rIndex][cIndex] + grid[rIndex - 1][cIndex + 1] + grid[rIndex + 1][cIndex - 1];


        if (rowSum[0] == rowSum[1] && rowSum[1] == rowSum[2] && rowSum[2] == colSum[0]
                && colSum[0] == colSum[1] && colSum[1] == colSum[2] && colSum[2] == diagonalSum[0] &&
                diagonalSum[0] == diagonalSum[1]) {
            return 1;
        }

        return 0;
    }
}
