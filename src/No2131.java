import com.sun.xml.internal.ws.util.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class No2131 {
    public static void main(String[] args) {
        No2131 obj = new No2131();
        String[] arr = new String[]{"dd", "aa", "bb", "dd", "aa", "dd", "bb", "dd", "aa", "cc", "bb", "cc", "dd", "cc"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(obj.longestPalindrome(arr));
        /**
         * aa > 3 4
         * bb > 3 4
         * cc > 3 4
         * dd > 5 10
         */
    }

    public int longestPalindrome(String[] words) {
        int ans = 0;
        Map<String, Model> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].charAt(0) == words[i].charAt(1)) {
                Model m = map.getOrDefault(words[i], new Model());
                m.second++;
                m.first++;
                map.put(words[i], m);
            } else {
                if (words[i].charAt(0) > words[i].charAt(1)) {
                    Model m = map.getOrDefault("" + words[i].charAt(1) + words[i].charAt(0), new Model());
                    m.second++;
                    map.put("" + words[i].charAt(1) + words[i].charAt(0), m);
                } else {
                    Model m = map.getOrDefault(words[i], new Model());
                    m.first++;
                    map.put(words[i], m);
                }
            }
        }
        boolean foundOdd = false;

        for (Map.Entry<String, Model> entry : map.entrySet()) {
            String key = entry.getKey();
            Model m = entry.getValue();
            int min = Math.min(m.first, m.second);
            if (min == 0) {
                continue;
            }
            if (key.charAt(0) == key.charAt(1)) {
                min = m.first;
                if (min % 2 != 0) {
                    int even = min - 1;
                    ans += (even * 2);
                    if (!foundOdd) {
                        ans += 2;
                        foundOdd = true;
                    }
                } else {
                    ans += (min * 2);
                }
            } else {
                ans += (min * 4);
            }
        }
        return ans;
    }

    class Model {
        int first;
        int second;

        @Override
        public String toString() {
            return "first " + first + " : second" + second;
        }
    }
}
