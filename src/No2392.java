import java.util.*;

public class No2392 {
    public static void main(String[] args) {
        No2392 obj = new No2392();
//        System.out.println(Arrays.deepToString(obj.buildMatrix(
//                3,
//                new int[][]{{1, 2}, {3, 2}},
//                new int[][]{{2, 1}, {3, 2}}
//        )));

        System.out.println(Arrays.deepToString(obj.buildMatrix(
                8,
                new int[][]{{1, 2}, {7, 3}, {4, 3}, {5, 8}, {7, 8}, {8, 2}, {5, 8}, {3, 2}, {1, 3}, {7, 6}, {4, 3}, {7, 4}, {4, 8}, {7, 3}, {7, 5}},
                new int[][]{{5, 7}, {2, 7}, {4, 3}, {6, 7}, {4, 3}, {2, 3}, {6, 2}}
        )));


    }


    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[][] result = new int[k][k];
        List<Integer> row = topologicalSort(rowConditions, k);
        List<Integer> col = topologicalSort(colConditions, k);

        if (row.size() < k || col.size() < k) {
            return new int[0][0];
        }
        Map<Integer, Integer> rowMap = new HashMap<>();
        for (int i = 0; i < row.size(); i++) {
            rowMap.put(row.get(i), i);
        }

        for (int i = 0; i < col.size(); i++) {
            Integer n = rowMap.get(col.get(i));
            if (n == null) {
                return new int[0][0];
            }
            result[n][i] = col.get(i);
        }
        return result;
    }

    public List<Integer> topologicalSort(int[][] condition, int k) {
        List<Integer> order = new ArrayList<>();
        List<List<Integer>> connection = new ArrayList<>();
        int[] degree = new int[k];
        for (int i = 0; i < k; i++) {
            connection.add(new ArrayList<>());
        }

        for (int[] ints : condition) {
            connection.get(ints[0] - 1).add(ints[1] - 1);
            degree[ints[1] - 1]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            if (degree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int needInsert = queue.poll();
            order.add(needInsert + 1);
            for (int linked : connection.get(needInsert)) {
                degree[linked]--;
                if (degree[linked] == 0) {
                    queue.add(linked);
                }
            }
        }
        return order;
    }
}
