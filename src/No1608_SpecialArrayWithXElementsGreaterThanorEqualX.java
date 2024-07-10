public class No1608_SpecialArrayWithXElementsGreaterThanorEqualX {
    public static void main(String[] args) {
        System.out.println(specialArray(new int[]{2, 5}));
        System.out.println(specialArray(new int[]{0, 0}));
    }

    public static int specialArray(int[] nums) {
        int[] cnt = new int[1001];
        for (int i = 0; i < nums.length; i++) {
            cnt[nums[i]]++;
        }
        int[] sum = new int[1001];
        sum[1000] = cnt[1000];
        if (sum[1000] == 1000) {
            return 1000;
        }
        for (int i = cnt.length - 2; i >= 0; i--) {
            sum[i] = cnt[i] + sum[i + 1];
            if (sum[i] == i) {
                return i;
            } else if (i < sum[i]) {
                return -1;
            }
        }
        return -1;
    }
}
