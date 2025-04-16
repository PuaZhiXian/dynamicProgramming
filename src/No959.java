import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No959 {
    public static void main(String[] args) {
        No959 obj = new No959();
        System.out.println(obj.regionsBySlashes(new String[]{
                " /",
                "  "
        }));
    }

    public int regionsBySlashes(String[] grid) {
        int ans = 0;
        int[][] matrix = new int[grid.length * 3][grid.length * 3];
        int[][] visited = new int[grid.length * 3][grid.length * 3];

        for (int i = 0; i < grid.length; i++) {
            char[] c = grid[i].toCharArray();
            for (int j = 0; j < c.length; j++) {
                builder(matrix, c[j], i, j);
            }
        }
//        System.out.println(Arrays.deepToString(matrix));

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (visited[i][j] == 1) {
                    continue;
                }
                int temp = dfs(matrix, visited, i, j);
                ans += temp;
                /*if (temp == 1) {
                    System.out.printf("i: %s , j:%s \n", i, j);
                }*/
            }
        }

        return ans;
    }

    public void builder(int[][] matrix, char pattern, int rStart, int cStart) {
        if (pattern == ' ') {
            return;
        }
        matrix[rStart * 3 + 1][cStart * 3 + 1] = 1;

        if (pattern == '/') {
            matrix[rStart * 3][cStart * 3 + 2] = 1;
            matrix[rStart * 3 + 2][cStart * 3] = 1;
        } else {
            matrix[rStart * 3][cStart * 3] = 1;
            matrix[rStart * 3 + 2][cStart * 3 + 2] = 1;
        }
    }


    public int dfs(int[][] matrix, int[][] visited, int rStart, int cStart) {
        if (visited[rStart][cStart] == 1) {
            return 0;
        }
        visited[rStart][cStart] = 1;
        if (matrix[rStart][cStart] == 1) {
            return 0;
        }


        List<List<Integer>> need = new ArrayList<>();
        if (cStart + 1 < matrix.length) {
            if (matrix[rStart][cStart + 1] == 0 && visited[rStart][cStart + 1] == 0) {
                need.add(Arrays.asList(rStart, cStart + 1));
            }
        }
        if (rStart + 1 < matrix.length) {
            if (matrix[rStart + 1][cStart] == 0 && visited[rStart + 1][cStart] == 0) {
                need.add(Arrays.asList(rStart + 1, cStart));
            }
        }

        if (cStart - 1 >= 0) {
            if (matrix[rStart][cStart - 1] == 0 && visited[rStart][cStart - 1] == 0) {
                need.add(Arrays.asList(rStart, cStart - 1));
            }
        }

        if (rStart - 1 >= 0) {
            if (matrix[rStart - 1][cStart] == 0 && visited[rStart - 1][cStart] == 0) {
                need.add(Arrays.asList(rStart - 1, cStart));
            }
        }

        for (List<Integer> integers : need) {
            dfs(matrix, visited, integers.get(0), integers.get(1));
        }


        return 1;
    }
}
