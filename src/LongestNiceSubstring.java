import java.util.HashSet;
import java.util.Set;

public class LongestNiceSubstring {
    public static void main(String[] args) {
        LongestNiceSubstring obj = new LongestNiceSubstring();
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