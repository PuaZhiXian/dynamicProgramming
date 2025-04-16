import java.util.Arrays;

public class No1334 {

    public static void main(String[] args) {
        No1334 obj = new No1334();
        System.out.println(obj.findTheCity(4, new int[][]{
                {0, 1, 3},
                {1, 2, 1},
                {1, 3, 4},
                {2, 3, 1}
        }, 4));
    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = 100001;
            }
        }

        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            int cost = edges[i][2];
            matrix[from][to] = cost;
            matrix[to][from] = cost;
        }

        for (int i = 0; i < n; i++) {
            matrix[i][i] = 0;
        }

        matrix = floydWarshall(n, matrix);
        int[] cnt = new int[n];
        System.out.println(Arrays.deepToString(matrix));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == i) {
                    continue;
                }
                if (matrix[i][j] <= distanceThreshold) {
                    cnt[i]++;
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int ans = -1;
        for (int i = 0; i < cnt.length; i++) {
            if (min >= cnt[i]) {
                min = cnt[i];
                ans = i;
            }
        }
        System.out.println(Arrays.toString(cnt));
        return ans;
    }

    int[][] floydWarshall(int V, int[][] dist) {
        int i, j, k;
        for (k = 0; k < V; k++) {
            for (i = 0; i < V; i++) {
                for (j = 0; j < V; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }
        return dist;
    }
}
