public class No3459 {
    public static void main(String[] args) {
        No3459 o = new No3459();
//        int[][] grid = new int[][]{
//                {2, 2, 1, 2, 2},
//                {2, 0, 2, 2, 0},
//                {2, 0, 1, 1, 0},
//                {1, 0, 2, 2, 2},
//                {2, 0, 0, 2, 2},
//        };
//        int[][] grid = new int[][]{
//                {0, 1, 0, 0, 0, 0, 0},
//                {2, 1, 1, 2, 1, 2, 2},
//                {1, 1, 1, 2, 2, 1, 0}
//        };//5
        int[][] grid = new int[][]{
                {1, 0, 0, 2},
                {0, 2, 2, 2},
                {0, 2, 1, 1},
                {2, 2, 0, 2},
                {0, 0, 1, 1},
                {1, 0, 2, 2}
        };//5
        System.out.println(o.lenOfVDiagonal(grid));
    }

    int[][] grid;

    public int lenOfVDiagonal(int[][] grid) {
        this.grid = grid;
        int max = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    for (int k = 1; k <= 4; k++) {
                        switch (k) {
                            case 1:
                                max = Math.max(max, 1 + rec(i - 1, j + 1, 1, k, false));
                                break;
                            case 2:
                                max = Math.max(max, 1 + rec(i + 1, j + 1, 1, k, false));
                                break;
                            case 3:
                                max = Math.max(max, 1 + rec(i + 1, j - 1, 1, k, false));
                                break;
                            case 4:
                                max = Math.max(max, 1 + rec(i - 1, j - 1, 1, k, false));
                                break;
                        }
                    }
                }
            }
        }

        return max;
    }

    public int rec(int i, int j, int prev, int direction, boolean turn) {
        if (i < 0 || j < 0 || i == grid.length || j == grid[0].length) {
            return 0;
        }
        switch (prev) {
            case 0:
            case 1:
                if (grid[i][j] != 2)
                    return 0;
                break;
            case 2:
                if (grid[i][j] != 0)
                    return 0;
                break;
        }

        int max = 0;
        int ifTurn = 0;
        int cur = grid[i][j];
        switch (direction) {
            case 1:
                max = 1 + rec(i - 1, j + 1, cur, direction, turn);
                if (!turn) {
                    ifTurn = 1 + rec(i + 1, j + 1, cur, 2, true);
                }
                if (ifTurn > max) {
                    max = ifTurn;
                }
                break;
            case 2:
                max = 1 + rec(i + 1, j + 1, cur, direction, turn);
                if (!turn) {
                    ifTurn = 1 + rec(i + 1, j - 1, cur, 3, true);
                }
                if (ifTurn > max) {
                    max = ifTurn;
                }
                break;
            case 3:
                max = 1 + rec(i + 1, j - 1, cur, direction, turn);
                if (!turn) {
                    ifTurn = 1 + rec(i - 1, j - 1, cur, 4, true);
                }
                if (ifTurn > max) {
                    max = ifTurn;
                }
                break;
            default:
                max = 1 + rec(i - 1, j - 1, cur, direction, turn);
                if (!turn) {
                    ifTurn = 1 + rec(i - 1, j + 1, cur, 1, true);
                }
                if (ifTurn > max) {
                    max = ifTurn;
                }
                break;
        }

        return max;
    }
} 
