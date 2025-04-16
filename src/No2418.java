import java.util.*;

public class No2418 {
    public static void main(String[] args) {
        No2418 obj = new No2418();

    }

    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < heights.length; i++) {
            map.put(heights[i], names[i]);
        }
        Arrays.sort(heights);
        String[] ans = new String[names.length];
        int index = names.length - 1;
        for (int i = 0; i < heights.length; i++) {
            ans[index] = map.get(heights[i]);
            index--;
        }
        return ans;
    }
}
