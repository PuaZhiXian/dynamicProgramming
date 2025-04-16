import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No695 {
    public static void main(String[] args) {
        No695 obj = new No695();
//        System.out.println(obj.maxAreaOfIsland(
//                new int[][]{
//                        {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0},
//                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0},
//                        {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0},
//                        {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1},
//                        {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1},
//                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
//                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0},
//                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0}
//                }));
        System.out.println(obj.maxAreaOfIsland(
                new int[][]{
                        {0, 0, 1},
                        {0, 0, 0},
                        {0, 1, 1},
                        {0, 1, 0}
                }));

    }

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, getSurrounding(grid, i, j));
                }
            }
        }

        return max;
    }

    public int getSurrounding(int[][] grid, int i, int j) {
        int cnt = 0;
        if (grid[i][j] == 0) {
            return cnt;
        }
        cnt++;
        grid[i][j] = 0;

        if (i - 1 >= 0 && grid[i - 1][j] == 1) {
            cnt = cnt + getSurrounding(grid, i - 1, j);
        }
        if (j + 1 < grid[0].length && grid[i][j + 1] == 1) {
            cnt = cnt + getSurrounding(grid, i, j + 1);
        }
        if (i + 1 < grid.length && grid[i + 1][j] == 1) {
            cnt = cnt + getSurrounding(grid, i + 1, j);
        }
        if (j - 1 >= 0 && grid[i][j - 1] == 1) {
            cnt = cnt + getSurrounding(grid, i, j - 1);
        }

        return cnt;
    }

}
