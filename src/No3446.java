import java.util.*;

public class No3446 {
    public static void main(String[] args) {
        No3446 o = new No3446();
        System.out.println(Arrays.deepToString(o.sortMatrix(new int[][]{{1, 7, 3}, {9, 8, 2}, {4, 5, 6}})));
    }

    public int[][] sortMatrix(int[][] grid) {
        PriorityQueue<Integer> increasing = new PriorityQueue<>();
        PriorityQueue<Integer> decreasing = new PriorityQueue<>(Collections.reverseOrder());
        int r = grid.length;
        int c = grid[0].length;

        int iIndex = 0;
        int jIndex = 0;
        for (int i = 0; i < r + c - 1; i++) {
            if (jIndex == 0) { //bottom
                int iTemp = iIndex;
                int jTemp = jIndex;
                while (jTemp < c && iTemp < r) {
                    decreasing.add(grid[iTemp][jTemp]);
                    jTemp++;
                    iTemp++;
                }

                iTemp = iIndex;
                jTemp = jIndex;
                while (!decreasing.isEmpty()) {
                    grid[iTemp][jTemp] = decreasing.poll();
                    jTemp++;
                    iTemp++;
                }

                iIndex++;
                if (iIndex == r) {
                    iIndex = 0;
                    jIndex = c - 1;
                }
            } else { //top
                int iTemp = iIndex;
                int jTemp = jIndex;
                while (jTemp < c && iTemp < r) {
                    increasing.add(grid[iTemp][jTemp]);
                    jTemp++;
                    iTemp++;
                }

                iTemp = iIndex;
                jTemp = jIndex;
                while (!increasing.isEmpty()) {
                    grid[iTemp][jTemp] = increasing.poll();
                    jTemp++;
                    iTemp++;
                }

                jIndex--;
            }
        }
        return grid;
    }
} 
