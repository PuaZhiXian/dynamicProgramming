import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

public class No976 {
    public static void main(String[] args) {
        No976 o = new No976();
        System.out.println(o.largestPerimeter(new int[]{1, 2, 3}));
    }

    public int largestPerimeter(int[] nums) {
        nums = Arrays.stream(nums)
                .boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();


        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == 0) {
                continue;
            }
            int a = nums[i];
            for (int j = i + 1; j < nums.length - 1; j++) {
                int b = nums[j];
                for (int k = j + 1; k < nums.length; k++) {
                    int c = nums[k];
                    if (b + c < a) {
                        break;
                    }
                    if (a + b > c && b + c > a && b + c > a) {
                        return a + b + c;
                    }
                }
            }
        }

        return 0;
    }


} 
