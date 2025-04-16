public class No476 {
    public static void main(String[] args) {
        No476 obj = new No476();
        System.out.println(obj.findComplement(5));
    }

    public int findComplement(int num) {
        int ans = 0;
        int index = 0;

        while (num > 0) {
            int n = num % 2;
            num = num / 2;
            if (n == 0) {
                ans += (int) Math.pow(2, index);
            }
            index++;
        }

        return ans;
    }
}
