import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No1905 {

    public static void main(String[] args) {
        No1905 obj = new No1905();
        System.out.println(obj.countSubIslands(
                new int[][]{{1, 0, 1, 0, 1}, {1, 1, 1, 1, 1}, {0, 0, 0, 0, 0}, {1, 1, 1, 1, 1}, {1, 0, 1, 0, 1}},
                new int[][]{{0, 0, 0, 0, 0}, {1, 1, 1, 1, 1}, {0, 1, 0, 1, 0}, {0, 1, 0, 1, 0}, {1, 0, 0, 0, 1}}
        ));
    }

    boolean isSub;

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int ans = 0;
        for (int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2[i].length; j++) {
                if (grid2[i][j] == 1) {
                    isSub = true;
                    isSub(grid1, grid2, i, j);
                    if (isSub) {
//                        System.out.println(i + " : " + j);
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    public void isSub(int[][] grid1, int[][] grid2, int rStart, int cStart) {
        if (rStart < 0 || rStart == grid2.length || cStart < 0 || cStart == grid2[0].length || grid2[rStart][cStart] == 0) {
            return;
        }
        if (grid1[rStart][cStart] != grid2[rStart][cStart]) {
            isSub = false;
        }

        grid2[rStart][cStart] = 0;

        List<List<Integer>> need = new ArrayList<>();

        need.add(Arrays.asList(rStart, cStart + 1));
        need.add(Arrays.asList(rStart + 1, cStart));
        need.add(Arrays.asList(rStart, cStart - 1));
        need.add(Arrays.asList(rStart - 1, cStart));

        for (List<Integer> integers : need) {
            isSub(grid1, grid2, integers.get(0), integers.get(1));
        }
    }
}
