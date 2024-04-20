import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
 */
public class No438_FindAllAnagramsinaString {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";

        String s2 = "abab";
        String p2 = "ab";

        String s3 = "abaacbabc";
        String p3 = "abc";

        String s4 = "abcabccbbaa";
        String p4 = "aabbcc";

        System.out.println(No438_FindAllAnagramsinaString.findAnagrams(s, p)); //[0,6]
        System.out.println(No438_FindAllAnagramsinaString.findAnagrams(s2, p2)); //[0, 1, 2]
        System.out.println(No438_FindAllAnagramsinaString.findAnagrams(s3, p3)); //[3,4,6]
        System.out.println(No438_FindAllAnagramsinaString.findAnagrams(s4, p4)); //[0,5]
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int[] check = new int[26];
        for (int i = 0; i < p.length(); i++) {
            check[p.charAt(i) - 'a']++;
        }

        int start = 0;
        int end = 0;
        while (end < s.length()) {
            if (check[s.charAt(end) - 'a'] == 0) {
                if (start == end) {
                    end++;
                    if (check[s.charAt(start) - 'a'] == 0) {
                        start++;
                    }
                } else {
                    check[s.charAt(start) - 'a']++;
                    start++;
                }
            } else {
                check[s.charAt(end) - 'a']--;
                if (end - start == p.length() - 1) {
                    result.add(start);
                }
                end++;
            }
        }
        return result;
    }
}
