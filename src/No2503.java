import java.util.*;
import java.util.stream.Collectors;

public class No2503 {

    public static void main(String[] args) {
        No2503 obj = new No2503();
        System.out.println(Arrays.toString(obj.maxPoints(new int[][]{{1, 2, 3}, {2, 5, 7}, {3, 5, 1}}, new int[]{5, 6, 2})));
    }

    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int[] maxPoints(int[][] grid, int[] queries) {
        boolean[][] visit = new boolean[grid.length][grid[0].length];
        PriorityQueue<Model> unproceed = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));

        Map<Integer, Integer> que = new HashMap<>();
        for (int i = 0; i < queries.length; i++) {
            que.put(i, queries[i]);
        }

        que = que.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));

        unproceed.add(new Model(grid[0][0], 0, 0));
        int[] ans = new int[queries.length];
        int cnt = 0;
        for (Map.Entry<Integer, Integer> entry : que.entrySet()) {
            int index = entry.getKey();
            int val = entry.getValue();

            while (!unproceed.isEmpty()) {
                Model m = unproceed.peek();
                if (m.val >= val) {
                    break;
                }
                unproceed.poll();
                cnt++;
                visit[m.i][m.j] = true;

                for (int i = 0; i < dirs.length; i++) {
                    int newI = m.i + dirs[i][0];
                    int newJ = m.j + dirs[i][1];

                    if (newI >= 0 && newI < grid.length && newJ >= 0 && newJ < grid[0].length) {
                        if (!visit[newI][newJ]) {
                            unproceed.add(new Model(grid[newI][newJ], newI, newJ));
                            visit[newI][newJ] = true;
                        }
                    }
                }
            }
            ans[index] = cnt;
        }


        return ans;
    }

    class Model {
        int val;
        int i;
        int j;

        public Model(int val, int i, int j) {
            this.val = val;
            this.i = i;
            this.j = j;
        }
    }
}
