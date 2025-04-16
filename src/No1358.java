public class No1358 {
    public static void main(String[] args) {
        No1358 obj = new No1358();

    }

    public int numberOfSubstrings(String s) {
        int ans = 0;
        int l = 0, r = 0;
        int[] vowel = new int[3];

        char[] chars = s.toCharArray();
        int len = chars.length;

        while (r < len) {
            vowel[chars[r] - 'a']++;
            while (helper(vowel)) {
                ans += (len - r);
                vowel[chars[l] - 'a']--;
                l++;
            }
            r++;
        }

        return ans;
    }

    public boolean helper(int[] vowel) {
        for (int j : vowel) {
            if (j == 0) {
                return false;
            }
        }
        return true;
    }
}
