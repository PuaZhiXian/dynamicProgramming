import java.util.Arrays;

public class No264 {

    public static void main(String[] args) {
        No264 obj = new No264();
//        System.out.println(obj.nthUglyNumber(10));
        System.out.println(obj.nthUglyNumber(11)); //15


    }

    public int nthUglyNumber(int n) {
        if (n < 2) {
            return n;
        }

        int i2 = 0, i3 = 0, i5 = 0;
        int[] arr = new int[n];
        arr[0] = 1;

        for (int i = 1; i < n; i++) {
            arr[i] = Math.min(arr[i2] * 2, Math.min(arr[i3] * 3, arr[i5] * 5));

            if (arr[i] == arr[i2] * 2) {
                i2++;
            }
            if (arr[i] == arr[i3] * 3) {
                i3++;
            }
            if (arr[i] == arr[i5] * 5) {
                i5++;
            }
        }
        return arr[n - 1];
    }


}
