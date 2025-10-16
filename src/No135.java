import java.lang.reflect.Array;
import java.util.Arrays;

public class No135 {
    public static void main(String[] args) {
        No135 o = new No135();
        System.out.println(o.candy(new int[]{1, 0, 2}));
    }


    public int candy(int[] ratings) {
        int[] arr = new int[ratings.length];
        int ans = 0;
        Arrays.fill(arr, 1);

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                arr[i] = arr[i - 1] + 1;
            }
        }

        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && arr[i] <= arr[i + 1]) {
                arr[i] = arr[i + 1] + 1;
            }
        }

        for (int j : arr) {
            ans += j;
        }

        return ans;
    }

}
