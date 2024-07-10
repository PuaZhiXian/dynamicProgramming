import java.util.*;

public class No1122_RelativeSortArray {
    public static void main(String[] args) {
        //2,2,2,1,4,3,3,9,6,7,19
        System.out.println(Arrays.toString(relativeSortArray(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{2, 1, 4, 3, 9, 6})));
//        22,28,8,6,17,44
        System.out.println(Arrays.toString(relativeSortArray(new int[]{28, 6, 22, 8, 44, 17}, new int[]{22, 28, 8, 6})));
    }


    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
            map.put(arr1[i], map.getOrDefault(arr1[i], 0) + 1);
        }
        int index = 0;
        for (int i = 0; i < arr2.length; i++) {
            Integer cnt = map.get(arr2[i]);
            for (int j = 0; j < cnt; j++) {
                result[index] = arr2[i];
                index++;
            }
            map.remove(arr2[i]);
        }
        Map<Integer, Integer> sortedMap = new TreeMap<>(Comparator.naturalOrder());
        sortedMap.putAll(map);

        for (Map.Entry<Integer, Integer> entry : sortedMap.entrySet()) {
            int cnt = entry.getValue();
            int val = entry.getKey();
            for (int i = 0; i < cnt; i++) {
                result[index] = val;
                index++;
            }
        }

        return result;
    }
}
