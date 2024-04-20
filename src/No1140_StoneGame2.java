/**
 * https://leetcode.com/problems/stone-game-ii/
 */
public class No1140_StoneGame2 {

    public static void main(String[] args) {
        No1140_StoneGame2 obj = new No1140_StoneGame2();
        int[] arr1 = {1, 2, 3, 4, 5, 100};
        int[] arr2 = {2, 7, 9, 4, 4};
        int[] arr3 = {77, 12, 64, 35, 28, 4, 87, 21, 20};
        int[] arr4 = {3111, 4303, 2722, 2183, 6351, 5227, 8964, 7167, 9286, 6626, 2347, 1465, 5201, 7240, 5463, 8523, 8163, 9391, 8616, 5063, 7837, 7050, 1246, 9579, 7744, 6932, 7704, 9841, 6163, 4829, 7324, 6006, 4689, 8781, 621};
        int[] arr5 = {1};

        System.out.println(obj.stoneGameII(arr1));
        System.out.println(obj.stoneGameII(arr2));
        System.out.println(obj.stoneGameII(arr3));
        System.out.println(obj.stoneGameII(arr4));
        System.out.println(obj.stoneGameII(arr5));
    }

    int n = 0;

    public int stoneGameII(int[] piles) {
        n = piles.length;
        int[][] memoA = new int[n][n * 2];
        int[][] memoB = new int[n][n * 2];
        int[] suffix = new int[n];
        suffix[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }
        return helper(piles, 0, true, 1, memoA, memoB, suffix);
    }

    public int helper(int[] piles, int index, boolean aliceTurn, int M, int[][] memoA, int[][] memoB, int[] suffix) {
        if (aliceTurn) {
            if (memoA[index][M] != 0) {
                return memoA[index][M];
            }
        } else {
            if (memoB[index][M] != 0) {
                return memoB[index][M];
            }
        }
        if (index + (M * 2) >= piles.length) {
            if (aliceTurn) {
                return suffix[index];
            } else {
                return 0;
            }
        }

        if (index > piles.length - 1) {
            return 0;
        }
        int edge = 0;
        int sum = aliceTurn ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        int take = 0;

        for (int i = index; i < Math.min(index + (M * 2), piles.length); i++) {
            take++;
            edge += piles[i];
            if (aliceTurn) {
                sum = Math.max(edge + helper(piles, i + 1, false, Math.max(M, take), memoA, memoB, suffix), sum);
            } else {
                sum = Math.min(helper(piles, i + 1, true, Math.max(M, take), memoA, memoB, suffix), sum);
            }
        }
        if (aliceTurn) {
            memoA[index][M] = sum;
        } else {
            memoB[index][M] = sum;
        }
        return sum;
    }
}
