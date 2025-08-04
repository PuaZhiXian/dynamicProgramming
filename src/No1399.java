import java.util.Arrays;

public class No1399 {
    public static void main(String[] args) {
        No1399 obj = new No1399();
        System.out.println(obj.countLargestGroup(2));
    }

    public int countLargestGroup(int n) {
        int ans = 0;
        int[] cnt = new int[37];

        for (int i = 1; i <= n; i++) {
            cnt[sum(i)]++;
        }
        System.out.println(Arrays.toString(cnt));

        int maxCnt = 0;
        int max = 0;
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] == max) {
                maxCnt++;
            } else if (cnt[i] > max) {
                max = cnt[i];
                maxCnt = 1;
            }
        }
        return maxCnt;
    }

    private int sum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }
}
