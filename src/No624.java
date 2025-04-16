import java.util.Arrays;
import java.util.List;

public class No624 {
    public static void main(String[] args) {
        No624 obj = new No624();
        System.out.println(obj.maxDistance(
                Arrays.asList(
                        Arrays.asList(1, 2, 3),
                        Arrays.asList(4, 5),
                        Arrays.asList(1, 2, 3)
                )

        ));
    }


    public int maxDistance(List<List<Integer>> arrays) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int secMin = min;
        int secMax = max;
        int minIndex = -1;
        int maxIndex = -1;

        for (int i = 0; i < arrays.size(); i++) {
            int curMax = arrays.get(i).get(arrays.get(i).size() - 1);
            int curMin = arrays.get(i).get(0);
            if (min > curMin) {
                secMin = min;
                min = curMin;
                minIndex = i;
            } else if (secMin > curMin) {
                secMin = curMin;
            }
            if (max < curMax) {
                secMax = max;
                max = curMax;
                maxIndex = i;
            } else if (secMax < curMax) {
                secMax = curMax;
            }
        }

        return maxIndex == minIndex ? Math.max(Math.abs(min - secMax), Math.abs(max - secMin)) : Math.abs(max - min);

    }
}
