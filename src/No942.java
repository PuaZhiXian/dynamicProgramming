import java.util.Arrays;

public class No942 {
    public static void main(String[] args) {
        No942 obj = new No942();
        System.out.println(Arrays.toString(obj.diStringMatch("IDID")));
    }

    public int[] diStringMatch(String s) {
        int[] ans = new int[s.length() + 1];
        int min = 0;
        int max = s.length();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'D') {
                ans[i] = max;
                max--;
            } else {
                ans[i] = min;
                min++;
            }
        }

        ans[s.length()] = min;

        return ans;
    }
}
