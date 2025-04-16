public class No650 {
    public static void main(String[] args) {
        No650 obj = new No650();
        System.out.println(obj.minSteps(1000));
    }

    public int minSteps(int n) {
        int ans = 0;
        int comparing = n;
        for (int i = n / 2; i > 0; i--) {
            if (comparing % i == 0) {
                ans = ans + (comparing / i);
                comparing = i;
                i = i / 2 + 1;
            }
        }
        return ans;
    }
}
