import java.lang.reflect.Array;
import java.util.Arrays;

public class No3445 {
    public static void main(String[] args) {
        No3445 o = new No3445();
        System.out.println(o.maxDifference("12233", 4));
//        System.out.println(o.maxDifference("011222102121", 3));
    }

    int[][] prefixSum = new int[5][];
    int limit;

    public int maxDifference(String s, int k) {
        char[] chars = s.toCharArray();
        limit = k;
        prefixSum = new int[5][chars.length + 1];
        for (int i = 1; i < prefixSum[0].length; i++) {
            prefixSum[0][i] = prefixSum[0][i - 1] + (chars[i - 1] == '0' ? 1 : 0);
            prefixSum[1][i] = prefixSum[1][i - 1] + (chars[i - 1] == '1' ? 1 : 0);
            prefixSum[2][i] = prefixSum[2][i - 1] + (chars[i - 1] == '2' ? 1 : 0);
            prefixSum[3][i] = prefixSum[3][i - 1] + (chars[i - 1] == '3' ? 1 : 0);
            prefixSum[4][i] = prefixSum[4][i - 1] + (chars[i - 1] == '4' ? 1 : 0);
        }

        int max = Integer.MIN_VALUE;
//        for (int i = 0; i < prefixSum.length; i++) {
//            System.out.println(i + " >> " + Arrays.toString(prefixSum[i]));
//        }
//        max = Math.max(max, helper(2, 1));
//        max = Math.max(max, helper(1, 3));

        for (int i = 0; i <= 4; i++) {
            for (int j = 0; j <= 4; j++) {
                if (i == j)
                    continue;
                max = Math.max(max, helper(i, j));
            }
        }
        return max;
    }

    public int helper(int oddTarget, int evenTarget) {
        int[] minVal = new int[4];
        int[] minIndex = new int[4];
        Arrays.fill(minVal, Integer.MAX_VALUE);
        Arrays.fill(minIndex, -1);
        minVal[0] = 0;
        minIndex[0] = 0;
        int max = Integer.MIN_VALUE;

        int l = 1;
        for (int i = limit; i < prefixSum[0].length; i++) {
            int target = getVal(prefixSum[oddTarget][i], prefixSum[evenTarget][i]);
//            System.out.printf("reading index %s , with target : %s \n", i, target);
            if (minVal[target] != Integer.MAX_VALUE) {
                if (prefixSum[evenTarget][i] > prefixSum[evenTarget][minIndex[target]]) {
//                    System.out.println("comparing ");
                    int ans = (prefixSum[oddTarget][i] - prefixSum[evenTarget][i]) - minVal[target];
//                    System.out.printf("getting ans %s ~ %s - %s from %s\n", prefixSum[oddTarget][i], prefixSum[evenTarget][i], minVal[target], target);
//                    System.out.println("current max " + max);
                    max = Math.max(max, ans);
                }
            }
            int minTarget = getValForUpdate(prefixSum[oddTarget][l], prefixSum[evenTarget][l]);
//            System.out.println("updating min " + minTarget + " for l " + l);
            int diff = prefixSum[oddTarget][l] - prefixSum[evenTarget][l];
            if (diff < minVal[minTarget]) {
                minVal[minTarget] = diff;
                minIndex[minTarget] = l;
            }
            l++;
        }

        return max;
    }

    public int getVal(int num1, int num2) {
        int m1 = num1 % 2;
        int m2 = num2 % 2;
        if (m1 == 0 && m2 == 0) {
            return 2;
        } else if (m1 == 0 && m2 == 1) {
            return 3;
        } else if (m1 == 1 && m2 == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public int getValForUpdate(int num1, int num2) {
        int m1 = num1 % 2;
        int m2 = num2 % 2;
        if (m1 == 0 && m2 == 0) {
            return 0;
        } else if (m1 == 0 && m2 == 1) {
            return 1;
        } else if (m1 == 1 && m2 == 0) {
            return 2;
        } else {
            return 3;
        }
    }
}
