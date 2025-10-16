public class No3195 {
    public static void main(String[] args) {
        No3195 o = new No3195();
        System.out.println(o.minimumArea(new int[][]{{0, 1, 0}, {1, 0, 1}}));
    }

    public int minimumArea(int[][] grid) {

        int top = getTop(grid);
        int bottom = getBottom(grid);
        int left = getLeft(grid);
        int right = getRight(grid);

        return (bottom - top + 1) * (right - left + 1);
    }

    private int getTop(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return i;
                }
            }
        }
        return -1;
    }

    private int getBottom(int[][] grid) {
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return i;
                }
            }
        }
        return -1;
    }

    private int getLeft(int[][] grid) {
        for (int i = 0; i < grid[0].length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[j][i] == 1) {
                    return i;
                }
            }
        }
        return -1;
    }

    private int getRight(int[][] grid) {
        for (int i = grid[0].length - 1; i >= 0; i--) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[j][i] == 1) {
                    return i;
                }
            }
        }
        return -1;
    }


} 
