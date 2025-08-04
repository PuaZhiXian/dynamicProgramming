import java.util.Arrays;

public class No73 {
    public static void main(String[] args) {
        No73 obj = new No73();
        obj.setZeroes(new int[][]{{-4, -2147483648, 6, -7, 0}, {-8, 6, -8, -6, 0}, {2147483647, 2, -9, -6, -10}});
    }

    public void setZeroes(int[][] matrix) {

        boolean firstRow = false;
        boolean firstCol = false;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;

                    if (i == 0) {
                        firstRow = true;
                    }
                    if (j == 0) {
                        firstCol = true;
                    }
                }
            }
        }
//        System.out.println(Arrays.deepToString(matrix));

        for (int i = Math.max(matrix.length, matrix[0].length) - 1; i >= 0; i--) {
            if (i == 0) {
                if (firstCol) {
                    if (i < matrix[0].length && matrix[0][i] == 0) {
                        for (int j = 0; j < matrix.length; j++) {
                            matrix[j][i] = 0;
                        }
                    }
                }

                if (firstRow) {
                    for (int j = 0; j < matrix[0].length; j++) {
                        matrix[i][j] = 0;
                    }
                }

            } else {
                if (i < matrix[0].length && matrix[0][i] == 0) {
                    for (int j = 0; j < matrix.length; j++) {
                        matrix[j][i] = 0;
                    }
                }

                if (i < matrix.length && matrix[i][0] == 0) {
                    for (int j = 0; j < matrix[0].length; j++) {
                        matrix[i][j] = 0;
                    }
                }
            }

        }

//        System.out.println(Arrays.deepToString(matrix));
    }
}
