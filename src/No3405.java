public class No3405 {
    public static void main(String[] args) {
        No3405 o = new No3405();
//        System.out.println(o.countGoodArrays(4, 2, 2));
//        System.out.println(o.countGoodArrays(3, 2, 1));
        System.out.println(o.countGoodArrays(5581, 58624, 4766));

//        int n = 5;
//        int r = 2;
//        System.out.println(nCr(n, r));

    }

    private static final int MOD = (int) 1e9 + 7;
    static final int MX = 100000;
    static long[] fact = new long[MX];
    static long[] invFact = new long[MX];

    static long qpow(long x, int n) {
        long res = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                res = (res * x) % MOD;
            }
            x = (x * x) % MOD;
            n >>= 1;
        }
        return res;
    }

    static {
        fact[0] = 1;
        for (int i = 1; i < MX; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }
        invFact[MX - 1] = qpow(fact[MX - 1], MOD - 2);
        for (int i = MX - 1; i > 0; i--) {
            invFact[i - 1] = (invFact[i] * i) % MOD;
        }
    }

    private int binaryExp(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = (res * a) % MOD;
            }
            a = (a * a) % MOD;
            b >>= 1;
        }
        return (int) res;
    }

    public int countGoodArrays(int n, int m, int k) {
        long possibleSplit = (fact[n - 1] * invFact[n - k - 1] % MOD * invFact[k]) % MOD;
        long possibleNum = ((long) m * qpow(m - 1, n - k - 1) % MOD);

//        System.out.println(possibleSplit);
//        System.out.println(possibleNum);

        return (int) (possibleSplit * possibleNum % MOD);
    }
}
