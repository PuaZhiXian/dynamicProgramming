import java.util.Arrays;

public class mainClass {

    public static void main(String[] args) {
        mainClass obj = new mainClass();
//        System.out.println(obj.getKth(12, 15, 2));
//        System.out.println(obj.getKth(1, 20, 2));
//        String s5 = "anagram";
//        String t5 = "nagaram";
    }

    public int getKth(int lo, int hi, int k) {
        int[][] result = new int[hi - lo + 1][2];
        for (int i = 0; i < result.length; i++) {
            int curX = lo + i;
            int x = lo + i;
            result[i][0] = i;
            if (result[i][1] > 0) {
                continue;
            }
            int cnt = 0;
            while (x > 1) {
                cnt++;
                if (x % 2 == 0) {
                    x /= 2;
                } else {
                    x = 3 * x + 1;
                }
                if (x < curX && x >= lo) {
                    cnt += result[x - lo][1];
                    break;
                }
            }
            result[i][1] = cnt;
            int skipping = curX;
            while (skipping * 2 < hi) {
                skipping *= 2;
                cnt++;
                result[skipping - lo][0] = skipping - lo;
                result[skipping - lo][1] = cnt;
            }

        }

        int max = 0;
        for (int i = 0; i < result.length; i++) {
            if (max < result[i][1]) {
                max = result[i][1];
            }
        }
        int[][] arr = result;
        //radix sort
        for (int i = 1; max / i > 0; i *= 10) {
            arr = radixSort_countingSort(arr, i);
        }

        int kTh = arr[k - 1][0] + lo;
        System.out.println(Arrays.deepToString(result));
        System.out.println(Arrays.deepToString(arr));
        return kTh;

    }

    public static int[][] radixSort_countingSort(int[][] arr, int decimalPlace) {
        int originalArrayLength = arr.length;
        int[] countArray = new int[10];
        int[][] outputArray = new int[originalArrayLength][2];
        //count occurrences of elements
        for (int i = 0; i < arr.length; i++) {
            countArray[arr[i][1] % (decimalPlace * 10) / decimalPlace]++;
        }
        //cumulative sum
        for (int i = 0; i < 9; i++) {
            countArray[i + 1] += countArray[i];
        }

        for (int i = originalArrayLength - 1; i >= 0; i--) {
            countArray[arr[i][1] % (decimalPlace * 10) / decimalPlace]--;
            outputArray[countArray[arr[i][1] % (decimalPlace * 10) / decimalPlace]] = arr[i];
        }
        return outputArray;
    }
}
