import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class No342 {

    public static void main(String[] args) {
        No342 o = new No342();
        System.out.println(o.isPowerOfFour(16));
    }

    public boolean isPowerOfFour(int n) {
        int[] possible = new int[]{1, 4, 16, 64, 256, 1024, 4096, 16384, 65536, 262144, 1048576, 4194304, 16777216, 67108864, 268435456, 1073741824};

        for (int j : possible) {
            if (j == n) {
                return true;
            }
        }
        return false;
    }
}
