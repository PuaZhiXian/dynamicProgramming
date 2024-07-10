public class No1823 {
    public static void main(String[] args) {
        for (int i = 0; i < 27; i++) {
            System.out.printf("n: %s , ans: %s \n", i + 1, findTheWinner(i + 1, 3));
        }
    }

    public static int findTheWinner(int n, int k) {
        int winner = 0;
        for (int i = 1; i <= n; i++) {
            winner = (winner + k) % i;
        }
        return winner + 1;
    }
}
