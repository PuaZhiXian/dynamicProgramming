import javafx.util.Pair;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class No3342 {
    public static void main(String[] args) {
        No3342 obj = new No3342();
        System.out.println(obj.minTimeToReach(new int[][]{{0, 4}, {4, 4}}));//7

    }

    int[][] step = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int minTimeToReach(int[][] moveTime) {
        boolean[][] visited = new boolean[moveTime.length][moveTime[0].length];

        int[][] dist = new int[moveTime.length][moveTime[0].length];
        for (int[] arr : dist) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

        PriorityQueue<Model> queue = new PriorityQueue<>();
        queue.add(new Model(0, 0, 0));
        dist[0][0] = 0;
        while (!queue.isEmpty()) {
            Model m = queue.poll();
            int i = m.i;
            int j = m.j;

            if (visited[i][j]) continue;
            visited[i][j] = true;

            for (int k = 0; k < step.length; k++) {
                int ni = i + step[k][0];
                int nj = j + step[k][1];

                if (ni >= 0 && ni < moveTime.length && nj >= 0 && nj < moveTime[0].length) {
                    int temp = Math.max(moveTime[ni][nj], dist[i][j]) + ((i + j) % 2) + 1;
                    if (temp < dist[ni][nj]) {
                        dist[ni][nj] = temp;
                        queue.add(new Model(ni, nj, dist[ni][nj]));
                    }
                }
            }
        }

//        System.out.println(Arrays.deepToString(visited));
//        System.out.println(Arrays.deepToString(dist));
        return dist[moveTime.length - 1][moveTime[0].length - 1];
    }

    class Model implements Comparable<Model> {
        int i;
        int j;
        int d;

        public Model(int i, int j, int d) {
            this.i = i;
            this.j = j;
            this.d = d;
        }

        @Override
        public int compareTo(Model o) {
            return Integer.compare(this.d, o.d);
        }
    }

}
