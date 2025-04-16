import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class No2657 {
    public static void main(String[] args) {
        No2657 obj = new No2657();
        int[] A = {1, 3, 2, 4};
        int[] B = {3, 1, 2, 4};
        System.out.println(Arrays.toString(obj.findThePrefixCommonArray(A, B)));
    }

    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] c = new int[A.length];
        Set<Integer> set = new HashSet<>();

        int cnt = 0;
        for (int i = 0; i < A.length; i++) {
            if (set.contains(A[i])) {
                cnt++;
            }
            set.add(A[i]);
            if (set.contains(B[i])) {
                cnt++;
            }
            set.add(B[i]);
            c[i] = cnt;
        }
        return c;
    }
}
