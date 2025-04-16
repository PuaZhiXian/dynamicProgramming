import java.util.Arrays;

public class No912 {
    public static void main(String[] args) {
        No912 obj = new No912();
        System.out.println(Arrays.toString(obj.sortArray(new int[]{5, 2, 3, 1})));
    }

    public int[] sortArray(int[] nums) {
        Arrays.sort(nums);
        return nums;
    }
}
