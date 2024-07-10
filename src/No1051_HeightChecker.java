import java.util.Arrays;

public class No1051_HeightChecker {
    public static void main(String[] args) {
        System.out.println(heightChecker(new int[]{1, 1, 4, 2, 1, 3}));
        System.out.println(heightChecker(new int[]{5, 1, 2, 3, 4}));
        System.out.println(heightChecker(new int[]{1, 2, 3, 4, 5}));
    }

    public static int heightChecker(int[] heights) {
        int[] init = heights.clone();
        Arrays.sort(heights);
        int sum = 0;
        for (int i = 0; i < init.length; i++) {
            if (init[i] != heights[i]) {
                sum++;
            }
        }
        return sum;
    }
}
