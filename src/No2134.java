public class No2134 {
    public static void main(String[] args) {
        No2134 obj = new No2134();
        System.out.println(obj.minSwaps(new int[]{0, 1, 0, 1, 1, 0, 0}));
        System.out.println(obj.minSwaps(new int[]{1, 1, 1, 0, 0, 1, 0, 1, 1, 0}));
    }

    public int minSwaps(int[] nums) {
        int ans = 0;

        int oneCnt = 0;
        for (int n : nums) {
            if (n == 1) {
                oneCnt++;
            }
        }
        if (oneCnt == 0 || oneCnt == nums.length) {
            return 0;
        }


        for (int i = 0; i < oneCnt; i++) {
            if (nums[i] == 0) {
                ans++;
            }
        }

        int temp = ans;
        int i = oneCnt;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == 0) {
                temp--;
            }
            if (nums[i] == 0) {
                temp++;
            }

            ans = Math.min(ans, temp);
            i++;
            if (i == nums.length) {
                i = 0;
            }
//            prev = nums[j];
        }

        return ans;
    }
}
