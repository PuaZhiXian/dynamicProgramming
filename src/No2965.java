public class No2965 {
    public static void main(String[] args) {
        No2965 obj = new No2965();

    }

    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] ans = new int[2];
        int[] track = new int[grid.length * grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                track[grid[i][j] - 1]++;
            }
        }

        for (int i = 0; i < track.length; i++) {
            if (track[i] == 0) {
                ans[1] = i + 1;
            } else if (track[i] == 2) {
                ans[0] = i + 1;
            }

        }

        return ans;
    }
}
