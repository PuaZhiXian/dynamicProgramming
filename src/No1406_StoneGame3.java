/**
 * https://leetcode.com/problems/stone-game-iii/
 */
public class No1406_StoneGame3 {
    public static void main(String[] args) {
        No1406_StoneGame3 obj = new No1406_StoneGame3();
        int[] arr1 = {1, 2, 3, 7};
        int[] arr2 = {1, 2, 3, -9};
        int[] arr3 = {1, 2, 3, 6};

        System.out.println(obj.stoneGameIII(arr1));
        System.out.println(obj.stoneGameIII(arr2));
        System.out.println(obj.stoneGameIII(arr3));
    }

    int[] prefixSum;
    int[][] memo;
    int n;

    public String stoneGameIII(int[] stoneValue) {
        n = stoneValue.length;
        memo = new int[n][2];
        prefixSum = new int[n];
        prefixSum[0] = stoneValue[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + stoneValue[i];
        }

/*        int result = helper(0, true);
        if (result == 0) {
            return "Tie";
        } else if (result > 0) {
            return "Alice";
        } else {
            return "Bob";
        }*/

        int result = bottomUpApproach();
        if (result == 0) {
            return "Tie";
        } else if (result > 0) {
            return "Alice";
        } else {
            return "Bob";
        }
    }

    public int getSum(int left, int right) {
        if (left == -1 || right == 0) {
            return prefixSum[right];
        } else {
            return prefixSum[right] - prefixSum[left];
        }
    }

    public int helper(int index, boolean isAliceTurn) {
        if (memo[index][isAliceTurn ? 0 : 1] != 0) {
            return memo[index][isAliceTurn ? 0 : 1];
        }
        int sum = Integer.MIN_VALUE;
        for (int i = index; i < Math.min(index + 3, n); i++) {
            if (i + 1 >= n) {
                sum = Math.max(sum, getSum(index - 1, i));
            } else {
                sum = Math.max(sum, getSum(index - 1, i) - helper(i + 1, !isAliceTurn));
            }
        }
        memo[index][isAliceTurn ? 0 : 1] = sum;
        return sum;
    }

    public int bottomUpApproach() {
        int[] m = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            int sum = Integer.MIN_VALUE;
            for (int j = i; j < Math.min(i + 3, n); j++) {
                int currentScore;
                if (j + 1 == n) {
                    currentScore = getSum(i - 1, j);
                } else {
                    currentScore = getSum(i - 1, j) - m[j + 1];
                }
                sum = Math.max(sum, currentScore);
            }
            m[i] = sum;
        }
        return m[0];
    }
}
