import java.util.Arrays;

public class No2551 {
    public static void main(String[] args) {
        No2551 obj = new No2551();
        System.out.println(obj.putMarbles(new int[]{1, 3, 5, 1}, 2));
    }

    public long putMarbles(int[] weights, int k) {
        long[] split = new long[weights.length - 1];
        long max = 0, min = 0;

        for (int i = 0; i < weights.length - 1; i++) {
            split[i] = weights[i] + weights[i + 1];
        }

        Arrays.sort(split);
//        System.out.println(Arrays.toString(split));
        for (int i = 0; i < k - 1; i++) {
            min += split[i];
        }
        for (int i = split.length - 1; i > split.length - k; i--) {
            max += split[i];
        }

//        System.out.printf("max: %s, min: %s ", max, min);
        return max - min;
    }
}
