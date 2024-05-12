import java.util.Comparator;
import java.util.PriorityQueue;
import javafx.util.Pair;

public class No857_MinimumCosttoHireKWorkers {
    public static void main(String[] args) {
        System.out.println(mincostToHireWorkers(new int[]{3, 1, 10, 10, 1}, new int[]{4, 8, 2, 2, 7}, 3));
    }

    public static double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        PriorityQueue<Pair<Integer, Double>> pq =
                new PriorityQueue<>(Comparator.comparingDouble(Pair::getValue));

        for (int i = 0; i < quality.length; i++) {
            pq.add(new Pair<>(i, (double) wage[i] / (double) quality[i]));
        }

        int qualitySum = 0;
        double maxRate = 0;

        PriorityQueue<Integer> pqQuality = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < k; i++) {
            Pair<Integer, Double> temp = pq.poll();
            qualitySum += quality[temp.getKey()];
            maxRate = Math.max(maxRate, temp.getValue());
            pqQuality.add(quality[temp.getKey()]);
        }

        double pay = maxRate * qualitySum;
        for (int i = k; i < quality.length; i++) {
            Pair<Integer, Double> planToAdd = pq.poll();
            Integer remove = pqQuality.poll();
            qualitySum = qualitySum + quality[planToAdd.getKey()] - remove;
            pqQuality.add(quality[planToAdd.getKey()]);
            maxRate = Math.max(maxRate, planToAdd.getValue());
            pay = Math.min(pay, qualitySum * maxRate);
        }

        return pay;
    }
}