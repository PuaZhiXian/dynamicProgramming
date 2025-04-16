import java.util.Arrays;

public class No3355 {
    public static void main(String[] args) {
        No3355 obj = new No3355();

//        System.out.println((obj.isZeroArray(new int[]{1, 0, 1}, new int[][]{{0, 2}})));//2
        System.out.println((obj.isZeroArray(new int[]{7, 6, 8}, new int[][]{{0, 0, 2}, {0, 1, 5}, {2, 2, 5}, {0, 2, 4}})));//4
    }

    public boolean isZeroArray(int[] nums, int[][] queries) {
        boolean ans = true;
        int[] diffArr = generateDiffArr(queries, nums.length);
        int[] a = new int[nums.length];
        a[0] = diffArr[0];
        for (int i = 1; i < diffArr.length - 1; i++) {
            a[i] = diffArr[i] + a[i - 1];
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > a[i]) {
                return false;
            }
        }


        return ans;
    }

    public int[] generateDiffArr(int[][] queries, int n) {
        int[] ans = new int[n + 1];

        for (int i = 0; i < queries.length; i++) {

            int l = queries[i][0];
            int r = queries[i][1];

            ans[l]++;
            ans[r + 1]--;
        }

        return ans;
    }
}
