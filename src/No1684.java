import java.util.Arrays;

public class No1684 {
    public static void main(String[] args) {
        No1684 obj = new No1684();
        System.out.println(obj.countConsistentStrings("ab", new String[]{"ad", "bd", "aaab", "baa", "badab"}));
    }


    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] allow = new boolean[26];
        for (char c : allowed.toCharArray()) {
            allow[c - 'a'] = true;
        }

        int ans = 0;
        for (String word : words) {
            if (helper(word, allow)) {
                ans++;
            }
        }
        return ans;
    }

    public boolean helper(String str, boolean[] a) {
        for (char c : str.toCharArray()) {
            if (!a[c - 'a']) {
                return false;
            }
        }
        return true;
    }
}
