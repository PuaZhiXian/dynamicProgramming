import java.util.Arrays;

public class No1460 {
    public static void main(String[] args) {
        No1460 obj = new No1460();
        System.out.println(obj.canBeEqual(new int[]{1, 2, 3, 4}, new int[]{2, 4, 1, 3}));
    }

    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);

        for (int i = 0; i < target.length; i++) {
            if (target[i] != arr[i]) {
                return false;
            }
        }
        return true;
    }
}
