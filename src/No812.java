public class No812 {
    public static void main(String[] args) {
        No812 o = new No812();
        System.out.println(o.largestTriangleArea(new int[][]{{0, 0}, {0, 1}, {1, 0}, {0, 2}, {2, 0}}));
    }

    public double largestTriangleArea(int[][] points) {
        double max = 0;
        for (int i = 0; i < points.length - 2; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            for (int j = i + 1; j < points.length - 1; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];
                for (int k = j + 1; k < points.length; k++) {
                    int x3 = points[k][0];
                    int y3 = points[k][1];
                    max = Math.max(max, getArea(x1, x2, x3, y1, y2, y3));
                }
            }
        }

        return max;
    }

    private double getArea(int x1, int x2, int x3, int y1, int y2, int y3) {
        double ans = 0.5 * (x1 * (y2 - y3) + (x2 * (y3 - y1)) + (x3 * (y1 - y2)));
        return Math.abs(ans);
    }
} 
