public class No64 {
    public static void main(String[] args) {
        No64 obj = new No64();
        System.out.println(obj.minPathSum(new int[][]{
                {1, 3, 1}, {1, 5, 1}, {4, 2, 1}
        }));

    }

    public int minPathSum(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (j > 0 && i > 0) {
                    // check left
                    grid[i][j] = grid[i][j] + Math.min(grid[i - 1][j], grid[i][j - 1]);
                } else {
                    if (i > 0) {
                        //check top
                        grid[i][j] += grid[i - 1][j];
                    }
                    if (j > 0) {
                        // check left
                        grid[i][j] += grid[i][j - 1];
                    }
                }
            }
        }

        return grid[grid.length - 1][grid[0].length - 1];
    }
}
