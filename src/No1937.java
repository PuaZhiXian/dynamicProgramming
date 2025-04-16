public class No1937 {
    public static void main(String[] args) {
        No1937 obj = new No1937();

        System.out.println(obj.maxPoints(new int[][]{
                {1, 2, 3},
                {1, 5, 1},
                {3, 1, 1}
        }));
    }

    public long maxPoints(int[][] points) {
        long[] left = new long[points[0].length];
        long[] right = new long[points[0].length];

        long[][] clone = new long[points.length][points[0].length];
        for (int i = 0; i < clone[0].length; i++) {
            clone[0][i] = points[0][i];
        }

        for (int i = 0; i < clone.length - 1; i++) {

            for (int j = 0; j < left.length; j++) {
                if (j == 0) {
                    left[j] = clone[i][j];
                } else {
                    left[j] = Math.max(clone[i][j], left[j - 1] - 1);
                }
            }

            for (int j = right.length - 1; j >= 0; j--) {
                if (j == right.length - 1) {
                    right[j] = clone[i][j];
                } else {
                    right[j] = Math.max(clone[i][j], right[j + 1] - 1);
                }
            }

            for (int j = 0; j < clone[i].length; j++) {
                clone[i + 1][j] = points[i + 1][j] + Math.max(left[j], right[j]);
            }
        }

        long max = Integer.MIN_VALUE;
        for (int i = 0; i < clone[0].length; i++) {
            max = Math.max(clone[clone.length - 1][i], max);
        }
        return max;
    }
}
