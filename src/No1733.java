import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class No1733 {
    public static void main(String[] args) {
        No1733 o = new No1733();
        int[][] languages = new int[][]{{2}, {1, 3}, {1, 2}, {3}};
        int[][] friendships = new int[][]{{1, 4}, {1, 2}, {3, 4}, {2, 3}};
        System.out.println(o.minimumTeachings(3, languages, friendships));
    }

    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        Map<Integer, Set<Integer>> lan = new HashMap<>();

        for (int i = 0; i < languages.length; i++) {
            Set<Integer> set = new HashSet<>();
            for (int lans : languages[i]) {
                set.add(lans);
            }
            lan.put(i + 1, set);
        }

        Set<Integer> needTeach = new HashSet<>();
        for (int[] friend : friendships) {
            if (needTeach.contains(friend[0]) && needTeach.contains(friend[1])) {
                continue;
            }

            if (lan.get(friend[0]).stream().anyMatch(lan.get(friend[1])::contains)) {
                continue;
            }

            needTeach.add(friend[0]);
            needTeach.add(friend[1]);
        }


        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            for (Integer ppl : needTeach) {
                if (lan.get(ppl).contains(i)) {
                    continue;
                }
                cnt++;
            }

            min = Math.min(min, cnt);
        }


        return min;
    }
} 
