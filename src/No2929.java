public class No2929 {

    public static void main(String[] args) {
        No2929 o = new No2929();
        System.out.println(o.distributeCandies(5, 2));
    }

    public long distributeCandies(int n, int limit) {

        return helper(n + 2) - (3 * helper(n - limit + 1)) + (3 * helper(n - (2 * (limit + 1)) + 2)) - helper(n - (3 * (limit + 1)) + 2);
    }

    private long helper(int n) {
        if (n < 0) {
            return 0;
        }

        return ((long) n * (n - 1)) / 2;
    }
}
