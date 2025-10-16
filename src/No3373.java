import java.util.*;
import java.util.function.DoubleToIntFunction;

public class No3373 {
    public static void main(String[] args) {
        No3373 o = new No3373();
        int[][] e1 = new int[][]{{0, 1}, {0, 2}, {2, 3}, {2, 4}};
        int[][] e2 = new int[][]{{0, 1}, {0, 2}, {0, 3}, {2, 7}, {1, 4}, {4, 5}, {4, 6}};
        System.out.println(Arrays.toString(o.maxTargetNodes(e1, e2)));
    }

    int first = 0;
    int second = 0;

    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        int l1 = edges1.length + 1;
        int l2 = edges2.length + 1;
        int[] ans = new int[l1];
        int[] m2 = new int[l2];

        Map<Integer, Set<Integer>> map1 = gen(edges1);
        Map<Integer, Set<Integer>> map2 = gen(edges2);

        int max = 0;
        int index = 0;
        for (int n : map2.keySet()) {
            index = n;
            m2[n] = rec(new HashSet<>(), n, map2, 0, 1);
            max = Math.max(max, m2[n]);
            break;
        }

        for (int n : map2.get(index)) {
            m2[n] = rec(new HashSet<>(), n, map2, 0, 1);
            max = Math.max(max, m2[n]);
            break;
        }

        for (int n : map1.keySet()) {
            index = n;
            ans[n] = rec(new HashSet<>(), n, map1, 0, 0);
            first = ans[n] + max;
            break;
        }

        for (int n : map1.get(index)) {
            ans[n] = rec(new HashSet<>(), n, map1, 0, 0);
            second = ans[n] + max;
            break;
        }
        tempRec(new HashSet<>(), map1, index, 0, ans);

        return ans;
    }

    private void tempRec(Set<Integer> included, Map<Integer, Set<Integer>> map, int cur, int level, int[] ans) {
        if (level % 2 == 0) {
            ans[cur] = first;
        } else {
            ans[cur] = second;
        }
        included.add(cur);
        Set<Integer> set = map.getOrDefault(cur, new HashSet<>());
        for (Integer num : set) {
            if (included.contains(num)) {
                continue;
            }

            tempRec(included, map, num, level + 1, ans);
        }

        included.remove(cur);
    }

    private int rec(Set<Integer> included, int cur, Map<Integer, Set<Integer>> map, int level, int isOd) {
        int ans = 0;
        if (level % 2 == isOd) {
            ans = 1;
        }
        included.add(cur);

        Set<Integer> set = map.getOrDefault(cur, new HashSet<>());
        for (Integer num : set) {
            if (included.contains(num)) {
                continue;
            }

            ans += rec(included, num, map, level + 1, isOd);
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
