import javafx.util.Pair;

import java.util.*;

public class No1765 {
    public static void main(String[] args) {
        No1765 obj = new No1765();
        System.out.println(Arrays.deepToString(obj.highestPeak(new int[][]{{0, 0, 1}, {1, 0, 0}, {0, 0, 0}})));

    }

    public int[][] highestPeak(int[][] isWater) {
        Queue<Model> stack = new LinkedList<>();
        boolean[][] visited = new boolean[isWater.length][isWater[0].length];
        for (int i = 0; i < isWater.length; i++) {
            for (int j = 0; j < isWater[i].length; j++) {
                if (isWater[i][j] == 1) {
                    stack.add(new Model(i, j, -1));
                    isWater[i][j] = 0;
                }
            }
        }

        while (!stack.isEmpty()) {
            Model m = stack.poll();

            if (!visited[m.i][m.j]) {
                visited[m.i][m.j] = true;
                isWater[m.i][m.j] = m.cnt + 1;

                if (m.i + 1 < isWater.length) {
                    if (!visited[m.i + 1][m.j]) {
                        stack.add(new Model(m.i + 1, m.j, m.cnt + 1));
                    }
                }

                if (m.i - 1 >= 0) {
                    if (!visited[m.i - 1][m.j]) {
                        stack.add(new Model(m.i - 1, m.j, m.cnt + 1));
                    }
                }

                if (m.j + 1 < isWater[0].length) {
                    if (!visited[m.i][m.j + 1]) {
                        stack.add(new Model(m.i, m.j + 1, m.cnt + 1));
                    }
                }

                if (m.j - 1 >= 0) {
                    if (!visited[m.i][m.j - 1]) {
                        stack.add(new Model(m.i, m.j - 1, m.cnt + 1));
                    }
                }
            }

        }

        return isWater;
    }

    class Model {
        int i;
        int j;
        int cnt;

        public Model(int i, int j, int cnt) {
            this.i = i;
            this.j = j;
            this.cnt = cnt;
        }

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }

        public int getJ() {
            return j;
        }

        public void setJ(int j) {
            this.j = j;
        }

        public int getCnt() {
            return cnt;
        }

        public void setCnt(int cnt) {
            this.cnt = cnt;
        }
    }
}
