import java.util.Arrays;

public class No26_RemoveDuplicatesfromSortedArray {
    public static void main(String[] args) {
        int[] n = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println((removeDuplicates(n)));
        System.out.println(Arrays.toString(n));
    }

    public static int removeDuplicates(int[] nums) {
        int unique = 1;
        int[] isolate = nums.clone();
        if (isolate.length == 0) {
            return 0;
        }
        int cur = isolate[0];
        nums[0] = isolate[0];
        int index = 1;
        for (int i = 0; i < isolate.length; i++) {
            if (isolate[i] != cur) {
                cur = isolate[i];
                nums[index] = cur;
                unique++;
                index++;
            }
        }
        return unique;
    }
}
