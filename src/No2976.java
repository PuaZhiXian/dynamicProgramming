public class No2976 {
    public static void main(String[] args) {
        No2976 obj = new No2976();

        System.out.println(obj.minimumCost("abcd", "acbe",
                new char[]{'a', 'b', 'c', 'c', 'e', 'd'},
                new char[]{'b', 'c', 'b', 'e', 'b', 'e'},
                new int[]{2, 5, 5, 1, 2, 20}));
    }

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int n = 26;
        long[][] matrix = new long[n][n];


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = -1;
            }
        }

        for (int i = 0; i < original.length; i++) {
            int from = original[i] - 'a';
            int to = changed[i] - 'a';
            int price = cost[i];
            if(matrix[from][to] ==-1){
                matrix[from][to] = price;
            }else{
                matrix[from][to] = Math.min(matrix[from][to], price);

            }
        }
        for (int i = 0; i < n; i++) {
            matrix[i][i] = 0;
        }
        matrix = floydWarshall(n, matrix);

        long ans = 0;
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) != target.charAt(i)) {
                int from = source.charAt(i) - 'a';
                int to = target.charAt(i) - 'a';
                if (matrix[from][to] == -1) {
                    return -1;
                }
                ans += matrix[from][to];
            }
        }

        return ans;
    }

    long[][] floydWarshall(int V, long[][] dist) {
        int i, j, k;
        for (k = 0; k < V; k++) {
            for (i = 0; i < V; i++) {
                for (j = 0; j < V; j++) {
                    if (dist[i][k] == -1 || dist[k][j] == -1) {

                    } else {
                        if (dist[i][j] == -1) {
                            dist[i][j] = dist[i][k] + dist[k][j];
                            continue;
                        }
                        if (dist[i][k] + dist[k][j] < dist[i][j]) {
                            dist[i][j] = dist[i][k] + dist[k][j];
                        }
                    }
                }
            }
        }
        return dist;
    }
}
