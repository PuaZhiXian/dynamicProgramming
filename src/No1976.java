import java.util.Arrays;
import java.util.Map;

public class No1976 {
    public static void main(String[] args) {
        No1976 obj = new No1976();
        System.out.println(obj.countPaths(7, new int[][]{{0, 6, 7}, {0, 1, 2}, {1, 2, 3}, {1, 3, 3}, {6, 3, 3}, {3, 5, 1}, {6, 5, 1}, {2, 5, 1}, {0, 4, 5}, {4, 6, 2}}));
    }

    private static final int MOD = (int) 1e9 + 7;

    public int countPaths(int n, int[][] roads) {
        long[] cnt = new long[n];
        long[][] graph = new long[n][n];
        long[] dis = new long[n];
        boolean[] visited = new boolean[n];
        for (long[] ints : graph) {
            Arrays.fill(ints, Long.MAX_VALUE);
        }
        for (int[] road : roads) {
            graph[road[0]][road[1]] = road[2];
            graph[road[1]][road[0]] = road[2];
        }

        Arrays.fill(dis, Long.MAX_VALUE);
        dis[0] = 0;
        cnt[0] = 1;

        for (int i = 0; i < dis.length - 1; i++) {
            int u = minDis(dis, visited);
            visited[u] = true;

            for (int j = 0; j < graph[u].length; j++) {
                if (j == u) {
                    continue;
                }
                if (graph[u][j] != Long.MAX_VALUE) {
                    long newDis = graph[u][j] + dis[u];
                    if (dis[j] == Long.MAX_VALUE) {
                        dis[j] = newDis;
                        cnt[j] = cnt[u];
                    } else if (newDis == dis[j]) {
                        cnt[j] = (cnt[u] + cnt[j]) % MOD;
                    } else if (newDis < dis[j]) {
                        dis[j] = newDis;
                        cnt[j] = cnt[u];
                    }
                }
            }
        }

        return (int) (cnt[n - 1] % MOD);
    }

    private int minDis(long[] dis, boolean[] visited) {
        long min = Long.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < dis.length; i++) {
            if (!visited[i] && dis[i] <= min) {
                min = dis[i];
                index = i;
            }
        }
        return index;
    }
}
