import java.util.Arrays;
import java.util.List;

public class No1415 {


    public static void main(String[] args) {
        No1415 obj = new No1415();
        System.out.println(obj.getHappyString(3, 9));

    }
    private List<Character> list = Arrays.asList('a', 'b', 'c');
    private int k = 0;
    private String ans = "";
    public String getHappyString(int n, int k) {
        this.k = k;
        helper(n, "");
        return ans;
    }

    public void helper(int n, String prefix) {
        if (k == 0) {
            return;
        }
        if (prefix.length() == n) {
            k--;
            if (k == 0) {
                ans = prefix;
            }
        } else {
            Character last = prefix.isEmpty() ? null : prefix.charAt(prefix.length() - 1);
            for (int i = 0; i < list.size(); i++) {
                if (last != list.get(i)) {
                    helper(n, prefix + list.get(i));
                    if (k == 0) {
                        return;
                    }
                }
            }
        }
    }
}
