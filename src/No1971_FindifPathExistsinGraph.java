public class No1971_FindifPathExistsinGraph {

    public static void main(String[] args) {
        int n1 = 3;
        int[][] edges1 = {
                {0, 1},
                {1, 2},
                {2, 0}
        };
        int source1 = 0;
        int destination1 = 2;


        int n2 = 6;
        int[][] edges2 = {
                {0, 1},
                {0, 2},
                {3, 5},
                {5, 4},
                {4, 3}
        };
        int source2 = 0;
        int destination2 = 5;

        int n3 = 1;
        int[][] edges3 = {};
        int source3 = 0;
        int destination3 = 0;

        int n4 = 10;
        int[][] edges4 = {
                {4, 3},
                {1, 4},
                {4, 8},
                {1, 7},
                {6, 4},
                {4, 2},
                {7, 4},
                {4, 0},
                {0, 9},
                {5, 4}
        };
        int source4 = 5;
        int destination4 = 9;

        int n5 = 10;
        int[][] edges5 = {
                {2, 6},
                {4, 7},
                {1, 2},
                {3, 5},
                {7, 9},
                {6, 4},
                {9, 8},
                {0, 1},
                {3, 0}
        };
        int source5 = 3;
        int destination5 = 5;


        int n6 = 6;
        int[][] edges6 = {
                {0, 1},
                {2, 3},
                {4, 5},
                {3, 4},
                {1, 2}
        };
        int source6 = 0;
        int destination6 = 5;


        System.out.println(validPath(n1, edges1, source1, destination1));//true
        System.out.println(validPath(n2, edges2, source2, destination2));//false
        System.out.println(validPath(n3, edges3, source3, destination3));//true
        System.out.println(validPath(n4, edges4, source4, destination4));//true
        System.out.println(validPath(n5, edges5, source5, destination5));//true
        System.out.println(validPath(n6, edges6, source6, destination6));//true
    }

    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        int[] parent = new int[n];
        int[] size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int i = 0; i < edges.length; i++) {
            int root1 = parent[edges[i][0]];
            int root2 = parent[edges[i][1]];
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

        int sourceParent = source;
        int destinationParent = destination;
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
//        System.out.println(Arrays.toString(parent));
        return sourceParent == destinationParent;
    }
}
