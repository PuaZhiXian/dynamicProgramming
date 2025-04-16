import java.util.Arrays;

public class No1508 {
    public static void main(String[] args) {
        No1508 obj = new No1508();
        System.out.println(obj.rangeSum(new int[]{1, 2, 3, 4}, 4, 1, 5));
    }

    public int rangeSum(int[] nums, int n, int left, int right) {
        long ans = 0;
        int[] arr = new int[n * (n + 1) / 2];
        int index = 1;

        arr[0] = nums[0];
        for (int i = 1; i < n; i++) {
            arr[index] = arr[index - 1] + nums[i];
            index++;
        }
        int x = n - 1;
        int remove = 0;
        while (index < arr.length) {
            for (int i = 0; i < x; i++) {
                arr[index] = arr[index - x] - nums[remove];
                index++;
            }
            x--;
            remove++;
        }


        Arrays.sort(arr);
        for (int i = left - 1; i < right; i++) {
            ans += arr[i];
        }

        return (int) (ans % 1000_000_007);
    }
}
