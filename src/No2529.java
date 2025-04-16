public class No2529 {
    public static void main(String[] args) {
        No2529 obj = new No2529();
    }

    public int maximumCount(int[] nums) {

        int p = 0;
        int n = 0;
        for (int num : nums) {
            if (num > 0) {
                p++;
            } else if (num <0) {
                n++;
            }
        }
        return Math.max(p, n);

    }
}
