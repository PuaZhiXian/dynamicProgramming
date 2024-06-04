import java.util.HashMap;
import java.util.Map;

public class No409_LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd"));//7
        System.out.println(longestPalindrome("abcccrrrcdd"));//9
        System.out.println(longestPalindrome("a"));//1
    }

    public static int longestPalindrome(String s) {
        int result = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Integer cnt = map.getOrDefault(s.charAt(i) + "", 0);
            map.put(s.charAt(i) + "", cnt + 1);
        }
        for (Integer cnt : map.values()) {
            if (cnt > 1) {
                result = result + (cnt / 2) * 2;
            }
        }
        return s.length() > result ? result + 1 : result;
    }
}