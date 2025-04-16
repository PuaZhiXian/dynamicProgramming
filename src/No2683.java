public class No2683 {
    public static void main(String[] args) {

        System.out.println(0 ^ 0);
        System.out.println(0 ^ 0 ^ 0);
        System.out.println(1 ^ 1);
        System.out.println(1 ^ 1 ^ 1);
    }

    public boolean doesValidArrayExist(int[] derived) {

        int ans = 0;
        for (int j : derived) {
            ans = ans ^ j;
        }
        return ans == 0;

    }
}
