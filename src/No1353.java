import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class No1353 {

    public static void main(String[] args) {
        No1353 o = new No1353();
        System.out.println(o.maxEvents(new int[][]{{1, 4}, {4, 4}, {2, 2}, {3, 4}, {1, 1}}));
    }

    public int maxEvents(int[][] events) {
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));
//        int maxDay = 0;
//        for (int[] event : events) {
//            maxDay = Math.max(maxDay, event[1]);
//        }

        int cnt = 0;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int j = 0;
        int n = events.length;
        for (int i = 1; i <= 10_000001; i++) {
            while (j < n && events[j][0] <= i) {
                priorityQueue.add(events[j][1]);
                j++;
            }

            while (!priorityQueue.isEmpty() && priorityQueue.peek() < i) {
                priorityQueue.poll();
            }

            if (!priorityQueue.isEmpty()) {
                priorityQueue.poll();
                cnt++;
            }
            if (j >= n) {
                break;
            }
        }
        return cnt;
    }
}
