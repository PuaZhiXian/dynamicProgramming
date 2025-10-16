import java.util.Arrays;

public class No2338 {
    public static void main(String[] args) {
        No2338 obj = new No2338();
//        System.out.println(obj.idealArrays(2, 5));//10
//        System.out.println(obj.idealArrays(5, 3));//11
//        System.out.println(obj.idealArrays(184, 389));//510488787
        System.out.println(obj.idealArrays(5878, 2900));//465040898
//        System.out.println(obj.idealArrays(9767, 9557));//465040898
    }

    int[] arr = new int[15];
    int maxLevel;
    int max;
    long MOD = 10_000_000_07;

    public int idealArrays(int n, int maxValue) {
        long ans = 0;
        int[][] prefixSum = new int[15][n + 1];


        prefixSum[1][1] = 1;
        for (int j = 2; j < prefixSum[1].length; j++) {
            prefixSum[1][j] = 1;
        }

        for (int i = 2; i < prefixSum.length; i++) {
            for (int j = i; j < prefixSum[i].length; j++) {
//                prefixSum[i][j] = (prefixSum[i - 1][j - 1] + prefixSum[i][j - 1]) % MOD;
            }
        }

//        print(prefixSum);
        this.maxLevel = n;
        this.max = maxValue;

        for (int i = 1; i < maxValue + 1; i++) {
            recursion(i, 1);
        }

        for (int unique = 1; unique < prefixSum.length; unique++) {
            long count = (prefixSum[unique][n]) % MOD;
            long temp = arr[unique];
            if (temp == 0) {
                break;
            }
            long s = (count * temp) % MOD;
            ans = (s + ans) % MOD;
        }

        return (int) ans;
    }

    private void recursion(int val, int level) {
        if (level > maxLevel) {
            return;
        }
        if (val > max) {
            return;
        }
        arr[level]++;

        int index = 2;
        while (val * index <= max) {
            recursion(val * index, level + 1);
            index++;
        }
    }

    private void print(int[][] prefixSum) {
        for (int[] row : prefixSum) {
            System.out.println(Arrays.toString(row));
        }
    }
}
