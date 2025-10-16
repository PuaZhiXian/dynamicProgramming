import java.util.Arrays;

public class No2106 {
    public static void main(String[] args) {
        No2106 o = new No2106();
//        int[][] fruits = new int[][]{{0, 9}, {4, 1}, {5, 7}, {6, 2}, {7, 4}, {10, 9}};
        int[][] fruits = new int[][]{{0, 15}, {3, 56}, {4, 98}, {5, 81}, {7, 16}, {8, 77}, {9, 89}, {12, 82}, {13, 49}, {14, 59}, {17, 40}, {18, 83}, {19, 35}, {20, 31}, {21, 44}, {22, 92}, {25, 84}, {26, 42}, {29, 4}, {33, 78}, {35, 83}, {36, 3}, {37, 71}, {41, 24}, {44, 81}, {45, 35}, {46, 81}, {48, 81}, {50, 85}, {52, 32}, {53, 93}, {54, 89}, {55, 82}, {56, 60}, {59, 52}, {62, 79}, {63, 90}, {64, 41}, {66, 15}, {68, 43}, {69, 32}, {70, 51}, {71, 79}, {75, 39}, {76, 21}, {78, 16}, {79, 44}, {80, 73}, {81, 95}, {83, 95}, {85, 11}, {87, 80}, {88, 2}, {90, 89}, {99, 35}, {100, 95}};
        System.out.println(o.maxTotalFruits(fruits, 86, 107));//3102
    }

    //20_0001
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int ans = 0;
        int[] prefixSum = new int[20_00000];
        int index = 0;
        for (int i = 0; i < prefixSum.length; i++) {
            if (index < fruits.length && fruits[index][0] == i) {
                if (i == 0) {
                    prefixSum[i] = fruits[index][1];
                } else {
                    prefixSum[i] = prefixSum[i - 1] + fruits[index][1];
                }
                if (fruits[index][0] == startPos) {
                    ans = fruits[index][1];
                }
                index++;
            } else {
                if (i == 0) {
                    continue;
                }
                prefixSum[i] = prefixSum[i - 1];
            }
        }
        for (int i = 0; i < k; i++) {
            int nextleftIndex = startPos - i;
            if (nextleftIndex == -1) {
                break;
            }

            int total;
            if (nextleftIndex == 0) {
                total = prefixSum[startPos];
            } else {
                total = prefixSum[startPos] - prefixSum[nextleftIndex - 1];
            }

            int nextRightIndex = nextleftIndex + (k - i);
            if (nextRightIndex > startPos) {
                total += prefixSum[Math.min(prefixSum.length - 1, nextRightIndex)] - prefixSum[startPos];
            }
            ans = Math.max(total, ans);
        }
        for (int i = 0; i < k; i++) {
            int nextRightIndex = startPos + i;
            if (nextRightIndex >= prefixSum.length) {
                break;
            }

            int total = prefixSum[nextRightIndex] - prefixSum[startPos];
            int nextLeftIndex = nextRightIndex - (k - i);
            if (nextLeftIndex < startPos) {
                if (nextLeftIndex <= 0) {
                    total += prefixSum[startPos];
                } else {
                    total += prefixSum[startPos] - prefixSum[nextLeftIndex - 1];
                }
            }
            ans = Math.max(ans, total);
        }
        return ans;
    }
}
