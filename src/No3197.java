import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;


public class No3197 {

    Logger logger = LoggerFactory.getLogger(No3197.class);

    public static void main(String[] args) {
        No3197 o = new No3197();
        System.out.println(o.minimumSum(new int[][]{{1, 0, 1}, {1, 1, 1}}));
        System.out.println(o.minimumSum(new int[][]{{1, 0, 1, 0}, {0, 1, 0, 1}}));
    }

    int minTop; // 0
    int minBotton; //1
    int minRight; // 2
    int minLeft;//0
    int curMin = Integer.MAX_VALUE;
    boolean initSetup;

    public int minimumSum(int[][] grid) {
        initSetup = true;
        getArea(grid, 0, grid.length - 1, 0, grid[0].length - 1);

        patternA(grid);
        patternB(grid);
        patternC(grid);
        patternD(grid);
        patternE(grid);
        patternF(grid);

        return curMin;
    }

    /**
     * | |
     * | |
     */
    public void patternA(int[][] grid) {
        for (int i = minLeft; i <= minRight - 2; i++) {
            int firstV = getArea(grid, minTop, minBotton, minLeft, i);
//            System.out.printf("first [%s:%s] >> %s           ", minLeft, i, firstV);
            if (firstV >= curMin)
                continue;

            for (int j = i + 1; j <= minRight - 1; j++) {
                int secondV = getArea(grid, minTop, minBotton, i + 1, j);
//                System.out.printf("second [%s:%s] >> %s           ", i + 1, j, secondV);
                if (secondV >= curMin || secondV + firstV >= curMin)
                    continue;

                int thirdV = getArea(grid, minTop, minBotton, j + 1, minRight);
//                System.out.printf("third [%s:%s] >> %s           ", j + 1, minRight, thirdV);
                if (thirdV >= curMin) {
                    continue;
                }
                curMin = Math.min(curMin, firstV + secondV + thirdV);
            }
        }
    }

    /**
     * --
     * --
     */
    public void patternB(int[][] grid) {
        for (int i = minTop; i <= minBotton - 2; i++) {
            int firstH = getArea(grid, minTop, i, minLeft, minRight);
            System.out.printf("first [%s:%s] >> %s           ", minTop, i, firstH);
            if (firstH >= curMin) {
                continue;
            }

            for (int j = i + 1; j <= minBotton - 1; j++) {
                int secondH = getArea(grid, i + 1, j, minLeft, minRight);
                System.out.printf("second [%s:%s] >> %s           ", i + 1, j, secondH);
                if (secondH >= curMin || secondH + firstH >= curMin)
                    continue;

                int thirdH = getArea(grid, j + 1, minBotton, minLeft, minRight);
                System.out.printf("third [%s:%s] >> %s           ", j + 1, minBotton, thirdH);
                if (thirdH >= curMin)
                    continue;
                curMin = Math.min(curMin, firstH + secondH + thirdH);
            }
        }
    }

    /**
     * |
     * _
     */
    public void patternC(int[][] grid) {
        for (int i = minTop + 1; i <= minBotton; i++) {
            int btmA = getArea(grid, i, minBotton, minLeft, minRight);
//            System.out.printf("first [%s:%s] >> %s           ", i, minBotton, btmA);
            if (btmA >= curMin)
                continue;

            for (int j = minLeft; j <= minRight - 1; j++) {
                int topLeftA = getArea(grid, minTop, i - 1, minLeft, j);
//                System.out.printf("second [%s:%s] >> %s           ", minLeft, j, topLeftA);
                if (topLeftA >= curMin || topLeftA + btmA >= curMin)
                    continue;

                int topRightA = getArea(grid, minTop, i - 1, j + 1, minRight);
//                System.out.printf("third [%s:%s] >> %s          \n", j + 1, minRight, topRightA);
                if (topRightA >= curMin)
                    continue;

                curMin = Math.min(curMin, btmA + topRightA + topLeftA);
            }
        }
    }

