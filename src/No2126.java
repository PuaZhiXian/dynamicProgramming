import java.util.Arrays;

public class No2126 {
    public static void main(String[] args) {
//        System.out.println(asteroidsDestroyed(10, new int[]{3, 9, 19, 5, 21}));

    }

    public static boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long temp = mass;
        for (int i = 0; i < asteroids.length; i++) {
            if (temp < asteroids[i]) {
                return false;
            }
            temp += asteroids[i];
        }
        return true;
    }
}
