public class No231 {
    public static void main(String[] args) {
        No231 o = new No231();

    }

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
