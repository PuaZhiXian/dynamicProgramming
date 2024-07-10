import java.util.Arrays;

public class No1552_MagneticForceBetweenTwoBalls {
    public static void main(String[] args) {
        System.out.println(maxDistance(new int[]{1, 2, 3, 4, 7}, 3));
        System.out.println(maxDistance(new int[]{5, 4, 3, 2, 1, 1000000000}, 2));
        System.out.println(maxDistance(new int[]{79, 74, 57, 22}, 4));
    }

    public static int maxDistance(int[] position, int m) {
        int result = 0;

        Arrays.sort(position);
        long min = 1;
        long max = 10000000000L;
        while (min < max) {
            long mid = (max + min) / 2;
            boolean able = helper(position, mid, m);
            if (able) {
                result = (int) mid;
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        return result;
    }

    public static boolean helper(int[] position, long gap, int num) {

        int index = 0;
        int cur = position[0];
        int fit = 1;
        while (index < position.length) {
            if (position[index] >= gap + cur) {
                cur = position[index];
                fit++;
                if (fit == num) {
                    return true;
                }
            }
            index++;
        }

        return false;
    }

}
