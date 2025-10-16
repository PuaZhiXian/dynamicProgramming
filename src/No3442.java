import java.util.Map;

public class No3442 {
    public static void main(String[] args) {
        No3442 o = new No3442();
        System.out.println(o.maxDifference("aaaaabbc"));
    }

    public int maxDifference(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }

        int maxOdd = 0;
        int minEven = Integer.MAX_VALUE;

        for (int j : cnt) {
            if (j == 0) {
                continue;
            }
            if (j % 2 == 0) {
                minEven = Math.min(minEven, j);
            } else {
                maxOdd = Math.max(maxOdd, j);
            }
        }


        return maxOdd - minEven;
    }
}
