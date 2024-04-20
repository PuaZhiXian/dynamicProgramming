import java.util.Arrays;

/**
 * https://leetcode.com/problems/defuse-the-bomb/
 */
public class No1652_DefuseTheBomb {
    public static void main(String[] args) {
        No1652_DefuseTheBomb obj = new No1652_DefuseTheBomb();
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {5, 7, 1, 4};
        int[] arr3 = {2, 4, 9, 3};


        System.out.println(Arrays.toString(obj.decrypt(arr1, 0)));
        System.out.println(Arrays.toString(obj.decrypt(arr2, 3)));
        System.out.println(Arrays.toString(obj.decrypt(arr3, -2)));


    }

    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        if (k == 0) {
            return new int[n];
        } else if (k > 0) {
            int[] result = new int[n];
            for (int i = 0; i < k; i++) {
                result[0] += code[i + 1];
            }
            for (int i = 1; i < n; i++) {
                result[i] = result[i - 1] + circle(code, i + k) - code[i];
            }
            return result;
        } else {
            int[] result = new int[n];
            for (int i = 0; i < Math.abs(k); i++) {
                result[n - 1] += code[n - i - 2];
            }
            for (int i = n - 2; i >= 0; i--) {
                result[i] = result[i + 1] + circle(code, i - Math.abs(k)) - code[i];
            }
            return result;
        }
    }

    public int circle(int[] code, int index) {

        if (index > code.length - 1) {
            return code[index - code.length];
        } else if (index < 0) {
            return code[code.length - Math.abs(index)];
        } else {
            return code[index];
        }
    }
}
