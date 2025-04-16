import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class No3108 {
    public static void main(String[] args) {
        No3108 obj = new No3108();
//        System.out.println(12 & 2);
        System.out.println(Arrays.toString(obj.minimumCost(
                7,
                new int[][]{{3, 1, 9}, {5, 4, 11}, {5, 0, 10}, {2, 6, 0}, {4, 3, 12}, {5, 0, 3}, {2, 1, 10}},
                new int[][]{{2, 5}, {1, 4}}
        ))); // 0,0
    }

    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        int[] parent = new int[n];
        int[] size = new int[n];
        int[] cost = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
            cost[i] = -1;
        }

        for (int i = 0; i < edges.length; i++) {
            int root1 = find(edges[i][0], parent);
            int root2 = find(edges[i][1], parent);
            if (root1 != root2) {
                if (size[root2] > size[root1]) {
                    parent[root1] = root2;
                    parent[edges[i][0]] = root2;
                    size[root2]++;
                    int ori = cost[root2] == -1 ? edges[i][2] : cost[root2] & edges[i][2];
                    int oth = cost[root1] == -1 ? ori : ori & cost[root1];

                    cost[root2] = oth;
                } else {
                    parent[root2] = root1;
                    parent[edges[i][1]] = root1;
                    size[root1]++;

                    int ori = cost[root1] == -1 ? edges[i][2] : cost[root1] & edges[i][2];
                    int oth = cost[root2] == -1 ? ori : ori & cost[root2];
                    cost[root1] = oth;
                }
            } else {
                cost[root2] = cost[root2] == -1 ? edges[i][2] : cost[root2] & edges[i][2];
            }
        }

//        System.out.println(Arrays.toString(parent));
//        System.out.println(Arrays.toString(cost));

        int[] ans = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            int sourceParent = query[i][0];
            int destinationParent = query[i][1];
            while (true) {
                if (parent[sourceParent] == sourceParent) {
                    break;
                } else {
                    sourceParent = parent[sourceParent];
                }
            }

            while (true) {
                if (parent[destinationParent] == destinationParent) {
                    break;
                } else {
                    destinationParent = parent[destinationParent];
                }
            }
            if (sourceParent == destinationParent) {
                ans[i] = cost[sourceParent];
            } else {
                ans[i] = -1;
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
