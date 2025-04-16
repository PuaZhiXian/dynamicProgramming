import java.util.Arrays;

public class No307 {
    public static void main(String[] args) {
        No307 obj = new No307();
//        NumArray array = obj.new NumArray(new int[]{9, -8});
        NumArray array = obj.new NumArray(new int[]{3, -8});
//        array.update(0, 3);
        System.out.println(array.sumRange(1, 1));
//        array.update(1, -3);
    }

    class NumArray {

        int[] arr;
        int[] nums;

        public NumArray(int[] nums) {
            int result = (int) Math.ceil(Math.log(nums.length) / Math.log(2));
            arr = new int[(int) (2 * Math.pow(2, result) - 1)];
            this.nums = nums;
            constructTree(0, nums, 0, nums.length - 1);
        }

        private int constructTree(int treeIndex, int[] nums, int left, int right) {
            if (left == right) {
                arr[treeIndex] = nums[left];
                return nums[left];
            }

            int mid = (right + left) / 2;
            int val = constructTree(treeIndex * 2 + 1, nums, left, mid) +
                    constructTree(treeIndex * 2 + 2, nums, mid + 1, right);
            arr[treeIndex] = val;
            System.out.println(Arrays.toString(arr));
            return val;
        }

        public void update(int index, int val) {
            int diff = val - nums[index];
            updateTree(diff, 0, 0, nums.length - 1, index);
            nums[index] = val;
        }

        private void updateTree(int diff, int treeIndex, int left, int right, int targetIndex) {
            if (right < targetIndex || left > targetIndex) {
                return;
            }
            arr[treeIndex] += diff;

            if (left != right) {
                int mid = (left + right) / 2;
                updateTree(diff, treeIndex * 2 + 1, left, mid, targetIndex);
                updateTree(diff, treeIndex * 2 + 2, mid + 1, right, targetIndex);
            }
        }

        public int sumRange(int left, int right) {
            return getRange(0, 0, nums.length - 1, left, right);
        }

        private int getRange(int treeIndex, int left, int right, int targetLeft, int targetRight) {
            if (right < targetLeft || left > targetRight) {
                return 0;
            }
            if (targetLeft <= left && targetRight >= right) {
                return arr[treeIndex];
            }
            int mid = (left + right) / 2;

            return getRange(2 * treeIndex + 1, left, mid, targetLeft, targetRight)
                    + getRange(2 * treeIndex + 2, mid + 1, right, targetLeft, targetRight);
        }

    }

}
