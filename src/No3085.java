import java.util.HashMap;
import java.util.Map;

public class No3085 {
    public static void main(String[] args) {
        No3085 o = new No3085();
        System.out.println(o.minimumDeletions("aabcaba", 0));
    }

    public int minimumDeletions(String word, int k) {
        char[] chars = word.toCharArray();
        int l = chars.length;
        Map<Character, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for (char c : chars) {
            Integer temp = map.getOrDefault(c, 0);
            map.put(c, temp + 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int ans = 0;

            char c = entry.getKey();
            int i = entry.getValue();
            for (Map.Entry<Character, Integer> loop : map.entrySet()) {
                if (loop.getKey() == c) {
                    continue;
                }

                if (loop.getValue() < i) {
                    ans += loop.getValue();
                } else if (loop.getValue() > i + k) {
                    ans += (loop.getValue() - i - k);
                }
            }

            min = Math.min(min, ans);
        }
        return min;
    }
}
