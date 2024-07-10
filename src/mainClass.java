import java.util.Arrays;

public class mainClass {
    public static void main(String[] args) {
        System.out.println(maximumPoints(new int[]{3, 2, 2}, 2));
//        System.out.println(maximumPoints(new int[]{2}, 10));
    }

    public static long maximumPoints(int[] enemyEnergies, int currentEnergy) {
        long point = 0;
        Arrays.sort(enemyEnergies);
        for (int i = enemyEnergies.length - 1; i >= 0; i--) {
            if (currentEnergy < enemyEnergies[i]) {
                currentEnergy += enemyEnergies[i];
            } else {
                point++;
                currentEnergy -= enemyEnergies[i];
                i++;
            }
        }
        return point;
    }

}
