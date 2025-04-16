import java.util.Arrays;

public class No2028 {
    public static void main(String[] args) {
        No2028 obj = new No2028();
        System.out.println(Arrays.toString(obj.missingRolls(new int[]{3, 2, 4, 3}, 4, 2)));
    }

    public int[] missingRolls(int[] rolls, int mean, int n) {
        int mSum = 0;
        for (int temp : rolls) {
            mSum += temp;
        }

        int sum = mean * (rolls.length + n);
        int needed = sum - mSum;

        if (needed < n || needed > n * 6) {
            return new int[0];
        }

        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        needed = needed - n;

        int index = 0;
        while (needed > 0) {
            if (needed > 5) {
                ans[index] = 6;
                needed -= 5;
                index++;
            } else {
                ans[index] += needed;
                needed = 0;
            }
        }
        return ans;
    }
}
