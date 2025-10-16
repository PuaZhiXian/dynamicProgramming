import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No38 {
    public static void main(String[] args) {
        No38 obj = new No38();
        System.out.println(obj.countAndSay(2));//1211
    }

    public String countAndSay(int n) {
        String ans = "1";
        for (int i = 1; i < n; i++) {
            ans = ltToStr(strToList(ans));
        }
        return ans;
    }

    private List<int[]> strToList(String str) {
        List<int[]> lt = new ArrayList<>();

        int prev = str.charAt(0);
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (prev == str.charAt(i)) {
                cnt++;
            } else {
                lt.add(new int[]{prev - 48, cnt});
                prev = str.charAt(i);
                cnt = 1;
            }
        }
        lt.add(new int[]{prev - 48, cnt});
        return lt;
    }

    private String ltToStr(List<int[]> lt) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lt.size(); i++) {
            int[] temp = lt.get(i);
            sb.append(temp[1]).append(temp[0]);
        }
        return sb.toString();
    }

}
