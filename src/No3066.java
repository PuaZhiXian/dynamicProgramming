import java.util.PriorityQueue;

public class No3066 {
    public static void main(String[] args) {
        No3066 obj = new No3066();
        System.out.println(obj.minOperations(new int[]{999999999, 999999999, 999999999}, 1000000000));
    }

    public int minOperations(int[] nums, int k) {
        int ans = 0;
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < k) {
                priorityQueue.add(Long.valueOf(nums[i]));
            }
        }

        long num1 = 0;
        while (!priorityQueue.isEmpty()) {
            long temp = priorityQueue.poll();
            if (temp >= k) {
                break;
            }
            if (num1 == 0) {
                num1 = temp;
            } else {
                long sum = sub(num1, temp);
                if (sum < k) {
                    priorityQueue.add(sum);
                }
                ans++;
                num1 = 0;
            }
        }

        if (num1 != 0) {
            ans++;
        }
        return ans;

    }

    public long sub(long num1, long num2) {
        return (Math.min(num1, num2) * 2) + (Math.max(num1, num2));
    }
}
