import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No1568 {
    public static void main(String[] args) {
        No1568 obj = new No1568();

//        System.out.println(obj.minDays(new int[][]{{0, 1, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}}));
//        System.out.println(obj.minDays(new int[][]{{1, 0, 1, 0}}));
//        System.out.println(obj.minDays(new int[][]{{1, 1}}));
        System.out.println(obj.minDays(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
    }

    public int minDays(int[][] grid) {
        if (helper(grid)) {
//            System.out.println("already split");
            return 0;
        }


        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    if (helper(grid)) {
                        return 1;
                    }
                    grid[i][j] = 1;
                }
            }
        }
        return 2;
    }

    public boolean helper(int[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        int islandCnt = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int ans = landChecker(grid, visited, i, j);
                islandCnt += ans;
//                System.out.println(ans);
//                System.out.printf("i:%s, j:%s \n", i, j);
                if (islandCnt > 1) {
                    return true;
                }
            }
        }
        if (islandCnt == 0) {
            return true;
        }
        return false;
    }


    public int landChecker(int[][] matrix, int[][] visited, int rStart, int cStart) {
//        if (rStart == 0 && cStart == 1) {
//            System.out.println(Arrays.deepToString(matrix));
//            System.out.println(Arrays.deepToString(visited));
//        }
        if (visited[rStart][cStart] == 1) {
            return 0;
        }
        visited[rStart][cStart] = 1;
        if (matrix[rStart][cStart] == 0) {
            return 0;
        }


        List<List<Integer>> need = new ArrayList<>();
        if (cStart + 1 < matrix[rStart].length) {
            if (matrix[rStart][cStart + 1] == 1 && visited[rStart][cStart + 1] == 0) {
//                System.out.println("move left");
                need.add(Arrays.asList(rStart, cStart + 1));
            }
        }
        if (rStart + 1 < matrix.length) {
            if (matrix[rStart + 1][cStart] == 1 && visited[rStart + 1][cStart] == 0) {
                need.add(Arrays.asList(rStart + 1, cStart));
            }
        }

        if (cStart - 1 >= 0) {
            if (matrix[rStart][cStart - 1] == 1 && visited[rStart][cStart - 1] == 0) {
                need.add(Arrays.asList(rStart, cStart - 1));
            }
        }

        if (rStart - 1 >= 0) {
            if (matrix[rStart - 1][cStart] == 1 && visited[rStart - 1][cStart] == 0) {
                need.add(Arrays.asList(rStart - 1, cStart));
            }
        }

        for (List<Integer> integers : need) {
            landChecker(matrix, visited, integers.get(0), integers.get(1));
        }
        return 1;
    }


}
