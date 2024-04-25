/**
 * https://leetcode.com/problems/longest-ideal-subsequence/
 */
public class No2370_LongestIdealSubsequence {

    public static void main(String[] args) {
        System.out.println(longestIdealString("acfgbd", 2));
        System.out.println(longestIdealString("abcd", 3));
    }

    public static int longestIdealString(String s, int k) {
        int[] cnt = new int[26];
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            int max = cnt[index];
            //back cnt
            int backIndex = index - k;
            while (backIndex != index) {
                if (backIndex >= 0) {
                    max = Math.max(cnt[backIndex], max);
                }
                backIndex++;
            }
            //front cnt
            int frontIndex = index + k;
            while (frontIndex != index) {
                if (frontIndex < 26) {
                    max = Math.max(cnt[frontIndex], max);
                }
                frontIndex--;
            }
            cnt[index] = max + 1;
            result = Math.max(cnt[index], result);
        }
        return result;
    }
}
