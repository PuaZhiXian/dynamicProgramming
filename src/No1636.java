import java.util.*;

public class No1636 {
    public static void main(String[] args) {
        No1636 obj = new No1636();
        System.out.println(Arrays.toString(obj.frequencySort(new int[]{-1, 1, -6, 4, 5, -6, 1, 4, 1})));
        //5,-1,4,4,-6,-6,1,1,1
    }

    public int[] frequencySort(int[] nums) {
        int[] ans = new int[nums.length];
        TreeMap<Integer, Set<Integer>> cntMap = new TreeMap<>();
        Map<Integer, Integer> singleCnt = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (singleCnt.containsKey(nums[i])) {
                int prevCnt = singleCnt.get(nums[i]);

                Set<Integer> removeSet = cntMap.get(prevCnt);
                removeSet.remove(nums[i]);
                cntMap.put(prevCnt, removeSet);

                int newCnt = prevCnt + 1;

                singleCnt.put(nums[i], newCnt);

                Set<Integer> addSet = cntMap.getOrDefault(newCnt, new TreeSet<>(Comparator.reverseOrder()));
                addSet.add(nums[i]);
                cntMap.put(newCnt, addSet);
            } else {
                singleCnt.put(nums[i], 1);
                Set<Integer> set = cntMap.getOrDefault(1, new TreeSet<>(Comparator.reverseOrder()));
                set.add(nums[i]);
                cntMap.put(1, set);
            }
        }
        int index = 0;
        for (Map.Entry<Integer, Set<Integer>> entry : cntMap.entrySet()) {
            int cnt = entry.getKey();
            for (Integer i : entry.getValue()) {
                for (int j = 0; j < cnt; j++) {
                    ans[index] = i;
                    index++;
                }
            }
        }

        return ans;
    }
}
