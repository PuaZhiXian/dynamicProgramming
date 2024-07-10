import java.util.Arrays;

public class No75_SortColors {
    public static void main(String[] args) {
        int[] n = new int[]{2, 0, 2, 1, 1, 0};
        sortColors(n);
        System.out.println(Arrays.toString(n));


        int[] n2 = new int[]{2, 0, 1};
        sortColors(n2);
        System.out.println(Arrays.toString(n2));
    }

    public static void sortColors(int[] nums) {
        int[] n = new int[3];
        for (int i = 0; i < nums.length; i++) {
            n[nums[i]]++;
        }
        int index = 0;
        for (int i = 0; i < n.length; i++) {
            int cnt = n[i];
            for (int j = 0; j < cnt; j++) {
                nums[index] = i;
                index++;
            }
        }
    }
}
