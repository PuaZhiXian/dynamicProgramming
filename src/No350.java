import java.util.*;

public class No350 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersect(new int[]{9, 4, 9, 8, 4}, new int[]{4, 9, 5})));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> cnt1 = new HashMap<>();
        Map<Integer, Integer> cnt2 = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            cnt1.put(nums1[i], cnt1.getOrDefault(nums1[i], 0) + 1);
        }
        for (int i = 0; i < nums2.length; i++) {
            cnt2.put(nums2[i], cnt2.getOrDefault(nums2[i], 0) + 1);
        }

        List<Integer> list = new ArrayList<>();
        if (cnt1.size() < cnt2.size()) {
            for (Map.Entry<Integer, Integer> entry : cnt1.entrySet()) {
                Integer key = entry.getKey();
                Integer val = entry.getValue();
                int min = Math.min(val, cnt2.getOrDefault(key, 0));
                for (int i = 0; i < min; i++) {
                    list.add(key);
                }
            }
        } else {
            for (Map.Entry<Integer, Integer> entry : cnt2.entrySet()) {
                Integer key = entry.getKey();
                Integer val = entry.getValue();
                int min = Math.min(val, cnt1.getOrDefault(key, 0));
                for (int i = 0; i < min; i++) {
                    list.add(key);
                }
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
