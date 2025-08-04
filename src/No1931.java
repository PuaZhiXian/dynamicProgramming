import javafx.util.Pair;

import java.util.*;

public class No1931 {

    public static void main(String[] args) {
        No1931 obj = new No1931();
        System.out.println(obj.colorTheGrid(1, 1));
    }

    int MOD = (int) (1e9 + 7);
    int rowNum;

    public int colorTheGrid(int m, int n) {
        rowNum = m;
        int maxStateCnt = (int) Math.pow(3, m);
        int[] dp = new int[maxStateCnt];
        Map<Integer, List<Integer>> validCombination = new HashMap<>();

        for (int i = 0; i < maxStateCnt; i++) {
            if (validState(i)) {
                validCombination.put(i, new ArrayList<>());
                dp[i] = 1;
            }
        }

        for (int i : validCombination.keySet()) {
            List<Integer> arr = validCombination.get(i);
            for (int j : validCombination.keySet()) {
                if (validMove(i, j)) {
                    arr.add(j);
                }
            }
            validCombination.put(i, arr);
        }
//        System.out.println(validCombination);

        for (int i = 1; i < n; i++) {
            int[] next = new int[maxStateCnt];
            for (Map.Entry<Integer, List<Integer>> entry : validCombination.entrySet()) {
                List<Integer> vaidMove = entry.getValue();
                int index = entry.getKey();

                for (Integer j : vaidMove) {
                    next[index] = (next[index] + dp[j]) % MOD;
                }
            }

            dp = next;
        }

        int ans = 0;
        for (int j : dp) {
            ans = (ans + j) % MOD;
        }


        return ans;
    }

    private boolean validState(int state) {
        int lastColor = -1;
        for (int i = 0; i < rowNum; ++i) {
            int currentColor = state % 3;
            if (currentColor == lastColor) {
                return false;
            }
            lastColor = currentColor;
            state /= 3;
        }
        return true;
    }

    private boolean validMove(int state1, int state2) {
        for (int i = 0; i < rowNum; ++i) {
            if (state1 % 3 == state2 % 3) {
                return false;
            }
            state1 /= 3;
            state2 /= 3;
        }
        return true;
    }

}
