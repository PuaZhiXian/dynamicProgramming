public class No367_ValidPerfectSquare {
    public static void main(String[] args) {
        System.out.println(isPerfectSquare(16));
    }

    public static boolean isPerfectSquare(int num) {
        double result = Math.pow(num, 0.5);
        return Math.floor(result) == Math.ceil(result);
    }
}
