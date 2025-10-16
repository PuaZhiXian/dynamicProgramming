public class No1128 {

    public static void main(String[] args) {
        No1128 obj = new No1128();
        System.out.println(obj.numEquivDominoPairs(new int[][]{{1, 2}, {1, 2}, {1, 1}, {1, 2}, {2, 2}}));
    }

    public int numEquivDominoPairs(int[][] dominoes) {
        int[][] matrix = new int[9][9];
        int cnt = 0;

        for (int i = 0; i < dominoes.length; i++) {
            int max = Math.max(dominoes[i][0] - 1, dominoes[i][1] - 1);
            int min = Math.min(dominoes[i][0] - 1, dominoes[i][1] - 1);
            matrix[max][min]++;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] > 1) {
                    cnt += factorial(matrix[i][j]);
//                    System.out.println(cnt);
                }
            }
        }

        return cnt;
    }

    public static int factorial(int n) {
        int result = 0;
        for (int i = 1; i < n; i++) {
            result += i;
        }
        return result;
    }
}
