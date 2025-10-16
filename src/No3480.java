import java.io.IOException;
import java.util.*;

public class No3480 {
    public static void main(String[] args) throws IOException {
        No3480 o = new No3480();
        int[][] cp = new int[][]{{2, 3}, {1, 4}};
        System.out.println(o.maxSubarrays(4, cp));
    }

    /**
     * each conficting pair is a barrier
     * eg
     * 1, 2, 3, 4
     * Y      <- contributing 1
     * YY     <- contributing 2
     * _XY    <- contributing 1
     * XXYY   <- contributing 2
     *
     * X >> barrier
     * Y >> acceptable
     * _ >> ignored
     *
     * assuming remove 0 barrier
     *
     * then removing single barrier from conflictingPair option
     * will removed barrier and reopen option hidden behind
     */
    public long maxSubarrays(int n, int[][] conflictingPairs) {
        Map<Integer, int[]> unClassifyBarrier = new HashMap<>();
        for (int i = 0; i < conflictingPairs.length; i++) {
            int min = Math.min(conflictingPairs[i][1], conflictingPairs[i][0]);
            int max = Math.max(conflictingPairs[i][1], conflictingPairs[i][0]);
            conflictingPairs[i][0] = min;
            conflictingPairs[i][1] = max;

            int[] barriers = unClassifyBarrier.getOrDefault(max, new int[]{0, 0});
            barriers = getTilSecondBig(barriers[0], barriers[1], min, -1);
            unClassifyBarrier.put(max, barriers);
        }

        Map<Integer, int[]> real = new HashMap<>();
        Set<Integer> removableBarrier = new TreeSet<>();
        Map<Integer, Set<Integer>> affectedIfBarrierRemoveMap = new HashMap<>();
        long sumWithoutRemove = 0;
        for (int i = 0; i < n; i++) {
            int[] curBarrier = real.getOrDefault(i - 1, new int[]{0, 0});
            if (unClassifyBarrier.containsKey(i + 1)) {
                curBarrier = getTilSecondBig(curBarrier[0], curBarrier[1], unClassifyBarrier.get(i + 1)[0], unClassifyBarrier.get(i + 1)[1]);
            }
            real.put(i, curBarrier);
            removableBarrier.add(curBarrier[0]);
            sumWithoutRemove += (i + 1 - curBarrier[0]);

            Set<Integer> affectedIfBarrierRemove = affectedIfBarrierRemoveMap.getOrDefault(curBarrier[0], new HashSet<>());
            affectedIfBarrierRemove.add(i);
            affectedIfBarrierRemoveMap.put(curBarrier[0], affectedIfBarrierRemove);
        }

        long ans = 0;
        for (int removingBarrier : removableBarrier) {
            long tempSum = sumWithoutRemove;

            for (int affectedRow : affectedIfBarrierRemoveMap.getOrDefault(removingBarrier, new HashSet<>())) {
                int[] barrier = real.get(affectedRow);
                tempSum += (barrier[0] - barrier[1]);
            }
            ans = Math.max(ans, tempSum);
        }
        return ans;
    }

    private int[] getTilSecondBig(int a, int b, int c, int d) {
        int[] ans = new int[]{a, b, c, d};
        Arrays.sort(ans);
        return new int[]{ans[3], ans[2]};
    }
}
