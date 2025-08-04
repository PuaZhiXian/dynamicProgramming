import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class No2616 {
    public static void main(String[] args) {
        No2616 o = new No2616();
        System.out.println(o.minimizeMax(new int[]{10, 1, 1, 2, 3, 7}, 2));
        System.out.println(o.minimizeMax(new int[]{4, 2, 1, 2}, 1));
    }

    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int l = 0;
        int r = nums[nums.length - 1] - nums[0];

        Set<Integer> validMax = new HashSet<>();
        while (l <= r) {
            int mid = l + (r - l) / 2;
//            System.out.println("Mid " + mid);
            int max = 0;
            int cnt = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i + 1] - nums[i] <= mid) {
                    max = Math.max(nums[i + 1] - nums[i], max);
                    cnt++;
                    i++;
                }
            }


            if (cnt < p) {
//                System.out.println(String.format("cnt %d < p %s, move left to centre", cnt, p));
//                System.out.println("max " + max);
                l = mid + 1;
            } else {
                validMax.add(max);
//                System.out.println(String.format("cnt %d >= p %s, move right to centre", cnt, p));
//                System.out.println("max " + max);
                r = mid - 1;
            }
        }

        int min = Integer.MAX_VALUE;
        for (int num : validMax) {
            min = Math.min(min, num);
        }

        return validMax.isEmpty() ? 0 : min;
    }
}
