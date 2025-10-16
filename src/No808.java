import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class No808 {
    public static void main(String[] args) {
        No808 o = new No808();
//        System.out.println(o.soupServings(50));
//        System.out.println(o.soupServings(101));
//        System.out.println(o.soupServings(1000));
//        System.out.println(o.soupServings(3000));
        System.out.println(o.soupServings(4801));
        System.out.println(o.soupServings(4850));
    }

    //
    public double soupServings(int n) {
        if (n > 4800) {
            return 1;
        }
        int m = (int) Math.ceil(n / 25.0);
        return rec(m, m);
    }

    Map<Pair<Integer, Integer>, Double> map = new HashMap();

    private double rec(int A, int B) {
        if (A <= 0 && B <= 0) {
            return 0.5;
        }
        if (A <= 0) {
            return 1;
        }
        if (B <= 0) {
            return 0;
        }
        Pair<Integer, Integer> p = new Pair<>(A, B);
        if (map.containsKey(p)) {
            return map.get(p);
        }


        double ans = (rec(A - 4, B) + rec(A - 3, B - 1) + rec(A - 2, B - 2) + rec(A - 1, B - 3)) / 4.0;

        map.put(p, ans);
        return ans;
    }
}

