import java.util.ArrayList;
import java.util.List;

public class No1380 {
    public static void main(String[] args) {
        No1380 obj = new No1380();
//        System.out.println(obj.luckyNumbers(new int[][]{
//                {3, 7, 8},
//                {9, 11, 13},
//                {15, 16, 17}
//        }));

        System.out.println(obj.luckyNumbers(new int[][]{
                {56216}, {63251}, {75772}, {1945}, {27014}
        }));
    }


    public List<Integer> luckyNumbers(int[][] matrix) {
        int[] map = new int[matrix[0].length];
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            int rowMin = 100_0001;
            int index = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < rowMin) {
                    rowMin = matrix[i][j];
                    index = j;
                }
            }

            int colMax = 0;
            if (map[index] != 0) {
                colMax = map[index];
            } else {
                int max = 0;
                for (int[] ints : matrix) {
                    max = Math.max(max, ints[index]);
                }
                map[index] = max;
                colMax = max;
            }

            if (rowMin == colMax) {
                result.add(rowMin);
            }
        }
        return result;
    }

}
