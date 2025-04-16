public class No2220 {
    public static void main(String[] args) {
        No2220 obj = new No2220();

        System.out.println(1 ^ 3);
    }

    public int minBitFlips(int start, int goal) {
        int num = start ^ goal;
        int ans = 0;
        char[] c = Integer.toBinaryString(num).toCharArray();
        for (char ch : c) {
            ans += (ch - '0');
        }

        return ans;
    }
}
