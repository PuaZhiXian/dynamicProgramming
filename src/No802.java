import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No802 {

    private final int UNPROCESS = 0;
    private final int POSITIVE = 1;
    private final int NEGATIVE = -1;

    public static void main(String[] args) {
        No802 obj = new No802();
        System.out.println(obj.eventualSafeNodes(new int[][]{{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}}));
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<>();

        int[] memo = new int[graph.length];
        int[] visited = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (memo[i] == UNPROCESS) {
                sub(graph, memo, i, visited);
            }
        }

        for (int i = 0; i < memo.length; i++) {
            if (memo[i] == 1) {
                ans.add(i);
            }
        }

        return ans;
    }

    public boolean sub(int[][] graph, int[] memo, int processing, int[] visited) {
        if (visited[processing] == 1) {
            memo[processing] = NEGATIVE;
            return false;
        }

        if (memo[processing] != UNPROCESS) {
            return memo[processing] == POSITIVE;
        }

        visited[processing] = 1;
        boolean safe = true;
        for (int i = 0; i < graph[processing].length; i++) {
            safe = safe && sub(graph, memo, graph[processing][i], visited);
            if (!safe) {
                break;
            }
        }
        memo[processing] = safe ? POSITIVE : NEGATIVE;
        visited[processing] = 0;

        return safe;
    }


}
