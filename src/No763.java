import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class No763 {
    public static void main(String[] args) {
        No763 obj = new No763();
        System.out.println(obj.partitionLabels("ababcbacadefegdehijhklij"));
    }

    public List<Integer> partitionLabels(String s) {
        List<Integer> list = new ArrayList<>();
        int[] last = new int[26];
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            last[chars[i] - 'a'] = i;
        }

        int end = 0;
        int cnt = 0;
        for (int i = 0; i < chars.length; i++) {
            if (i <= end) {
                cnt++;
            } else {
                list.add(cnt);
                cnt = 1;
            }
            end = Math.max(end, last[chars[i] - 'a']);
        }

        if (cnt != 0) {
            list.add(cnt);
        }

        return list;
    }
}
