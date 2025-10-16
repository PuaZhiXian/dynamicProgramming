public class No2014 {
    public static void main(String[] args) {
        No2014 o = new No2014();
//        System.out.println(o.longestSubsequenceRepeatedK("letsleetcode", 2));
//        System.out.println(o.longestSubsequenceRepeatedK("bwonderwonderwonderwonderwonderwonderwonderwonderb", 8));
        System.out.println(o.longestSubsequenceRepeatedK("pvszilhpsziolhpszilhpszivlhnpszilhpszilhpszilhkpszijlhpsztilhpszilhpszilyhpszilh", 12));
    }

    public String longestSubsequenceRepeatedK(String s, int k) {
        this.k = k;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            map[c - 'a']++;
        }


        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            if (map[c - 'a'] >= k) {
                sb.append(c);
            }
        }
        cleanStr = sb.toString();

        ori = map.clone();
        rec("");
        return max;
    }

    String max = "";
    int[] map = new int[26];
    int[] ori = new int[26];
    int k = 0;
    String cleanStr = "";

    public void rec(String prevStr) {
        if (prevStr.length() == 8) {
            return;
        }
        for (int i = 0; i < 26; i++) {
            char c = (char) (i + 'a');
            int cnt = map[i];
            if (ori[i] < k || ori[i] / k >= cnt) {
                continue;
            }
            map[i]--;

            if (validate(prevStr + c)) {
                max = largeThanMax(prevStr + c) ? prevStr + c : max;
                rec(prevStr + c);
            }
            map[i]++;
        }
    }

    public boolean largeThanMax(String string) {
        if (string.length() > max.length()) {
            return true;
        } else if (string.length() < max.length()) {
            return false;
        } else {
            return string.compareTo(max) >= 0;
        }
    }

    public boolean validate(String sub) {
        int cnt = 0;
        int j = 0;
        for (int i = 0; i < cleanStr.length(); i++) {
            if (cleanStr.charAt(i) == sub.charAt(j)) {
                j++;
                if (j == sub.length()) {
                    j = 0;
                    cnt++;
                }
            }
        }

        return cnt >= k;
    }
}
