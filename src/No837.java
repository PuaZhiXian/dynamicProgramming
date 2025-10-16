import java.util.HashMap;
import java.util.Map;

public class No837 {
    public static void main(String[] args) {
        No837 o = new No837();
        System.out.println(o.new21Game(21, 17, 10));
    }

    public double new21Game(int n, int k, int maxPts) {
        if (k == 0 || k + maxPts <= n) {
            return 1.0;
        }
        double sum = n - k + 1;
        Map<Integer, Double> map = new HashMap<>();
        for (int i = k - 1; i >=0; i--) {
            double p = sum / maxPts;
            map.put(i, p);
            double remove = 0;
            if (i + maxPts <= n) {
                remove = map.getOrDefault(i + maxPts, 1. - 0);
            }
            sum += p - remove;
        }


        return map.get(0);
    }

}
