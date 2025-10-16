import java.util.Arrays;

public class No1394 {
    public static void main(String[] args) {
        No1394 obj = new No1394();
        System.out.println(obj.findLucky(new int[]{2, 2, 3, 4}));
    }

    public int findLucky(int[] arr) {
        int[] cnt = new int[501];

        for (int a : arr) {
            cnt[a]++;
        }
//        System.out.println(Arrays.toString(cnt));

        for (int i = cnt.length - 1; i > 0; i--) {
            if (cnt[i] == i) {
                return i;
            }
        }
        return -1;
    }
}
