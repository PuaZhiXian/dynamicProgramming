import java.util.*;

public class No2685 {
    public static void main(String[] args) {
        No2685 obj = new No2685();
        System.out.println(obj.countCompleteComponents(6, new int[][]{{0, 1}, {0, 2}, {1, 2}, {3, 4}}));
//        System.out.println(obj.countCompleteComponents(6, new int[][]{{0, 1}, {0, 2}, {1, 2}, {3, 4}, {3, 5}}));
    }

    public int countCompleteComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        int[] size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int i = 0; i < edges.length; i++) {
            int root1 = find(edges[i][0], parent);
            int root2 = find(edges[i][1], parent);
            if (root1 != root2) {
                if (size[root2] > size[root1]) {
                    parent[root1] = root2;
                    parent[edges[i][0]] = root2;
                    size[root2]++;
                } else {
                    parent[root2] = root1;
                    parent[edges[i][1]] = root1;
                    size[root1]++;
                }
            }
        }

//        System.out.println(Arrays.toString(parent));
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int p = find(i, parent);
            Set<Integer> lt = map.getOrDefault(p, new HashSet<>());
            lt.add(i);
            map.put(p, lt);
        }

        List<int[]> ed = new ArrayList<>(Arrays.asList(edges));
        int ans = 0;
        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
            int p = entry.getKey();
            Set<Integer> lt = entry.getValue();
            List<Integer> remove = new ArrayList<>();
            int cnt = 0;
            for (int i = 0; i < ed.size(); i++) {
                if (lt.contains(ed.get(i)[0]) || lt.contains(ed.get(i)[1])) {
                    cnt++;
                    remove.add(i);
                }
            }
            if (cnt == lt.size() * (lt.size() - 1) / 2) {
                ans++;
            }

            for (Integer re : remove) {
                ed.remove(re);
            }
        }

        return ans;
    }

    public int find(int i, int[] parent) {
        int root = parent[i];

        if (parent[root] != root) {
            return parent[i] = find(root, parent);
        }

        return root;
    }

}
