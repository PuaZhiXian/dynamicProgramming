import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class No1267 {
    public static void main(String[] args) {
        No1267 obj = new No1267();
    }

    public int countServers(int[][] grid) {
        int ans = 0;
        int rowLength = grid.length;
        int colLength = grid[0].length;

        int[] row = new int[rowLength];
        int[] col = new int[colLength];

        int[] rowTrack = new int[rowLength * colLength];
        int[] colTrack = new int[rowLength * colLength];
        int track = 0;


        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (grid[i][j] == 1) {
                    row[i]++;
                    col[j]++;
                    if (Math.max(row[i], col[j]) > 1) {
                        ans++;
                    } else {
                        rowTrack[track] = i;
                        colTrack[track] = j;
                        track++;
                    }
                }
            }
        }

        for (int k = track-1; k >= 0; k--) {
            int i = rowTrack[k];
            int j = colTrack[k];

            if (Math.max(row[i], col[j]) > 1) {
                ans++;
            }
        }
        return ans;
    }

}
