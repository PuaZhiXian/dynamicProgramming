import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No40 {

    public static void main(String[] args) {
        No40 obj = new No40();
//        System.out.println(obj.combinationSum2(new int[]{1, 1, 3}, 1));
        System.out.println(obj.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        helper(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }

    public void helper(int start, int[] arr, int target, List<List<Integer>> ans, List<Integer> cur) {
        if (target == 0) {
            ans.add(new ArrayList<>(cur));
        }

        for (int i = start; i < arr.length; i++) {
            if (i > start && arr[i] == arr[i - 1]) {
                continue;
            }

            if (arr[i] > target) {
                break;
            }

            cur.add(arr[i]);
            helper(i + 1, arr, target - arr[i], ans, cur);
            cur.remove(cur.size() - 1);

        }
    }
}
