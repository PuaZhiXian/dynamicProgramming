public class No2206 {
    public static void main(String[] args) {
        No2206 obj = new No2206();
    }

    public boolean divideArray(int[] nums) {
        int[] map = new int[501];

        for (int i = 0; i < nums.length; i++) {
            map[nums[i]]++;
        }

        for (int n : map) {
            if (n % 2 != 0) {
                return false;
            }
        }

        return true;
    }
}
