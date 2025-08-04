import java.util.*;

public class No3362 {
    public static void main(String[] args) {
        No3362 obj = new No3362();
//        System.out.println(obj.maxRemoval(new int[]{2, 0, 2}, new int[][]{{1, 1}, {0, 2}, {0, 2}}));
        System.out.println(obj.maxRemoval(new int[]{1, 1, 1, 1}, new int[][]{{1, 3}, {0, 2}, {1, 3}, {1, 2}}));//2

    }

    public int maxRemoval(int[] nums, int[][] queries) {
        Arrays.sort(queries, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<Integer> available = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> used = new PriorityQueue<>();

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            while (index < queries.length && queries[index][0] == i) {
                available.add(queries[index][1]);
                index++;
            }

            if (nums[i] == 0) {
                continue;
            }
            while (!used.isEmpty() && used.peek() < i) {
                used.poll();
            }
            if (used.size() >= nums[i]) {
                nums[i] = 0;
            } else {
                nums[i] -= used.size();
                while (nums[i] > 0) {
                    if (available.isEmpty()) {
                        return -1;
                    }
                    int next = available.poll();
                    if (next < i) {
                        return -1;
                    } else {
                        used.add(next);
                        nums[i]--;
                    }
                }
            }
        }

        return available.size();
    }


}
