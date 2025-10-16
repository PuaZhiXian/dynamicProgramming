import javafx.util.Pair;
import sun.rmi.runtime.Log;

import java.util.*;

public class No3186 {
    public static void main(String[] args) {
        No3186 o = new No3186();
        System.out.println(o.maximumTotalDamage(new int[]{4, 3, 1, 1}));
    }


    public long maximumTotalDamage(int[] power) {
        Map<Integer, Long> map = new TreeMap<>();
        for (int p : power) {
            map.put(p, map.getOrDefault(p, 0L) + p);
        }

        List<long[]> list = new ArrayList<>();
        list.add(new long[]{-1000000000L, 0L});
        long ans = 0;
        for (Map.Entry<Integer, Long> entry : map.entrySet()) {
            list.add(new long[]{entry.getKey(), entry.getValue()});
        }

        int n = list.size();
        long[] dp = new long[n];
        long max = 0;
        int j = 1;

        for (int i = 1; i < n; i++) {
            while (j < i && list.get(j)[0] < list.get(i)[0] - 2) {
                max = Math.max(max, dp[j]);
                j++;
            }
            dp[i] = max + map.get((int) list.get(i)[0]);
            ans = Math.max(ans, dp[i]);
        }


        return ans;
    }

} 
