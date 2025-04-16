import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.LinkedHashMap;

public class No3169 {
    public static void main(String[] args) {
        No3169 obj = new No3169();
//        System.out.println(obj.countDays(10, new int[][]{{5, 7}, {1, 3}, {9, 10}}));
        System.out.println(obj.countDays(33, new int[][]{{3, 9}, {7, 16}, {21, 23}, {22, 33}, {5, 13}, {10, 23}, {1, 15}}));
//        System.out.println(obj.countDays(5, new int[][]{{2, 4}, {1, 3}}));
    }

    public int countDays(int days, int[][] meetings) {
        int cnt = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < meetings.length; i++) {
            if (map.containsKey(meetings[i][0])) {
                if (meetings[i][1] > map.get(meetings[i][0])) {
                    map.put(meetings[i][0], meetings[i][1]);
                }
            } else {
                map.put(meetings[i][0], meetings[i][1]);
            }
        }

        map = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey()) // Sort by key (O(n log n))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,   // Explicit lambda to avoid "Non-static method" error
                        Map.Entry::getValue, // Explicit lambda
                        (e1, e2) -> e1,
                        LinkedHashMap::new // Maintain insertion order after sorting
                ));

        int e = 1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int start = entry.getKey();
            int end = entry.getValue();
            if (end >= e) {
                if (start > e) {
                    cnt = cnt + (start - e);
                }
                e = end + 1;
            }

        }
        cnt = cnt + (days + 1 - e);

        return cnt;
    }
}
