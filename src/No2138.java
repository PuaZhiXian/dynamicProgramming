public class No2138 {
    public static void main(String[] args) {
        No2138 O = new No2138();

    }

    public String[] divideString(String s, int k, char fill) {
        String[] ans = new String[(int) Math.ceil((double) s.length() / k)];

        int index = 0;
        for (int i = 0; i < ans.length; i++) {
            ans[i] = s.substring(index, Math.min(s.length(), index + k));
            index += k;
        }

        int las = ans.length - 1;
        while (ans[las].length() < k) {
            ans[las] = ans[las] + fill;
        }

        return ans;
    }
}
