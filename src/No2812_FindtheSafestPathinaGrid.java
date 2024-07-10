import javafx.util.Pair;

import java.util.*;

public class No2812_FindtheSafestPathinaGrid {
    public static void main(String[] args) {
        List<List<Integer>> matrix = new ArrayList<>();

        // Initialize the inner lists and add them to the outer list
        matrix.add(Arrays.asList(0, 0, 0, 1));
        matrix.add(Arrays.asList(0, 0, 0, 0));
        matrix.add(Arrays.asList(0, 0, 0, 0));
        matrix.add(Arrays.asList(1, 0, 0, 0));


        List<List<Integer>> matrix2 = new ArrayList<>();

        // Initialize the inner lists and add them to the outer list
        matrix2.add(Arrays.asList(1, 0, 0));
        matrix2.add(Arrays.asList(0, 0, 0));
        matrix2.add(Arrays.asList(0, 0, 1));

        List<List<Integer>> matrix3 = new ArrayList<>();

        // Initialize the inner lists and add them to the outer list
        matrix3.add(Arrays.asList(1, 1, 1));
        matrix3.add(Arrays.asList(1, 0, 1));
        matrix3.add(Arrays.asList(0, 0, 1));

        System.out.println(maximumSafenessFactor(matrix3));
    }

    public static int maximumSafenessFactor(List<List<Integer>> grid) {
        if (grid.size() == 1 && grid.get(0).size() == 1) {
            return 0;
        }
        int[][] matrix = new int[grid.size()][grid.get(0).size()];
        Arrays.stream(matrix).forEach(row -> Arrays.fill(row, Integer.MAX_VALUE));
        int[] directionX = {0, 1, 0, -1};
        int[] directionY = {1, 0, -1, 0};

        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.get(i).size(); j++) {
                if (grid.get(i).get(j) == 1) {
                    matrix[i][j] = 0;
                    queue.add(new Pair<>(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> pair = queue.poll();
            int x = pair.getKey();
            int y = pair.getValue();

            for (int i = 0; i < directionX.length; i++) {
                int newX = x + directionX[i];
                int newY = y + directionY[i];
                int val = matrix[x][y];
                if (newX >= 0 && newX < matrix.length && newY >= 0 && newY < matrix[0].length && matrix[newX][newY] > 1 + val) {
                    matrix[newX][newY] = 1 + val;
                    queue.add(new Pair<>(newX, newY));
                }
            }
        }
        System.out.println(Arrays.deepToString(matrix));
        int startingX = 0;
        int startingY = 0;
        int[][] visited = new int[matrix.length][matrix[0].length];
        int min = Integer.MAX_VALUE;
        while (startingX != matrix.length - 1 || startingY != matrix[0].length - 1) {
            int max = Integer.MIN_VALUE;
            int nextX = -1;
            int nextY = -1;

            for (int i = 0; i < directionX.length; i++) {
                int newX = startingX + directionX[i];
                int newY = startingY + directionY[i];
                if (newX >= 0 && newX < matrix.length && newY >= 0 && newY < matrix[0].length && visited[newX][newY] <= 0) {
                    if (matrix[newX][newY] >= 0) {
                        visited[newX][newY] = 1;
                        if (matrix[newX][newY] > max) {
                            max = matrix[newX][newY];
                            nextX = newX;
                            nextY = newY;
                        }
                    }
                }
            }
            startingX = nextX;
            startingY = nextY;
            System.out.println(startingX + " " + startingY);
            min = Math.min(min, max);
        }
        return min;
//        return 0;
    }
}
