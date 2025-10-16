import java.util.Arrays;

public class No2327 {
    public static void main(String[] args) {
        No2327 o = new No2327();
//        System.out.println(o.peopleAwareOfSecret(6, 2, 4));
//        System.out.println(o.peopleAwareOfSecret(4, 1, 3));
        System.out.println(o.peopleAwareOfSecret(684, 18, 496));
    }

    int mod = 1000000007;

    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int[] memory = new int[forget];
        memory[forget - 1] = 1;
        int start = 1;
        int end = forget - delay;

        for (int i = 1; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < memory.length; j++) {
                if (j >= start && j <= end) {
                    sum = (sum + memory[j]) % mod;
                }
                if (j < memory.length - 1) {
                    memory[j] = memory[j + 1];
                }
            }
            memory[forget - 1] = sum;
        }

        int sum = 0;
        for (int j : memory) {
            sum = (sum + j) % mod;
        }
        return sum % mod;
    }
} 
