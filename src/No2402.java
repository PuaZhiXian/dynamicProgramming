import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;


public class No2402 {


    public static void main(String[] args) {
        No2402 o = new No2402();
        System.out.println(o.mostBooked(3, new int[][]{{1, 20}, {2, 10}, {3, 5}, {4, 9}, {6, 8}}));
//        System.out.println(o.mostBooked(2, new int[][]{{0, 10}, {1, 5}, {2, 7}, {3, 4}}));

    }

    public int mostBooked(int n, int[][] meetings) {
        int[] cnt = new int[n];
        PriorityQueue<Integer> f = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            f.add(i);
        }

        PriorityQueue<long[]> c = new PriorityQueue<>(Comparator.comparingLong((a -> a[0])));
        Arrays.sort(meetings, Comparator.comparingInt(value -> value[0]));
        int mi = 0;
        int ml = meetings.length;
        for (long i = 0; i < Long.MAX_VALUE; ) {
            System.out.println("cur time " + i);
            //free room
            while (!c.isEmpty() && c.peek()[0] <= i) {
                int ri = Math.toIntExact(c.poll()[1]);
                f.add(ri);
                System.out.println("releasing room " + ri);
            }

            while (mi < ml && meetings[mi][0] <= i) {
                if (!f.isEmpty()) {
                    int ri = f.poll();
                    cnt[ri]++;
                    long period = meetings[mi][1] - meetings[mi][0];
                    c.add(new long[]{i + period, ri});
                    System.out.println("start  meeting room " + ri + " expected end time " + (i + period));
                    mi++;
                } else {
                    break;
                }
            }

            if (mi == ml) {
                break;
            }

            if (c.isEmpty()) {
                i = meetings[mi][0];
            } else {
                if (f.isEmpty()) {
                    i = c.peek()[0];
                } else {
                    i = Math.min(c.peek()[0], meetings[mi][0]);
                }
            }

        }
//        System.out.println(Arrays.toString(cnt));
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] > cnt[maxIndex]) {
                maxIndex = i;
                max = cnt[maxIndex];
            }
        }

        return maxIndex;
    }

}