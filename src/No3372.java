import java.util.*;

public class No3372 {
    public static void main(String[] args) {
        No3372 o = new No3372();
        int[][] e1 = new int[][]{{0, 1}, {0, 2}, {2, 3}, {2, 4}};
        int[][] e2 = new int[][]{{0, 1}, {0, 2}, {0, 3}, {2, 7}, {1, 4}, {4, 5}, {4, 6}};
        System.out.println(Arrays.toString(o.maxTargetNodes(e1, e2, 2)));
    }

    int k_1;

    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        this.k_1 = k - 1;
        int l1 = edges1.length + 1;
        int l2 = edges2.length + 1;
        int[] ans = new int[l1];
        int[] m2 = new int[l2];

        Map<Integer, Set<Integer>> map1 = gen(edges1);
        Map<Integer, Set<Integer>> map2 = gen(edges2);

        int max = 0;
        for (int n : map2.keySet()) {
            m2[n] = rec(new HashSet<>(), n, map2, 0, k_1);
            max = Math.max(max, m2[n]);
        }


        for (int n : map1.keySet()) {
            ans[n] = rec(new HashSet<>(), n, map1, 0, k) + max;
        }


        return ans;
    }

    private int rec(Set<Integer> included, int cur, Map<Integer, Set<Integer>> map, int level, int limit) {
        if (level > limit) {
            return 0;
        }
        int ans = 1;
        included.add(cur);

        Set<Integer> set = map.getOrDefault(cur, new HashSet<>());
        for (Integer num : set) {
            if (included.contains(num)) {
                continue;
            }
            ans += rec(included, num, map, level + 1, limit);
        }

        included.remove(cur);
        return ans;
    }

    private Map<Integer, Set<Integer>> gen(int[][] e) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] o : e) {
            Set<Integer> set1 = map.getOrDefault(o[0], new HashSet<>());
            set1.add(o[1]);
            map.put(o[0], set1);

            Set<Integer> set2 = map.getOrDefault(o[1], new HashSet<>());
            set2.add(o[0]);
            map.put(o[1], set2);
        }
        return map;
    }
}
