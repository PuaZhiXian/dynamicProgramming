import java.util.*;

public class No1857 {
    public static void main(String[] args) {
        No1857 obj = new No1857();
//        System.out.println(obj.largestPathValue("abaca", new int[][]{{0, 1}, {0, 2}, {2, 3}, {3, 4}}));
        System.out.println(obj.largestPathValue("iiiiii", new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 5}}));
    }

    int[][] colorCnt;
    boolean[] visited;
    int max = 1;
    char[] color;
    Map<Integer, List<Integer>> map = new HashMap<>();

    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        colorCnt = new int[n][26];
        color = colors.toCharArray();
        visited = new boolean[n];
        for (int[] edge : edges) {
            List<Integer> lt = map.getOrDefault(edge[0], new ArrayList<>());
            lt.add(edge[1]);
            map.put(edge[0], lt);
        }

//        System.out.println(map);

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int from = entry.getKey();
            if (visited[from]) {
                continue;
            }
            int res = rec(new HashSet<>(), from);
            if (res == -1) {
                return -1;
            }
        }

        return max;
    }

    /**
     * cur >> current node index
     * color[cur] - 'a' >> get colorIndex. eg.  a>>0, b>>1
     */
    public int rec(Set<Integer> included, int cur) {
        if (included.contains(cur)) {
            return -1;
        }
        included.add(cur);
        int colorIndex = color[cur] - 'a';

        List<Integer> lt = map.getOrDefault(cur, new ArrayList<>());
        for (Integer to : lt) {
            if (!visited[to]) {
                int res = rec(included, to);
                if (res == -1) {
                    return -1;
                }
            }

            for (int i = 0; i < 26; i++) {
                colorCnt[cur][i] = Math.max(colorCnt[cur][i], colorCnt[to][i]);
                max = Math.max(colorCnt[cur][i], max);
            }
        }

        colorCnt[cur][colorIndex]++;
        max = Math.max(max, colorCnt[cur][colorIndex]);
        visited[cur] = true;
        included.remove(cur);
        return 0;
    }
}
