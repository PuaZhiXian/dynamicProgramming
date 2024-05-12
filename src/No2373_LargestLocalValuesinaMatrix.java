import java.util.Arrays;

public class No2373_LargestLocalValuesinaMatrix {
    public static void main(String[] args) {
        int[][] n = {
                {9, 9, 8, 1}, {5, 6, 2, 6}, {8, 2, 6, 4}, {6, 2, 2, 2}
        };
        System.out.println(Arrays.deepToString(largestLocal(n)));
    }

    public static int[][] largestLocal(int[][] grid) {
        int[][] sumHori = new int[grid.length][grid[0].length - 2];
        for (int i = 0; i < sumHori.length; i++) {
            int index = 0;
            for (int j = 0; j < sumHori[i].length; j++) {
                sumHori[i][j] = Math.max(grid[i][index], Math.max(grid[i][index + 1], grid[i][index + 2]));
                index++;
            }
        }
        System.out.println(Arrays.deepToString(sumHori));
        int[][] result = new int[sumHori.length - 2][sumHori[0].length];
        int index = 0;
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = Math.max(sumHori[index][j], Math.max(sumHori[index + 1][j], sumHori[index + 2][j]));
            }
            index++;
        }
        return result;
    }
}