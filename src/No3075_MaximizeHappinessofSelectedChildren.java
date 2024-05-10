import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximize-happiness-of-selected-children
 */
public class No3075_MaximizeHappinessofSelectedChildren {
    public static void main(String[] args) {
//        System.out.println(maximumHappinessSum(new int[]{1, 2, 3}, 2));
//        System.out.println(maximumHappinessSum(new int[]{1,1,1,1}, 2));
        System.out.println(maximumHappinessSum(new int[]{2, 3, 4, 5}, 1));
    }

    public static long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int loop = 0;
        long sum = 0;
        for (int i = happiness.length - 1; i >= 0; i--) {
            int current = happiness[i] - loop;
            if (current <= 0) {
                break;
            }
            sum += current;
            loop++;
            if (loop == k) {
                break;
            }
        }
        return sum;
    }

    public static int getMax(int[] arr) {
        int max = 0;
        for (int i : arr) {
            max = Math.max(max, i);
        }
        return max;
    }

    public static int[] radixSort(int[] arr) {
        // Get the maximum number in arr
        int max = getMax(arr);

        //counting sort for each decimal place
        for (int i = 1; max / i > 0; i *= 10) {
            arr = radixSort_countingSort(arr, i);
        }

        return arr;
    }

    public static int[] radixSort_countingSort(int arr[], int decimalPlace) {
        int originalArrayLength = arr.length;
        int[] countArray = new int[10];
        int[] outputArray = new int[originalArrayLength];
        //count occurrences of elements
        for (int num : arr) {
            countArray[num % (decimalPlace * 10) / decimalPlace]++;
        }
        //cumulative sum
        for (int i = countArray.length - 1; i > 0; i--) {
            countArray[i - 1] += countArray[i];
        }

        for (int i = originalArrayLength - 1; i >= 0; i--) {
            countArray[arr[i] % (decimalPlace * 10) / decimalPlace]--;
            outputArray[countArray[arr[i] % (decimalPlace * 10) / decimalPlace]] = arr[i];
        }
        return outputArray;
    }
}
