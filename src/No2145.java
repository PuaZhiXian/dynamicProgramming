import java.util.Arrays;

public class No2145 {
    public static void main(String[] args) {
        No2145 obj = new No2145();
//        System.out.println(obj.numberOfArrays(new int[]{1, -3, 4}, 1, 6));
        System.out.println(obj.numberOfArrays(new int[]{-40}, -46, 53));
    }

    public int numberOfArrays(int[] differences, int lower, int upper) {
        int min = 1, max = 1, index = 1;
        for (int difference : differences) {
            index += difference;
            min = Math.min(index, min);
            max = Math.max(index, max);
            if (index > 100000 * 2) {
                return 0;
            }
            if (index < -100000 * 2) {
                return 0;
            }
        }
        return Math.max(((upper - lower + 1) - (max - min)), 0);
    }
}
