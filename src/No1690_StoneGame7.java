/**
 * https://leetcode.com/problems/stone-game-vii/
 */
public class No1690_StoneGame7 {

    public static void main(String[] args) {
        No1690_StoneGame7 obj = new No1690_StoneGame7();
        int[] arr1 = {5, 3, 1, 4, 2};
        int[] arr2 = {7, 90, 5, 1, 100, 10, 10, 2};
        System.out.println(obj.stoneGameVII(arr1));
        System.out.println(obj.stoneGameVII(arr2));

    }

    int n = 0;
    int[] prefixSum;

    public int stoneGameVII(int[] stones) {
        n = stones.length;
        prefixSum = new int[n];

        prefixSum[0] = stones[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + stones[i];
        }

        return bottomUpApproach();
    }

    /*
    * Bottom Up Approach
    * Both alice and bod want get more point to max and min the gap of point
    * Get value if remove left or remove right
    * from the value get max
    */
    public int bottomUpApproach() {
        int[][] memo = new int[n][n];

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                int currentScoreRemoveLeft = getSum(i, j) - memo[i + 1][j];
                int currentScoreRemoveRight = getSum(i - 1, j - 1) - memo[i][j - 1];
                memo[i][j] = Math.max(currentScoreRemoveLeft, currentScoreRemoveRight);
            }
        }
        return memo[0][n - 1];
    }


    public int getSum(int left, int right) {
        if (left == -1) {
            return prefixSum[right];
        } else {
            return prefixSum[right] - prefixSum[left];
        }
    }

    /*
    * Min Max Approach
    * if alice turn , add sum of stone element into sum
    * if Bod turn, minus sum of stone element from sum
    * When handling branch
    * alice turn will return value with max
    * bod turn will return value with min
    */
    public int helper(int left, int right, int sum, boolean aliceTurn, int[] prefixSum) {
        if (left == right) {
            return sum;
        }

        int result = aliceTurn ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        //Remove first left element
        int sumAfterRemoveLeft = prefixSum[right] - prefixSum[left];
        int sumAfterAddLeftElement = sum;
        if (aliceTurn) {
            sumAfterAddLeftElement += sumAfterRemoveLeft;
        } else {
            sumAfterAddLeftElement -= sumAfterRemoveLeft;
        }

        int ansFromLeft = helper(left + 1, right, sumAfterAddLeftElement, !aliceTurn, prefixSum);
        if (aliceTurn) {
            result = Math.max(ansFromLeft, result);
        } else {
            result = Math.min(ansFromLeft, result);
        }

        //remove first right element
        int sumAfterRemoveRight;
        if (left - 1 < 0) {
            sumAfterRemoveRight = prefixSum[right - 1];
        } else {
            sumAfterRemoveRight = prefixSum[right - 1] - prefixSum[left - 1];
        }
        int sumAfterAddRightElement = sum;
        if (aliceTurn) {
            sumAfterAddRightElement += sumAfterRemoveRight;
        } else {
            sumAfterAddRightElement -= sumAfterRemoveRight;
        }

        int ansFromRight = helper(left, right - 1, sumAfterAddRightElement, !aliceTurn, prefixSum);
        if (aliceTurn) {
            result = Math.max(ansFromRight, result);
        } else {
            result = Math.min(ansFromRight, result);
        }
        return result;
    }
}
