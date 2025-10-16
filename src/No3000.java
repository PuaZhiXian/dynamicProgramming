public class No3000 {
    public static void main(String[] args) {
        No3000 o = new No3000();
    }

    public int areaOfMaxDiagonal(int[][] dimensions) {

        int ans = 0;
        double max = 0;
        for (int i = 0; i < dimensions.length; i++) {
            double dia = Math.sqrt(dimensions[i][0] * dimensions[i][0] + dimensions[i][1] * dimensions[i][1]);
            if (dia > max) {
                ans = dimensions[i][0] * dimensions[i][1];
                max = dia;
            } else if (dia == max) {
                ans = Math.max(ans, dimensions[i][0] * dimensions[i][1]);
            }
        }


        return ans;
    }
} 
