import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

public class No1438 {
    public static void main(String[] args) {
        System.out.println(temp(new int[]{8, 2, 4, 7}, 4));//2
//        System.out.println(longestSubarray(new int[]{10, 1, 2, 4, 7, 2}, 5));//4
//        System.out.println(longestSubarray(new int[]{4, 2, 2, 2, 4, 4, 2, 2}, 0));//3

    }

    public static int longestSubarray(int[] nums, int limit) {
        PriorityQueue<Integer> maxpq = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minpq = new PriorityQueue<>();

        int left = 0;
        int right = 0;
        int maxSize = 1;
        while (right < nums.length) {
            maxpq.add(nums[right]);
            minpq.add(nums[right]);
            int min = minpq.peek();
            int max = maxpq.peek();

            if (Math.abs(max - min) > limit) {
                int newMin;
                int newMax;
                do {
                    int wantRemoveElement = nums[left];
                    maxpq.remove(wantRemoveElement);
                    minpq.remove(wantRemoveElement);
                    newMin = minpq.peek();
                    newMax = maxpq.peek();
                    left++;
                } while (Math.abs(newMin - newMax) > limit);
            } else {
                maxSize = Math.max(maxSize, maxpq.size());
            }
            right++;
        }

        return maxSize;
    }

    public static int temp(int[] nums, int limit) {
        Deque<Integer> maxq = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            maxq.add(nums[i]);
        }
        System.out.println(maxq.pollFirst());
        System.out.println(maxq);
        return 0;
    }
}
