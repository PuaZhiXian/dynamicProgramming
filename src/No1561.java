import java.util.Arrays;

public class No1561 {
    public static void main(String[] args) {
        System.out.println(maxCoins(new int[]{2, 4, 1, 2, 7, 8}));
    }

    public static int maxCoins(int[] piles) {
        int result = 0;
        Arrays.sort(piles);

        for (int i = piles.length / 3; i < piles.length; i += 2) {
            result += piles[i];
        }
        return result;
    }
}
