import javafx.util.Pair;

import java.util.*;

public class No2661 {

    public static void main(String[] args) {
        No2661 obj = new No2661();
        System.out.println(obj.firstCompleteIndex(new int[]{2, 8, 7, 4, 1, 3, 5, 6, 9}, new int[][]{{3, 2, 5}, {1, 4, 6}, {8, 7, 9}}));
    }

    public int firstCompleteIndex(int[] arr, int[][] mat) {
        if (mat.length == 1 || mat[0].length == 1) {
            return 0;
        }

        int[] rows = new int[mat.length];
        int[] cols = new int[mat[0].length];

        int[][] nums = new int[arr.length][2];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                int val = mat[i][j] - 1;
                nums[val][0] = i;
                nums[val][1] = j;
            }
        }


        int step = -1;
        for (int i = 0; i < arr.length; i++) {
            int row = nums[arr[i] - 1][0];
            int col = nums[arr[i] - 1][1];

            rows[row]++;
            cols[col]++;
            step++;
            if (rows[row] == cols.length) {
                return step;
            }
            if (cols[col] == rows.length) {
                return step;
            }
        }

        return step;
    }
}