    /**
     * -
     * |
     */
    public void patternD(int[][] grid) {
        for (int i = minTop; i <= minBotton - 1; i++) {
            int top = getArea(grid, minTop, i, minLeft, minRight);
            if (top >= curMin)
                continue;

            for (int j = minLeft; j <= minRight - 1; j++) {
                int btmLeft = getArea(grid, i + 1, minBotton, minLeft, j);
                if (btmLeft >= curMin || btmLeft + top >= curMin)
                    continue;

                int btmRight = getArea(grid, i + 1, minBotton, j + 1, minRight);
                if (btmRight >= curMin)
                    continue;

                curMin = Math.min(curMin, top + btmLeft + btmRight);
            }
        }
    }

    /**
     * | -
     */
    public void patternE(int[][] grid) {
        for (int i = minLeft; i <= minRight - 1; i++) {
            int left = getArea(grid, minTop, minBotton, minLeft, i);
            if (left >= curMin)
                continue;

            for (int j = minTop; j <= minBotton - 1; j++) {
                int rightTop = getArea(grid, minTop, j, i + 1, minRight);
                if (rightTop >= curMin || rightTop + left >= curMin)
                    continue;

                int rightBtm = getArea(grid, j + 1, minBotton, i + 1, minRight);
                if (rightBtm >= curMin)
                    continue;

                curMin = Math.min(curMin, left + rightTop + rightBtm);
            }
        }
    }

    /**
     * - |
     */
    public void patternF(int[][] grid) {
        for (int i = minLeft + 1; i <= minRight; i++) {
            int right = getArea(grid, minTop, minBotton, i, minRight);
            if (right >= curMin) {
                continue;
            }

            for (int j = minTop; j <= minBotton - 1; j++) {
                int leftTop = getArea(grid, minTop, j, minLeft, i - 1);
                if (leftTop >= curMin || leftTop + right >= curMin)
                    continue;

                int leftBtm = getArea(grid, j + 1, minBotton, minLeft, i - 1);
                if (leftBtm >= curMin)
                    continue;

                curMin = Math.min(curMin, right + leftTop + leftBtm);
            }
        }
    }

    public int getArea(int[][] grid, int startingTop, int startingBottom, int startingLeft, int startingRight) {
//        System.out.printf("t : %s, b : %s, l : %s , r : %s ", startingTop, startingBottom, startingLeft, startingRight);
        int ans = Integer.MAX_VALUE;

        int top = -1;
        int bottom = -1;
        int left = -1;
        int right = -1;

        for (int i = startingTop; i <= startingBottom; i++) {
            for (int j = startingLeft; j <= startingRight; j++) {
                if (grid[i][j] == 1) {
                    top = i;
                    break;
                }
            }
            if (top != -1)
                break;
        }
        if (top == -1)
            return ans;

        for (int i = startingBottom; i >= startingTop; i--) {
            for (int j = startingLeft; j <= startingRight; j++) {
                if (grid[i][j] == 1) {
                    bottom = i;
                    break;
                }
            }
            if (bottom != -1)
                break;
        }
        if (bottom == -1)
            return ans;

        for (int i = startingLeft; i <= startingRight; i++) {
            for (int j = startingTop; j <= startingBottom; j++) {
                if (grid[j][i] == 1) {
                    left = i;
                    break;
                }
            }
            if (left != -1)
                break;
        }
        if (left == -1)
            return ans;


        for (int i = startingRight; i >= startingLeft; i--) {
            for (int j = startingTop; j <= startingBottom; j++) {
                if (grid[j][i] == 1) {
                    right = i;
                    break;
                }
            }
            if (right != -1)
                break;
        }
        if (right == -1)
            return ans;


        if (initSetup) {
            minTop = top;
            minBotton = bottom;
            minLeft = left;
            minRight = right;
            initSetup = false;
        }

        return (bottom - top + 1) * (right - left + 1);
    }


} 
