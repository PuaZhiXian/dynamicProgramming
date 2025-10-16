import java.util.Arrays;

public class No3443 {
    public static void main(String[] args) {
        No3443 o = new No3443();
        System.out.println(o.maxDistance("EESNW", 1));
    }

    public int maxDistance(String s, int k) {
        char[] dir = s.toCharArray();
        int[] cnt = new int[4];
        int max = 0;

        for (int i = 0; i < dir.length; i++) {
            if (dir[i] == 'N') {
                cnt[0]++;
            } else if (dir[i] == 'E') {
                cnt[1]++;
            } else if (dir[i] == 'S') {
                cnt[2]++;
            } else {
                cnt[3]++;
            }

            int minDiff = Math.min(cnt[0], cnt[2]) + Math.min(cnt[1], cnt[3]);

            int possibleDis = 0;
            if (k >= minDiff) {
                possibleDis = i + 1;
            } else {
                int base = i + 1 - 2 * minDiff;
                possibleDis = base + 2 * k;
            }
            max = Math.max(max, possibleDis);
        }

        return max;
    }
}
