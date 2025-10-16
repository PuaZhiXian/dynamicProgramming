public class No3201 {
    public static void main(String[] args) {
        No3201 o = new No3201();
        System.out.println(o.maximumLength(new int[]{1, 2, 1, 1, 2, 1, 2}));
    }

    public int maximumLength(int[] nums) {
        int max = 0;
        int[] ans = new int[4];
// even, odd, even odd, odd even
        int evenFirst = 0;
        int oddFirst = 1;
        for (int n : nums) {
            if (n % 2 == 0) {
                ans[0]++;
            }
            if (n % 2 != 0) {
                ans[1]++;
            }
            if (n % 2 == evenFirst) {
                ans[2]++;
                evenFirst++;
                evenFirst %= 2;
            }
            if (n % 2 == oddFirst) {
                ans[3]++;
                oddFirst++;
                oddFirst %= 2;
            }
        }


        for (int n : ans) {
            max = Math.max(n, max);
        }

        return max;
    }
}
