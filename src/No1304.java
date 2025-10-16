import java.util.Arrays;

public class No1304 {
    public static void main(String[] args) {
        No1304 o = new No1304();
        System.out.println(Arrays.toString(o.sumZero(4)));
        System.out.println(Arrays.toString(o.sumZero(999)));
    }

    public int[] sumZero(int n) {
        int[] ans = new int[n];
        if (n == 1) {
            return ans;
        }

        int negative = -1000;
        int index = 0;

        if (n % 2 == 0) {
            while (index < n / 2) {
                ans[index] = negative;
                ans[n - index - 1] = -1 * negative;
                negative++;
                index++;
            }
        } else {
            while (index < n / 2) {
                ans[index] = negative;
                ans[n - index - 1] = -1 * negative;
                negative++;
                index++;
            }

            ans[index] = 2;
            ans[index + 1] = 3;
            ans[index - 1] = -5;
        }

        return ans;
    }
} 
