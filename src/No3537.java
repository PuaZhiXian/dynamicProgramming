import java.util.Arrays;

public class No3537 {

    public static void main(String[] args) {
        No3537 o = new No3537();
        System.out.println(Arrays.deepToString(o.specialGrid(2)));
    }

    int cnt = 0;
    int[][] step = new int[][]{{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
    int iIndex = 0;
    int jIndex = 0;

    public int[][] specialGrid(int n) {
        int p = (int) Math.pow(2, n);
        int[][] matrix = new int[p][p];
        iIndex = 0;
        jIndex = 3;

        for (int i = 0; i < step.length; i++) {
            if (i < 3) {
                rec(matrix);
            }
            iIndex += step[i][0];
            jIndex += step[i][1];
        }

        return matrix;
    }

    public void rec(int[][] matrix) {
        matrix[iIndex][jIndex] = cnt++;
        iIndex++;
        matrix[iIndex][jIndex] = cnt++;
        iIndex++;
        jIndex--;
        matrix[iIndex][jIndex] = cnt++;
        jIndex--;
        matrix[iIndex][jIndex] = cnt++;
    }
}
