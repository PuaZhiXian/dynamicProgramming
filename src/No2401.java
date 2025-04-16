public class No2401 {
    public static void main(String[] args) {
        No2401 obj = new No2401();
        System.out.println(obj.longestNiceSubarray(new int[]{1, 3, 8, 48, 10}));
    }

    public int longestNiceSubarray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int l = 0;
        int r = 0;
        boolean b = false;
        while (l <= r && r < nums.length) {
            if (l == r) {
                r++;
                max = Math.max(max, 1);
                continue;
            }
            b = true;
            for (int i = l; i < r; i++) {
                if ((nums[i] & nums[r]) != 0) {
                    b = false;
//                    System.out.printf("false l:%s, r:%s     ", i, r);
                    break;
                }
            }
//            System.out.printf("l:%s r:%s b:%s\n", l, r, b);

            if (b) {
                r++;
                max = Math.max(max, r - l);
            } else {
                l++;
            }
            if (max == 30) {
                break;
            }
        }

        return max;
    }
}
