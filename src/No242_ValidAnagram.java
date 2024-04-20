/**
 * *https://leetcode.com/problems/valid-anagram/description/
 **/
public class No242_ValidAnagram {

    public static void main(String[] args) {
        String s5 = "a";
        String t5 = "ab";
        System.out.println(No242_ValidAnagram.isAnagram(s5, t5));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] check = new int[26];
        for (int i = 0; i < t.length(); i++) {
            check[t.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            check[index]--;
            if (check[index] < 0) {
                return false;
            }
        }
        return true;
    }
}
