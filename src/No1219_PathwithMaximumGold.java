/**
 * https://leetcode.com/problems/path-with-maximum-gold
 */
public class No1219_PathwithMaximumGold {
    public static void main(String[] args) {
        int[][] n = {
                {1, 0, 7},
                {2, 0, 6},
                {3, 4, 5},
                {0, 3, 0},
                {9, 0, 20}
        };
        int[][] n2 = {
                {0, 6, 0},
                {5, 8, 7},
                {0, 9, 0}
        };

        int[][] n3 = {
                {13, 0, 21, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 23, 12},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 27, 0, 0, 0, 24, 0},
                {3, 10, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 5, 0, 0, 0, 0},
                {15, 0, 0, 28, 3, 16, 0, 0},
                {3, 0, 0, 0, 30, 0, 0, 0}
        };

        System.out.println(getMaximumGold(n)); //28
        System.out.println(getMaximumGold(n2));//24
        System.out.println(getMaximumGold(n3));//66
    }

    public static int getMaximumGold(int[][] grid) {
        int max = 0;
        int startFromNotZero = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int val = getMaximumGold(grid, i, j);
                startFromNotZero = val > 0 ? startFromNotZero + 1 : startFromNotZero;
                max = Math.max(max, val);
                if (startFromNotZero >= 25) {
                    System.out.println("break");
                    return max;
                }
            }
        }
        return max;
    }

    public static int getMaximumGold(int[][] grid, int row, int col) {
        if (grid[row][col] == 0) {
            return 0;
        }
        int max = 0;
        int cur = grid[row][col];
        //left
        if (col + 1 < grid[row].length) {
            grid[row][col] = 0;
            max = Math.max(max, cur + getMaximumGold(grid, row, col + 1));
            grid[row][col] = cur;
        }
        //right
        if (col - 1 >= 0) {
            grid[row][col] = 0;
            max = Math.max(max, cur + getMaximumGold(grid, row, col - 1));
            grid[row][col] = cur;
        }
        //top
        if (row + 1 < grid.length) {
            grid[row][col] = 0;
            max = Math.max(max, cur + getMaximumGold(grid, row + 1, col));
            grid[row][col] = cur;
        }
        //bottom
        if (row - 1 >= 0) {
            grid[row][col] = 0;
            max = Math.max(max, cur + getMaximumGold(grid, row - 1, col));
            grid[row][col] = cur;
        }
        return max;
    }
}
