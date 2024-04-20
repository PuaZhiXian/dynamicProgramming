/**
 * https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/description/
 */
public class No1876_SubstringsofSizeThreewithDistinctCharacters {
    public static void main(String[] args) {
        No1876_SubstringsofSizeThreewithDistinctCharacters obj = new No1876_SubstringsofSizeThreewithDistinctCharacters();
        String text1 = "xyzzaz";//1
        String text2 = "aababcabc";//4

        System.out.println(obj.countGoodSubstrings(text1));
        System.out.println(obj.countGoodSubstrings(text2));
    }

    public int countGoodSubstrings(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length() - 2; i++) {
            if (s.charAt(i) != s.charAt(i + 1) &&
                    s.charAt(i) != s.charAt(i + 2) &&
                    s.charAt(i + 1) != s.charAt(i + 2)) {
                cnt++;
            }
        }
        return cnt;
    }
}
