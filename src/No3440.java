public class No3440 {
    public static void main(String[] args) {
        No3440 o = new No3440();
        System.out.println(o.maxFreeTime(10, new int[]{0, 7, 9}, new int[]{1, 8, 10}));
    }

    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int[] et = new int[n];
        int[] ft = new int[n + 1];


        int prev = 0;
        for (int i = 0; i < n; i++) {
            et[i] = endTime[i] - startTime[i];
            ft[i] = startTime[i] - prev;
            prev = endTime[i];
        }
        ft[n] = eventTime - prev;

        int[] ls = new int[n];
        int[] rs = new int[n];
        ls[0] = 0;
        for (int i = 1; i < n; i++) {
            ls[i] = Math.max(ls[i - 1], ft[i - 1]);
        }

        rs[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            rs[i] = Math.max(rs[i + 1], ft[i + 2]);
        }


        int max = 0;
        for (int i = 0; i < n; i++) {
            if (ls[i] >= et[i] || rs[i] >= et[i]) {
                max = Math.max(max, ft[i] + ft[i + 1] + et[i]);
            } else {
                max = Math.max(max, ft[i] + ft[i + 1]);
            }
        }


        return max;
    }
}
