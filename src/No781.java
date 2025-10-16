import java.util.HashSet;
import java.util.Set;

public class No781 {
    public static void main(String[] args) {
        No781 obj = new No781();
//        System.out.println(obj.temp(3, 7));
        System.out.println(obj.numRabbits(new int[]{0, 0, 1, 1, 1}));
    }

    public int numRabbits(int[] answers) {
        int ans = 0;

        int[] arr = new int[1001];
        for (int num : answers) {
            arr[num]++;
        }

        for (int i = 0; i < arr.length; i++) {
            ans += temp(i, arr[i]);
        }

        return ans;
    }

    private int temp(int num, int cnt) {
        int ans = 0;
        return (int) (Math.ceil((double) cnt / (num + 1)) * (num + 1));
    }
}
