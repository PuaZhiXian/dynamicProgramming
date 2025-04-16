import java.util.*;

public class No2780 {

    public static void main(String[] args) {
        No2780 obj = new No2780();
        System.out.println(obj.minimumIndex(Arrays.asList(2, 1, 3, 1, 1, 1, 7, 1, 2, 1)));

    }

    public int minimumIndex(List<Integer> nums) {
        int l = nums.size();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            int cnt = map.getOrDefault(nums.get(i), 0) + 1;
            map.put(nums.get(i), cnt);
        }

        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            int num = nums.get(i);
            int cnt = map2.getOrDefault(num, 0) + 1;
            int other = map.get(num) - cnt;
            if (cnt > (i + 1) / 2 && other > (l - (i + 1)) / 2) {
                return i;
            }
            map2.put(nums.get(i), cnt);
        }


        return -1;
    }
}
