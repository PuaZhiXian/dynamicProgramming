import java.util.Arrays;

public class No498 {
    public static void main(String[] args) {
        No498 o = new No498();
        System.out.println(Arrays.toString(o.findDiagonalOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})));
//        System.out.println(Arrays.toString(o.findDiagonalOrder(new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}})));
//        System.out.println(Arrays.toString(o.findDiagonalOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}})));


    }

    public int[] findDiagonalOrder(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;
        int len = mat.length * mat[0].length;
        int[] ans = new int[len];
        int i = 0;
        int j = 0;

        int step = 1;
        int cornerFound = 0;
        boolean toDown = false;

        int index = 0;
        boolean toRight = true;
        while (index < len) {
            for (int k = 0; k < step; k++) {
                ans[index] = mat[i][j];
                if (i == r - 1 && j == 0) {
                    cornerFound++;
                }
                if (i == 0 && j == c - 1) {
                    cornerFound++;
                }
//                System.out.printf("i %s,  j %s\n", i, j);

                if (k != step - 1) {
                    if (toDown) {
                        i++;
                        j--;
                    } else {
                        i--;
                        j++;
                    }
                }
                index++;
            }

            if (toRight) {
                j++;
                if (j == c) {
                    j--;
                    i++;
                }
            } else {
                i++;
                if (i == r) {
                    i--;
                    j++;
                }
            }
//            System.out.println((toRight ? "moving to right " : "moving to down ") + String.format("[%s, %s]", i, j));


            toRight = !toRight;
            toDown = !toDown;
            if (cornerFound == 0) {
                step++;
            } else if (cornerFound == 2) {
                step--;
            }
//            System.out.println("cornerFound " + cornerFound);
        }
        return ans;
    }

} 
