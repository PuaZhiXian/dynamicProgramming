public class No2843 {
    public static void main(String[] args) {
        No2843 obj = new No2843();

    }

    public int countSymmetricIntegers(int low, int high) {
        int ans = 0;

        while (low <= high) {
            String s = String.valueOf(low);
            int l = s.length();
            if (l % 2 != 0) {
                low = (int) (1 + Math.pow(10, l));
            } else {
                int half = l / 2;
                int temp = 0;
                for (int i = 0; i < s.length(); i++) {
                    if (i < half) {
                        temp += s.charAt(i);
                    } else {
                        temp -= s.charAt(i);
                    }
                }
                if (temp == 0) {
                    ans++;
                }
                low++;
            }
        }

        return ans;
    }

}
