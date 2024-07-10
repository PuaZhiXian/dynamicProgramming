public class No2778_SumofSquaresofSpecialElements {
    public static void main(String[] args) {
        System.out.println(sumOfSquares(new int[]{1, 2, 3, 4}));
        System.out.println(sumOfSquares(new int[]{2,7,1,19,18,3}));
    }

    public static int sumOfSquares(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (n % (i + 1) == 0) {
                sum += nums[i] * nums[i];
            }
        }
        return sum;
    }
}
