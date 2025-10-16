import java.util.*;

public class No869 {
    public static void main(String[] args) {
        No869 o = new No869();
        System.out.println(o.reorderedPowerOf2(10));

    }

    List<Map<Character, Integer>> store = new ArrayList<>();

    public boolean reorderedPowerOf2(int n) {
        if (n == 1) {
            return true;
        }
        int cur = 1;
        for (int i = 0; i < 29; i++) {
            Map<Character, Integer> map = new HashMap<>();
            cur *= 2;
            String s = cur + "";
            for (char c : s.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            store.add(map);
        }
        System.out.println(store);


        String temp = n + "";
        for (Map<Character, Integer> map : store) {
            if (temp(map, temp)) {
                return true;
            }
        }

        return false;
    }

    private boolean temp(Map<Character, Integer> map, String s) {
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    map.remove(c);
                }
            } else {
                return false;
            }
        }


        return map.isEmpty();
    }
}
