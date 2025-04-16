import java.util.HashMap;
import java.util.Map;

public class No2537 {
    public static void main(String[] args) {
        No2537 obj = new No2537();
        System.out.println(obj.countGood(new int[]{1, 1, 1, 1, 1}, 10));//1
        System.out.println(obj.countGood(new int[]{3, 1, 4, 3, 2, 2, 4}, 2));//4
    }

    public long countGood(int[] nums, int k) {
        long ans = 0;
        Map<Integer, Integer> arr = new HashMap<>(nums.length, 0.99f);

        int left = 0, right = 0;
        long cnt = 0;
        while (right < nums.length) {
            int rNum = nums[right];
            cnt -= getPairCnt(arr.getOrDefault(rNum, 0));
            arr.put(rNum, arr.getOrDefault(rNum, 0) + 1);
            cnt += getPairCnt(arr.get(rNum));

            if (cnt >= k) {
                int removeCnt = 0;
                while (cnt >= k) {
                    int lNum = nums[left];
                    removeCnt++;
                    cnt -= getPairCnt(arr.get(lNum));
                    arr.put(lNum, arr.get(lNum) - 1);
                    cnt += getPairCnt(arr.get(lNum));
                    left++;
                }
                ans = ans + ((long) removeCnt * (nums.length - right));
            }
            right++;
        }


        return ans;
    }

    public static long getPairCnt(int n) {
        return (long) (n - 1) * n / 2;
    }
}
