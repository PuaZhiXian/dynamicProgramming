public class No2311 {
    public static void main(String[] args) {
        No2311 o = new No2311();
//        System.out.println(o.longestSubsequence("1001010", 5));
        System.out.println(o.longestSubsequence("111100010000011101001110001111000000001011101111111110111000011111011000010101110100110110001111001001011001010011010000011111101001101000000101101001110110000111101011000101", 11713332));
    }

    public int longestSubsequence(String s, int k) {
//        System.out.println("len ; " + s.length());
        int ans = 0;
        char[] num = s.toCharArray();
        long cur = 0;
        int l = num.length - 1;
        for (int i = l; i >= 0; i--) {
            if (num[i] == '1') {
                if (cur > k) {
                    continue;
                }
                long temp = (long) Math.pow(2, l - i);
                cur += temp;

                if (cur <= k) {
                    ans++;
                }
            } else {
                ans++;
            }

        }

        return ans;
    }
}
