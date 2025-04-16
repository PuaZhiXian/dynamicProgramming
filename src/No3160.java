import java.util.*;

public class No3160 {

    public static void main(String[] args) {
        No3160 obj = new No3160();

        System.out.println(Arrays.toString(obj.queryResults(4, new int[][]{{0, 1}, {1, 2}, {2, 2}, {3, 4}, {4, 5}})));
    }

    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Integer> ball = new HashMap<>();
        Map<Integer, Integer> color = new HashMap<>();

        int[] ans = new int[queries.length];
        int cnt = 0;
        for (int i = 0; i < queries.length; i++) {
            if (ball.containsKey(queries[i][0])) {
                int oldColor = ball.get(queries[i][0]);

                int newCnt = color.get(oldColor) - 1;
                if (newCnt == 0) {
                    color.remove(oldColor);
                    cnt--;
                } else {
                    color.put(oldColor, newCnt);
                }
            }

            ball.put(queries[i][0], queries[i][1]);//update to new color

            color.put(queries[i][1], color.getOrDefault(queries[i][1], 0) + 1);
            if (color.get(queries[i][1]) == 1) {
                cnt++;
            }
            ans[i] = cnt;
        }
        return ans;
    }
}
