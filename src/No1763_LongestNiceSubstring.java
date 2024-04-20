import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-nice-substring/
 */
public class No1763_LongestNiceSubstring {
    public static void main(String[] args) {
        No1763_LongestNiceSubstring obj = new No1763_LongestNiceSubstring();
        System.out.println(obj.longestNiceSubstring("dDzeE"));
    }

    public String longestNiceSubstring(String str) {
        if (str.length() < 2) {
            return "";
        }
        Set<Character> set = new HashSet<>();
        char[] chars = str.toCharArray();
        for (char c : chars) {
            set.add(c);
        }

        for (int i = 0; i < str.length(); i++) {
            if (set.contains(Character.toLowerCase(str.charAt(i))) && set.contains(Character.toUpperCase(str.charAt(i))))
                continue;
            String forwardStr = longestNiceSubstring(str.substring(0, i));
            String backwardStr = longestNiceSubstring(str.substring(i + 1));
            return forwardStr.length() < backwardStr.length() ? backwardStr : forwardStr;
        }
        return str;
    }

}