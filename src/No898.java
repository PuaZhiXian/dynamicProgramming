import javafx.util.Pair;

import java.time.chrono.MinguoDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class No898 {

    public static void main(String[] args) {
        No898 o = new No898();
        System.out.println(o.subarrayBitwiseORs(new int[]{1, 1, 2}));
    }

    Set<Integer> set = new HashSet<>();
    Set<Pair<Integer, Integer>> found = new HashSet();
    int[] arr;

    public int subarrayBitwiseORs(int[] arr) {
        this.arr = arr;
        for (int i = 0; i < arr.length; i++) {
            rec(i, 0);
        }
        return set.size();
    }

    public void rec(int index, int cur) {
        Pair<Integer, Integer> key = new Pair<>(index, cur);
        if (found.contains(key)) {
            return;
        }
        if (index == arr.length) {
            return;
        }
        found.add(key);

        set.add(cur | arr[index]);
        rec(index + 1, cur | arr[index]);
    }


}
