import java.util.Arrays;

public class No2563 {
    public static void main(String[] args) {
        No2563 obj = new No2563();
//        System.out.println(obj.countFairPairs(new int[]{0, 1, 4, 4, 5, 7}, 3, 6));//6
//        System.out.println(obj.countFairPairs(new int[]{1, 2, 5, 7, 9}, 11, 11));//1
//        System.out.println(obj.countFairPairs(new int[]{-1, 0}, 1, 1));//0
//        System.out.println(obj.countFairPairs(new int[]{0, 0, 0, 0, 0, 0}, 0, 0));//15
//        System.out.println(obj.countFairPairs(new int[]{2, 3, 4, 5, 6, 7, 9, 10}, 13, 13));//3
//        System.out.println(obj.countFairPairs(new int[]{-1000000000, -1000000000, -1000000000, -1000000000, 6, 7, 8, 9}, -14, 11));//0
        System.out.println(obj.countFairPairs(new int[]{-7, -7, -5, -5, -5}, -12, -12));
    }

    public long countFairPairs(int[] nums, int lower, int upper) {
        long ans = 0;
        Arrays.sort(nums);

        int lowBo = -1;
        int highBo = -1;
        int init = 0;

        int prev = nums[init];
        while (lowBo == -1 && init < nums.length) {
            if (init != 0) {
                if (prev == nums[init]) {
                    init++;
                    continue;
                }
                prev = nums[init];
            }
            for (int i = init + 1; i < nums.length; i++) {
                if (nums[init] + nums[i] >= lower && nums[init] + nums[i] <= upper) {
                    lowBo = i;
                    break;
                }
                if (nums[init] + nums[i] > upper) {
                    break;
                }
            }

            for (int i = nums.length - 1; i > init; i--) {
                if (nums[init] + nums[i] <= upper && nums[init] + nums[i] >= lower) {
                    highBo = i;
                    break;
                }
                if (nums[init] + nums[i] < lower) {
                    break;
                }
            }
            init++;
        }
        if (lowBo == -1) {
            return 0;
        }

        ans += (highBo - lowBo + 1);
        for (int i = init; i < nums.length - 1; i++) {
            lowBo = Math.max(lowBo, i + 1);
            for (int j = lowBo; j > i; j--) {
                if (nums[i] + nums[j] >= lower && nums[i] + nums[j] <= upper) {
                    lowBo = j;
                }
                if (nums[i] + nums[j] < lower) {
                    break;
                }
            }

            for (int j = highBo; j > i; j--) {
                if (nums[i] + nums[j] <= upper && nums[i] + nums[j] >= lower) {
                    highBo = j;
                    break;
                }
            }

            if (lowBo < i + 1) {
                break;
            } else {
                if (nums[i] + nums[lowBo] >= lower
                        && nums[i] + nums[lowBo] <= upper
                        && nums[i] + nums[highBo] >= lower
                        && nums[i] + nums[highBo] <= upper) {
                    ans += (highBo - lowBo + 1);
                }
            }
        }
        return ans;
    }
}
