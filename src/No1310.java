import java.util.Arrays;

public class No1310 {
    public static void main(String[] args) {
        No1310 obj = new No1310();
        System.out.println(Arrays.toString(obj.xorQueries(new int[]{1, 3, 4, 8},
                new int[][]{
                        {0, 1},
                        {1, 2},
                        {0, 3},
                        {3, 3}
                })));
    }

    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] ans = new int[queries.length];
        int[] prefix = new int[arr.length];
        int temp = arr[0];
        prefix[0] = temp;
        for (int i = 1; i < arr.length; i++) {
            temp = temp ^ arr[i];
            prefix[i] = temp;
        }

        for (int i = 0; i < queries.length; i++) {
            int end = prefix[queries[i][1]];
            if (queries[i][0] - 1 >= 0) {
                int start = prefix[queries[i][0] - 1];
                ans[i] = end ^ start;
            } else {
                ans[i] = end;
            }
        }
        return ans;
    }
}
