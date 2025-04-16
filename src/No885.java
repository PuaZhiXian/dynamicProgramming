import java.util.Arrays;

public class No885 {
    public static void main(String[] args) {
        No885 obj = new No885();

        System.out.println(Arrays.deepToString(obj.spiralMatrixIII(3, 4, 1, 2)));
    }

    int pointer = 1;

    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] ans = new int[rows * cols][2];
        ans[0] = new int[]{rStart, cStart};

        int rCur = rStart;
        int cCur = cStart;
        int index = 1;
        while (pointer < (rows * cols)) {
            rightToLeft(rows, cols, rCur, cCur, index, ans);
            cCur = cCur + index;

            topToBottom(rows, cols, rCur, cCur, index, ans);
            rCur = rCur + index;

            index++;
            leftToRight(rows, cols, rCur, cCur, index, ans);
            cCur = cCur - index;

            bottomToTop(rows, cols, rCur, cCur, index, ans);
            rCur = rCur - index;

            index++;
        }


        return ans;
    }

    //x static
    public void rightToLeft(int rows, int cols, int rStart, int cStart, int index, int[][] ans) {
        for (int i = 1; i <= index; i++) {
            if (pointer == rows * cols) {
                return;
            }
            if (cStart + i >= cols || rStart < 0 || rStart >= rows || cStart + i < 0) {
                continue;
            }
            ans[pointer] = new int[]{rStart, cStart + i};
            pointer++;
        }
    }

    //y static
    public void topToBottom(int rows, int cols, int rStart, int cStart, int index, int[][] ans) {
        for (int i = 1; i <= index; i++) {
            if (pointer == rows * cols) {
                return;
            }
            if (rStart + i >= rows || rStart + i < 0 || cStart < 0 || cStart >= cols) {
                continue;
            }
            ans[pointer] = new int[]{rStart + i, cStart};
            pointer++;
        }
    }

    //x static
    public void leftToRight(int rows, int cols, int rStart, int cStart, int index, int[][] ans) {
        for (int i = 1; i <= index; i++) {
            if (pointer == rows * cols) {
                return;
            }
            if (cStart - i < 0 || rStart < 0 || rStart >= rows || cStart - i >= cols) {
                continue;
            }
            ans[pointer] = new int[]{rStart, cStart - i};
            pointer++;
        }
    }

    //y static
    public void bottomToTop(int rows, int cols, int rStart, int cStart, int index, int[][] ans) {
        for (int i = 1; i <= index; i++) {
            if (pointer == rows * cols) {
                return;
            }
            if (rStart - i < 0 || rStart - i >= rows || cStart < 0 || cStart >= cols) {
                continue;
            }
            ans[pointer] = new int[]{rStart - i, cStart};
            pointer++;
        }
    }

}
