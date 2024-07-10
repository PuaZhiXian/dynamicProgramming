public class No995 {
    public static void main(String[] args) {
//        System.out.println(temp(new int[]{0, 1, 1, 1, 0, 0}, 3));
//        System.out.println(temp(new int[]{0, 1, 1, 1}, 3));
//        System.out.println(temp(new int[]{0, 1, 1, 0, 1, 0, 0}, 3));
//        System.out.println(temp(new int[]{1, 0, 0, 1, 1, 0, 1, 1, 1}, 3));
        System.out.println(temp(new int[]{1, 0, 1, 0, 0, 0, 1, 0, 1, 1}, 5));
    }

    public static int minKBitFlips(int[] nums, int k) {
        int result = 0;

        int start = 0;
        while (start + k - 1 < nums.length) {
            if (nums[start] == 1) {
                start++;
            } else {
                result++;
                nums[start] = 1;
                int small = start;
                for (int i = 1; i < k; i++) {
                    if (nums[start + i] == 1 && small == start) {
                        small = start + i;
                    }
                    nums[start + i] = Math.abs(nums[start + i] - 1);
                }
                if (start + k - 1 == nums.length - 1 && small != start) {
                    return -1;
                }
                start = small;
            }
        }
        for (int i = 1; i < k; i++) {
            if (nums[nums.length - i] == 0) {
                return -1;
            }
        }
        return result;
    }

    public static int temp(int[] nums, int k) {
        int result = 0;

        int start = 0;
        while (start + k - 1 < nums.length) {
            if (nums[start] == 1) {
                start++;
            } else {
                nums[start] = 1;


            }
        }

        for (int i = 1; i < k; i++) {
            if (nums[nums.length - i] == 0) {
                return -1;
            }
        }
        return result;
    }
}
