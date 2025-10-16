import java.util.ArrayList;
import java.util.List;

public class No3307 {

    public static void main(String[] args) {
        No3307 o = new No3307();
        System.out.println(o.kthCharacter(10, new int[]{0, 1, 0, 1}));
    }

    public char kthCharacter(long k, int[] operations) {
        k--;
        int index = operations.length;
        List<Integer> lt = new ArrayList<>();

        while (k > 0) {
            boolean temp = isIn(k, index);
            if (temp) {
                lt.add(index);
                k -= (long) Math.pow(2, index);
                System.out.println(k);
            }
            index--;
        }
        System.out.println(lt);
        int a = 'a';
        for (int i = lt.size() - 1; i >= 0; i--) {
            if (operations[lt.get(i)] == 1)
                a++;
            if (a > 'z') {
                a = 'a';
            }
        }

        return (char) a;
    }

    private boolean isIn(long n, long x) {
        return n >= (1L << x) && n < (1L << (x + 1));
    }


}
