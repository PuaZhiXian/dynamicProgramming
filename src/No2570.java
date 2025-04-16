import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class No2570 {

    public static void main(String[] args) {
        No2570 obj = new No2570();
        System.out.println(Arrays.deepToString(obj.mergeArrays(new int[][]{{1, 2}, {2, 3}, {4, 5}}, new int[][]{{1, 4}, {3, 2}, {4, 1}})));
    }

    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int[] ints : nums1) {
            map.put(ints[0], map.getOrDefault(ints[0], 0) + ints[1]);
        }
        for (int[] ints : nums2) {
            map.put(ints[0], map.getOrDefault(ints[0], 0) + ints[1]);
        }

        System.out.println(map);
        int[][] ans = new int[map.size()][2];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ans[index] = new int[]{entry.getKey(), entry.getValue()};
            index++;
        }


        return ans;
    }
}
