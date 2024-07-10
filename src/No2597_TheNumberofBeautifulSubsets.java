import java.util.*;

public class No2597_TheNumberofBeautifulSubsets {
    public static void main(String[] args) {
//        System.out.println(beautifulSubsets(new int[]{2, 4, 6}, 2));
//        System.out.println(beautifulSubsets(new int[]{1}, 1));
        System.out.println(beautifulSubsets(new int[]{1, 1, 2, 3}, 1));
//        System.out.println(beautifulSubsets(new int[]{1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000}, 1));
    }

    public static int beautifulSubsets(int[] nums, int k) {
        return helper3(nums, 0, k, new HashMap<>()) - 1;
    }

    public static List<List<Integer>> helper(int[] nums, int start, int k, Set<Integer> selected) {
        if (start == nums.length - 1) {
            List<List<Integer>> result = new ArrayList<>();
            List<Integer> include = new ArrayList<>();
            int left1 = nums[start] - k;
            int right1 = nums[start] + k;
            if (!selected.contains(left1) && !selected.contains(right1)) {
                include.add(nums[start]);
                result.add(include);
            }
            result.add(new ArrayList<>());
            return result;
        }

        List<List<Integer>> includeList = new ArrayList<>();
        Set<Integer> newSelected = new HashSet<>(selected);
        int left1 = nums[start] - k;
        int right1 = nums[start] + k;
        boolean include = false;
        if (!newSelected.contains(left1) && !newSelected.contains(right1)) {
            include = true;
            newSelected.add(nums[start]);
            includeList = helper(nums, start + 1, k, newSelected);
        }

        List<List<Integer>> excludeList = helper(nums, start + 1, k, selected);

        List<List<Integer>> result = new ArrayList<>();
        if (include) {
            for (List<Integer> temp : includeList) {
                temp.add(nums[start]);
                result.add(temp);
            }
        }

        result.addAll(excludeList);
        return result;
    }

    public static int helper2(int[] nums, int start, int k, Set<Integer> selected) {
        if (start == nums.length - 1) {
            int result = 0;
            int left1 = nums[start] - k;
            int right1 = nums[start] + k;
            if (!selected.contains(left1) && !selected.contains(right1)) {
                result++;
            }
            result++;
            return result;
        }

        int includeCnt = 0;
        Set<Integer> newSelected = new HashSet<>(selected);
        int left1 = nums[start] - k;
        int right1 = nums[start] + k;
        boolean include = false;
        if (!newSelected.contains(left1) && !newSelected.contains(right1)) {
            include = true;
            newSelected.add(nums[start]);
            includeCnt = helper2(nums, start + 1, k, newSelected);
        }

        int excludeCnt = helper2(nums, start + 1, k, selected);

        int result = 0;
        if (include) {
            result += includeCnt;
        }
        result += excludeCnt;
        return result;
    }

    public static int helper3(int[] nums, int start, int k, Map<Integer, Integer> selected) {
        if (start == nums.length - 1) {
            int result = 0;
            int left1 = nums[start] - k;
            int right1 = nums[start] + k;
            if (selected.getOrDefault(left1, 0) == 0 && selected.getOrDefault(right1, 0) == 0) {
                result++;
            }
            result++;
            return result;
        }

        int result = 0;

        int left1 = nums[start] - k;
        int right1 = nums[start] + k;
        if (selected.get(left1) == null && selected.get(right1) == null) {
            selected.put(nums[start], selected.getOrDefault(nums[start], 0) + 1);
            result += helper3(nums, start + 1, k, selected);
            selected.put(nums[start], selected.get(nums[start]) - 1);
        }
        int excludeCnt = helper3(nums, start + 1, k, selected);
        result += excludeCnt;
        return result;
    }

}