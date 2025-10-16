import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class No2322 {
    public static void main(String[] args) {
        No2322 o = new No2322();
//        System.out.println(1 ^ 5 ^ 4 ^ 11 ^ 5); //0
//        System.out.println(5 ^ 4 ^ 11 ^ 5); //1
//        System.out.println(5); //2
//        System.out.println(4 ^ 11); //3
//        System.out.println(11);//4
//        System.out.println();
//        System.out.println(o.minimumScore(new int[]{1, 5, 5, 4, 11}, new int[][]{{0, 1}, {1, 2}, {1, 3}, {3, 4}}));
//        debug(9, 1, 14, 2);
//        debug(14);
//        debug(2);
//        debug(1, 2, 14);
        debug(14, 1);
        System.out.println(o.minimumScore(new int[]{9, 14, 2, 1}, new int[][]{{2, 3}, {3, 0}, {3, 1}})); // 11
    }

    private static void debug(int... num) {
        int c = 0;
        for (int n : num) {
            c ^= n;
        }
        System.out.println(c);
    }

    boolean[][] lca;
    int[] xor;

    public int minimumScore(int[] nums, int[][] edges) {
        int n = nums.length;
        int[][] matrix = new int[n][n];
        for (int i = 0; i < edges.length; i++) {
            matrix[edges[i][0]][edges[i][1]] = 1;
            matrix[edges[i][1]][edges[i][0]] = 1;
        }

        lca = new boolean[n][n];
        xor = new int[n];
        lcarec(0, new HashSet<>(), matrix);

        xorrec(0, new HashSet<>(), matrix, nums);

        int best = Integer.MAX_VALUE;
        int total = xor[0];
        for (int aIndex = 1; aIndex < n; aIndex++) {
            for (int bIndex = aIndex + 1; bIndex < n; bIndex++) {
                int a = xor[aIndex];
                int b = xor[bIndex];

                int[] arr;
                if (lca[bIndex][aIndex]) { //b is child of a
                    arr = new int[]{b, a ^ b, total ^ a};
                } else if (lca[aIndex][bIndex]) { // a is child of b
                    arr = new int[]{a, b ^ a, total ^ b};
                } else {
                    arr = new int[]{a, b, total ^ a ^ b};
                }

                Arrays.sort(arr);
                best = Math.min(best, arr[2] - arr[0]);
            }
        }

        return best;
    }

    private void lcarec(int node, Set<Integer> old, int[][] matrix) {
        for (int p : old) {
            lca[node][p] = true;
        }
        // meaning : node have parent of p
        old.add(node);
        for (int i = 0; i < matrix[node].length; i++) {
            if (i == node)
                continue;
            if (matrix[node][i] == 0) {
                continue;
            }
            if (old.contains(i)) {
                continue;
            }
            lcarec(i, old, matrix);
        }
        old.remove(node);
    }

    private int xorrec(int node, Set<Integer> old, int[][] matrix, int[] nums) {
        int cur = nums[node];
        old.add(node);
        for (int i = 0; i < matrix[node].length; i++) {
            if (old.contains(i) || matrix[node][i] == 0) {
                continue;
            }
            cur ^= xorrec(i, old, matrix, nums);
        }
        old.remove(node);
        xor[node] = cur;
        return cur;
    }
}
