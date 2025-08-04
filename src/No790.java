import java.util.Arrays;

public class No790 {
    public static void main(String[] args) {
        No790 obj = new No790();
        System.out.println(obj.numTilings(30));
    }

    private static final int MOD = (int) 1e9 + 7;

    public int numTilings(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        int[] f = new int[n + 1];
        int[] t = new int[n + 1];

        f[0] = 0;
        f[1] = 1;
        f[2] = 2;

        t[0] = 0;
        t[1] = 0;
        t[2] = 1;

        for (int i = 3; i <= n; i++) {
            f[i] = (int) (((long) f[i - 1] + (long) f[i - 2] + (2L * t[i - 1]) % MOD) % MOD);
            t[i] = (int) (((long) t[i - 1] + (long) f[i - 2]) % MOD);
        }

//        System.out.println(Arrays.toString(f));
//        System.out.println(Arrays.toString(t));

        return f[n];
    }
}
