public class No1317 {
    public static void main(String[] args) {
        No1317 o = new No1317();
    }

    public int[] getNoZeroIntegers(int n) {
        int[] ans = new int[2];
        int one = 1;

        while (true) {
            if (!String.valueOf(one).contains("0") && !String.valueOf(n - one).contains("0")) {
                break;
            }
            one++;
        }
        ans[0] = one;
        ans[1] = n - one;
        return ans;

    }
} 
