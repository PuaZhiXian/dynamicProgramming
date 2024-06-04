import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class No78_Subsets {
    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 3}));
        System.out.println(subsets(new int[]{0}));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        Set<List<Integer>> temp = helper(nums, 0);
        List<List<Integer>> result = new ArrayList<>();
        result.addAll(temp);
        return result;
    }

    public static Set<List<Integer>> helper(int[] nums, int start) {
        if (start == nums.length - 1) {
            Set<List<Integer>> result = new HashSet<>();
            List<Integer> include = new ArrayList<>();
            include.add(nums[start]);
            result.add(include);
            result.add(new ArrayList<>());
            return result;
        }
        Set<List<Integer>> includeList = helper(nums, start + 1);
        Set<List<Integer>> excludeList = helper(nums, start + 1);

        Set<List<Integer>> result = new HashSet<>();
        for (List<Integer> temp : includeList) {
            temp.add(nums[start]);
            result.add(temp);
        }

        result.addAll(excludeList);
        return result;
    }
}
