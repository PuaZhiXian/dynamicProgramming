import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class No947 {
    public static void main(String[] args) {
        No947 obj = new No947();
        System.out.println(obj.removeStones(new int[][]{{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}}));
    }


    public int removeStones(int[][] stones) {
        List<Model> list = new ArrayList<>();

        for (int i = 0; i < stones.length; i++) {
            

        }
        return 0;
    }

    class Model {
        Set<Integer> x = new HashSet<>();
        Set<Integer> y = new HashSet<>();

        Set<Integer> node;


    }
}
