import java.util.*;

public class No1331 {
    public static void main(String[] args) {
        No1331 obj = new No1331();
        System.out.println(Arrays.toString(obj.arrayRankTransform(new int[]{37, 12, 28, 9, 100, 56, 80, 5, 12})));
    }

    public int[] arrayRankTransform(int[] arr) {
        PriorityQueue<Integer> p = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        for (int n : arr) {
            if (!set.contains(n)) {
                p.add(n);
                set.add(n);
            }
        }

        Map<Integer, Integer> map = new HashMap<>();
        int index = 1;
        while (!p.isEmpty()) {
            map.put(p.poll(), index);
            index++;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }

        return arr;
    }
}
