import com.sun.org.apache.xpath.internal.operations.Mod;

import java.util.*;

public class No417 {
    public static void main(String[] args) {
        No417 o = new No417();
        System.out.println(o.pacificAtlantic(new int[][]{
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        }));
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;
        int[][] direction = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        PriorityQueue<Model> pq = new PriorityQueue<>(Comparator.comparingInt(Model::getLevel));
        boolean[][] visited = new boolean[row][col];
        for (int j = 0; j < col; j++) {
            pq.add(new Model(heights[0][j], 0, j));
            visited[0][j] = true;
        }
        for (int i = 1; i < row; i++) {
            pq.add(new Model(heights[i][0], i, 0));
            visited[i][0] = true;
        }

        while (!pq.isEmpty()) {
            Model m = pq.poll();
            int curLevel = m.level;
            for (int i = 0; i < direction.length; i++) {
                int nextI = m.i + direction[i][0];
                int nextJ = m.j + direction[i][1];

                if (nextI >= 0 && nextI < row && nextJ >= 0 && nextJ < col && !visited[nextI][nextJ]) {
                    if (heights[nextI][nextJ] >= curLevel) {
                        visited[nextI][nextJ] = true;
                        pq.add(new Model(heights[nextI][nextJ], nextI, nextJ));
                    }
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>();

        boolean[][] visited2 = new boolean[row][col];

        for (int j = 0; j < col; j++) {
            pq.add(new Model(heights[row - 1][j], row - 1, j));
            visited2[row - 1][j] = true;
            if (visited[row - 1][j]) {
                ans.add(Arrays.asList(row - 1, j));
            }
        }
        for (int i = 0; i < row - 1; i++) {
            pq.add(new Model(heights[i][col - 1], i, col - 1));
            visited2[i][col - 1] = true;
            if (visited[i][col - 1]) {
                ans.add(Arrays.asList(i, col - 1));
            }
        }

        while (!pq.isEmpty()) {
            Model m = pq.poll();
            int curLevel = m.level;
            for (int i = 0; i < direction.length; i++) {
                int nextI = m.i + direction[i][0];
                int nextJ = m.j + direction[i][1];
                if (nextI >= 0 && nextI < row && nextJ >= 0 && nextJ < col && !visited2[nextI][nextJ]) {
                    if (heights[nextI][nextJ] >= curLevel) {
                        visited2[nextI][nextJ] = true;
                        if (visited[nextI][nextJ]) {
                            ans.add(Arrays.asList(nextI, nextJ));
                        }
                        pq.add(new Model(heights[nextI][nextJ], nextI, nextJ));
                    }
                }
            }
        }


        return ans;
    }

    class Model {
        int level;
        int i;
        int j;

        public Model(int level, int i, int j) {
            this.level = level;
            this.i = i;
            this.j = j;
        }

        public int getLevel() {
            return level;
        }
    }
} 
