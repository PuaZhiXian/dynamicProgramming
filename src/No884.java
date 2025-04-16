import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class No884 {
    public static void main(String[] args) {
        No884 obj = new No884();

    }

    public String[] uncommonFromSentences(String s1, String s2) {
        String[] ss1 = s1.split(" ");
        String[] ss2 = s2.split(" ");

        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        Set<String> dis1 = new HashSet<>();
        Set<String> dis2 = new HashSet<>();
        Set<String> dup1 = new HashSet<>();
        Set<String> dup2 = new HashSet<>();

        for (String s : ss1) {
            map1.put(s, map1.getOrDefault(s, 0) + 1);
            if (!dup1.contains(s)) {
                if (dis1.contains(s)) {
                    dup1.add(s);
                    dis1.remove(s);
                } else {
                    dis1.add(s);
                }
            }
        }
        for (String s : ss2) {
            map2.put(s, map2.getOrDefault(s, 0) + 1);
            if (!dup2.contains(s)) {
                if (dis2.contains(s)) {
                    dup2.add(s);
                    dis2.remove(s);
                } else {
                    dis2.add(s);
                }
            }
        }

        Set<String> set = new HashSet<>();
        for (String s : dis1) {
            if (map2.getOrDefault(s, 0) == 0) {
                set.add(s);
            }
        }
        for (String s : dis2) {
            if (map1.getOrDefault(s, 0) == 0) {
                set.add(s);
            }
        }
        String[] ans = new String[set.size()];
        int index = 0;
        for (String s : set) {
            ans[index] = s;
            index++;
        }
        return ans;
    }
}
