import java.util.HashMap;
import java.util.Map;

public class No2053 {
    public static void main(String[] args) {
        No2053 obj = new No2053();
        System.out.println(obj.kthDistinct(new String[]{"d", "b", "c", "b", "c", "a"}, 2));
    }

    public String kthDistinct(String[] arr, int k) {
        String ans = "";
        Map<String, Integer> map = new HashMap<>();
        for (String s : arr) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for (String s : arr) {
            if (map.get(s) == 1) {
                k--;
            }
            if (k == 0) {
                ans = s;
                break;
            }
        }
        return ans;
    }
}
