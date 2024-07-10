public class No633_SumofSquareNumbers {
    public static void main(String[] args) {
//        System.out.println(Math.sqrt(2147483600));
        System.out.println(judgeSquareSum(2147483600));
//        System.out.println(judgeSquareSum(41));
//        System.out.println(judgeSquareSum(3));
    }

    public static boolean judgeSquareSum(int c) {
        int s = 0;
        int e = (int) Math.sqrt(c);
        while (s <= e) {
            long sum = (long) s * s + (long) e * e;
            if (sum == c) {
                return true;
            } else if (sum < c) {
                s++;
            } else {
                e--;
            }
        }
        return false;
    }
}
