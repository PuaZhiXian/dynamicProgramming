import java.util.Map;
import java.util.TreeMap;

public class No1833 {
    public static void main(String[] args) {
//        System.out.println(maxIceCream(new int[]{1, 3, 2, 4, 1}, 7));
//        System.out.println(maxIceCream(new int[]{10, 6, 8, 7, 7, 8}, 5));
//        System.out.println(maxIceCream(new int[]{1, 6, 3, 1, 2, 5}, 20));
//        System.out.println(maxIceCream(new int[]{10, 2, 10, 10, 10, 10, 8, 2, 7, 8}, 25));
        System.out.println(maxIceCream(new int[]{6, 50, 54, 21, 88, 52, 42, 12, 90, 100, 77, 94, 82, 94, 82, 52, 64, 77, 90, 57, 2, 2, 4, 70, 48, 71, 17, 99, 82, 74, 50, 40, 10, 6, 13, 96, 26, 90, 34, 82, 18, 67, 58, 2, 36, 77, 28, 62, 43, 8, 10, 70, 94, 54, 82, 39, 82, 16, 78, 82, 26, 98, 62, 77, 30, 14, 10, 2, 100, 18, 72, 28, 28, 88, 62, 62, 82, 74, 30, 16, 82, 13, 11, 38, 50, 17, 18, 62, 26, 13, 54, 71, 12, 2, 50, 38, 19, 26, 5, 82}, 763));
    }

    public static int maxIceCream(int[] costs, int coins) {
        int result = 0;
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < costs.length; i++) {
            map.put(costs[i], map.getOrDefault(costs[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer val = entry.getValue();
            if (key > coins) {
                break;
            }

            if (val * key <= coins) {
                result += val;
                coins = coins - (key * val);
            } else {
                int temp = (int) Math.floor(coins / key);
                result += temp;
                coins = coins - (temp * key);
            }
        }

        return result;
    }
}
