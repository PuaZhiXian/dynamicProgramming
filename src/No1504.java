import java.util.Arrays;

public class No1504 {
    public static void main(String[] args) {
        No1504 o = new No1504();
        System.out.println(o.numSubmat(new int[][]{{1, 0, 1}, {1, 1, 0}, {1, 1, 0}})); //13
        System.out.println(o.numSubmat(new int[][]{{1, 1, 1, 1, 1, 1}})); //21
        System.out.println(o.numSubmat(new int[][]{{0, 1, 1, 0}, {0, 1, 1, 1}, {1, 1, 1, 0}})); //24
        System.out.println(o.numSubmat(new int[][]{{0, 1}, {1, 1,}, {1, 0}})); //7

    }


    public int numSubmat(int[][] mat) {
        int ans = 0;
        int r = mat.length;
        int c = mat[0].length;
        int[] heightStack = new int[c];
        int[] possibleMatPerCol;

        for (int i = 0; i < r; i++) {
            possibleMatPerCol = new int[c];

            for (int j = 0; j < c; j++) {
                if (mat[i][j] == 1) {
                    heightStack[j]++;
                } else {
                    heightStack[j] = 0;
                }
            }

            for (int j = 0; j < c; j++) {
                if (heightStack[j] == 0) {
                    continue;
                }
                int gap = 0;
                for (int k = j; k >= 0; k--) {
                    if (heightStack[j] <= heightStack[k]) {
                        gap++;
                    } else {
                        break;
                    }
                }


                int curCol = (gap * heightStack[j]);
                if (j - gap >= 0) {
                    curCol += possibleMatPerCol[j - gap];
                }
                possibleMatPerCol[j] = curCol;
                ans += curCol;
            }
            System.out.println("heigh >>> " + Arrays.toString(heightStack));
            System.out.println("possible >> " + Arrays.toString(possibleMatPerCol));
        }


        return ans;
    }
}
