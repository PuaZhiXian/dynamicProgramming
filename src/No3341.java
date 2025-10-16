import javafx.util.Pair;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class No3341 {
    public static void main(String[] args) {
        No3341 obj = new No3341();
        System.out.println(obj.minTimeToReach(new int[][]{{0, 4}, {4, 4}}));//6
        System.out.println(obj.minTimeToReach(new int[][]{{0, 0, 0}, {0, 0, 0}}));//3
        System.out.println(obj.minTimeToReach(new int[][]{{56, 93}, {3, 38}}));//39
        System.out.println(obj.minTimeToReach(new int[][]{{94, 79, 62, 27, 69, 84}, {6, 32, 11, 82, 42, 30}})); //72
    }

    int[][] step = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int minTimeToReach(int[][] moveTime) {
        boolean[][] visited = new boolean[moveTime.length][moveTime[0].length];
        visited[0][0] = true;

        int[][] dist = new int[moveTime.length][moveTime[0].length];
        for (int[] arr : dist) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(0, 0));
        dist[0][0] = 0;
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> pair = queue.poll();
            int i = pair.getKey();
            int j = pair.getValue();

            for (int k = 0; k < step.length; k++) {
                int ni = i + step[k][0];
                int nj = j + step[k][1];

                if (ni >= 0 && ni < moveTime.length && nj >= 0 && nj < moveTime[0].length) {
                    int temp = Math.max(0, moveTime[ni][nj] - dist[i][j]) + dist[i][j] + 1;
                    if (temp < dist[ni][nj]) {
                        dist[ni][nj] = temp;
                        queue.add(new Pair<>(ni, nj));
                    } else if (!visited[ni][nj]) {
                        visited[ni][nj] = true;
                        queue.add(new Pair<>(ni, nj));
                    }
                }
            }
        }

//        System.out.println(Arrays.deepToString(visited));
//        System.out.println(Arrays.deepToString(dist));
        return dist[moveTime.length - 1][moveTime[0].length - 1];
    }


}
