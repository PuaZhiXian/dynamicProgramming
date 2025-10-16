import java.util.ArrayList;
import java.util.List;

public class No3333 {
    public static void main(String[] args) {
        No3333 o = new No3333();
    }

    private static final int MOD = (int) 1e9 + 7;

    public int possibleStringCount(String word, int k) {
        if (word.isEmpty()) {
            return 0;
        }

        List<Integer> lt = new ArrayList<>();
        int cnt = 1;
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) == word.charAt(i - 1)) {
                cnt++;
            } else {
                lt.add(cnt);
                cnt = 1;
            }
        }
        lt.add(cnt);

        long total = 1;
        for (int num : lt) {
            total = (total * num) % MOD;
        }

        if (k <= lt.size()) {
            return (int) total;
        }

        int[] dp = new int[k];
        dp[0] = 1;
        for (int i : lt) {
            int[] tempDp = new int[k];
            long sum = 0;
            for (int j = 0; j < k; j++) {
                if (j > 0) {
                    sum = (sum + dp[j - 1]) % MOD;
                }
                if (j > i) {
                    sum = (sum - dp[j - i - 1]) % MOD;
                }

                tempDp[j] = (int) sum;
            }
            dp = tempDp;
        }

        long invalid = 0;
        for (int i = lt.size(); i < k; i++) {
            invalid = (invalid + dp[i]) % MOD;
        }


        return (int) ((total - invalid + MOD) % MOD);
    }
}