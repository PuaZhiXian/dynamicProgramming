public class No2560 {
    public static void main(String[] args) {
        No2560 obj = new No2560();
        System.out.println(obj.minCapability(new int[]{2, 3, 5, 9}, 2));
    }

    public int minCapability(int[] nums, int k) {
        int min = 0;
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            low = Math.min(low, nums[i]);
            high = Math.max(high, nums[i]);
        }
        if(k==1){
            return low;
        }

        int mid;
        while (low <= high) {
            mid = low + (high - low) / 2;

//            System.out.println("low " + low + " high " + high + " mid " + mid);
            if (able(nums, mid, k)) {
                high = mid - 1;
                min = mid;
            } else {
                low = mid + 1;
            }
//            System.out.println("low " + low + " high " + high + " mid " + mid);

        }

        return min;
    }


    private boolean able(int[] nums, int bag, int tar) {
        int last = -2;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= bag && (i - last) != 1) {
                last = i;
                tar--;
                if (tar == 0) {
                    return true;
                }
            }
        }

        return false;
    }
}
