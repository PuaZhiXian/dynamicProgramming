import java.util.Arrays;

public class No3016 {
    public static void main(String[] args) {
        No3016 obj = new No3016();

        System.out.println(obj.minimumPushes("aabbccddeeffgghhiiiiii"));
    }

    public int minimumPushes(String word) {
        int ans = 0;
        int[] cnt = new int[26];
        char[] c = word.toCharArray();
        for (char value : c) {
            cnt[value - 'a']++;
        }
        Arrays.sort(cnt);

        int index = 0;
        for (int i = cnt.length - 1; i >= 0; i--) {
            if (cnt[i] == 0) {
                break;
            }
            index++;
            ans += (int) Math.ceil(index / 8.0) * cnt[i];
        }

        return ans;
    }
}
