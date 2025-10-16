import javafx.util.Pair;

import java.util.*;

public class No2099 {
    public static void main(String[] args) {
        No2099 o = new No2099();
        System.out.println(Arrays.toString(o.maxSubsequence(new int[]{3, 4, 3, 3}, 2)));
    }

    public int[] maxSubsequence(int[] nums, int k) {
        int[] ans = new int[k];
        List<Pair<Integer, Integer>> lt = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            lt.add(new Pair<>(i, nums[i]));
        }

        lt.sort(Comparator.comparing(Pair::getValue));
        lt = lt.subList(lt.size() - k, lt.size());
        lt.sort(Comparator.comparing(Pair::getKey));
        for (int i = 0; i < lt.size(); i++) {
            ans[i] = lt.get(i).getValue();
        }

        return ans;
    }
}
