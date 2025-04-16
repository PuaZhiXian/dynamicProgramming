import java.util.HashMap;
import java.util.Map;

public class No1105 {

    public static void main(String[] args) {
        No1105 obj = new No1105();

        System.out.println(obj.minHeightShelves(new int[][]{{1, 1}, {2, 3}, {2, 3}, {1, 1}, {1, 1}, {1, 1}, {1, 2}}, 4));

    }

    Map<Integer, Integer> map = new HashMap<>();
    public int minHeightShelves(int[][] books, int shelfWidth) {
        return helper(books, 0, shelfWidth);
    }

    public int helper(int[][] books, int index, int w) {
        if (map.containsKey(index)) {
            return map.get(index);
        }
        if (index == books.length) {
            return 0;
        }
        int h = 0;
        int curw = w;

        int min = Integer.MAX_VALUE;
        for (int i = index; i < books.length; i++) {
            if (books[i][0] > curw) {
                break;
            }
            h = Math.max(h, books[i][1]);
            curw -= books[i][0];
            min = Math.min(min, h + helper(books, i + 1, w));
        }

        map.put(index, min);
        return min;
    }
}
