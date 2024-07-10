public class No1701 {
    public static void main(String[] args) {
        System.out.println(averageWaitingTime(new int[][]{
                {1, 2},
                {2, 5},
                {4, 3}
        }));

        System.out.println(averageWaitingTime(new int[][]{
                {5, 2},
                {5, 4},
                {10, 3},
                {20, 1}
        }));
    }

    public static double averageWaitingTime(int[][] customers) {
        double result = 0;
        int cur = 1;
        for (int i = 0; i < customers.length; i++) {
            if (customers[i][0] < cur) {
                result = result + customers[i][1] + (cur - customers[i][0]);
                cur += customers[i][1];
            } else {
                result = result + customers[i][1];
                cur = customers[i][0] + customers[i][1];
            }
        }
        return result / customers.length;
    }
}
