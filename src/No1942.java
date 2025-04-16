import javafx.util.Pair;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class No1942 {
    public static void main(String[] args) {
        No1942 obj = new No1942();

        System.out.println(obj.smallestChair(
                new int[][]{{4, 5}, {12, 13}, {5, 6}, {1, 2}, {8, 9}, {9, 10}, {6, 7}, {3, 4}, {7, 8}, {13, 14}, {15, 16}, {14, 15}, {10, 11}, {11, 12}, {2, 3}, {16, 17}},
                1)); //0
    }

    public int smallestChair(int[][] times, int targetFriend) {
        int tArrived = times[targetFriend][0];
        Arrays.sort(times, Comparator.comparingInt(row -> row[0]));
        PriorityQueue<Pair<Integer, Integer>> leavingTime = new PriorityQueue<>(new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
                return p1.getKey().compareTo(p2.getKey()); // Compare the first elements (keys)
            }
        });
        PriorityQueue<Integer> releasedSeat = new PriorityQueue<>();
        int maxSet = 1;

        leavingTime.add(new Pair<>(times[0][1], 0));

        for (int i = 1; i < times.length; i++) {
            while (!leavingTime.isEmpty()) {
                if (times[i][0] >= leavingTime.peek().getKey()) {
                    int val = leavingTime.poll().getValue();
                    releasedSeat.add(val);
                } else {
                    break;
                }
            }

            if (releasedSeat.isEmpty()) {
                if (tArrived == times[i][0]) {
                    return maxSet;
                }
                leavingTime.add(new Pair<>(times[i][1], maxSet));
                maxSet++;
            } else {
                if (tArrived == times[i][0]) {
                    return releasedSeat.poll();
                }
                leavingTime.add(new Pair<>(times[i][1], releasedSeat.poll()));
            }
        }
        System.out.println(Arrays.deepToString(times));
        return 0;
    }

}
