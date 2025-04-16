public class No3356 {
    public static void main(String[] args) {
        No3356 obj = new No3356();
//        System.out.println(obj.minZeroArray(new int[]{2, 0, 2}, new int[][]{{0, 2, 1}, {0, 2, 1}, {1, 1, 3}}));//2
        System.out.println(obj.minZeroArray(new int[]{7, 6, 8}, new int[][]{{0, 0, 2}, {0, 1, 5}, {2, 2, 5}, {0, 2, 4}}));//4

    }

    public int minZeroArray(int[] nums, int[][] queries) {
        int left = 0;
        int right = queries.length ;

        int min = Integer.MAX_VALUE;

        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;

            boolean b = isZeroArray(nums, queries, mid);
            System.out.println("left " + left + " right " + right + " mid " + mid + " b " + b);

            if (b) {
                right = mid - 1;
                min = mid;
            } else {
                left = mid + 1;
            }
//            System.out.println("left " + left + " right " + right);

        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public boolean isZeroArray(int[] nums, int[][] queries, int until) {
        boolean ans = true;
        int[] diffArr = generateDiffArr(queries, nums.length, until);
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

    public int[] generateDiffArr(int[][] queries, int n, int until) {
        int[] ans = new int[n + 1];

        for (int i = 0; i < until; i++) {

            int l = queries[i][0];
            int r = queries[i][1];
            int v = queries[i][2];

            ans[l] = ans[l] + v;
            ans[r + 1] = ans[r + 1] - v;
        }

        return ans;
    }

}
