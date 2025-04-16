import java.util.Arrays;

public class No3396 {
    public static void main(String[] args) {
        No3396 obj = new No3396();
        System.out.println(obj.minimumOperations(new int[]{1, 2, 3, 4, 2, 3, 3, 5, 7}));
    }

    public int minimumOperations(int[] nums) {
        int[] arr = new int[101];
        int cnt = 0;
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]]++;
            while (arr[nums[i]] > 1) {
                for (int j = 0; j < 3; j++) {
                    if (index < nums.length) {
                        arr[nums[index]]--;
                        index++;
                    }
                }
                cnt++;
            }
//            System.out.println(Arrays.toString(arr));
        }

        return cnt;
    }
}
