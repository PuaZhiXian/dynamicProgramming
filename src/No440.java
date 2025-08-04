public class No440 {
    public static void main(String[] args) {
        No440 o = new No440();
        System.out.println(o.findKthNumber(13, 2));
    }
    int limit = 0;

    public int findKthNumber(int n, int k) {
        k--;
        limit = n;
        long cur = 1;

        while (k > 0) {
            int cnt = getCnt(cur);
            if (k >= cnt) {
                k -= cnt;
                cur++;
            } else {
                k--;
                cur *= 10;
            }
        }
        return (int) cur;
    }

    private int getCnt(long cur) {
        long next = cur + 1;
        long cnt = 0;
        while (cur <= limit) {
            cnt += Math.min(limit - cur + 1, next - cur);

            next *= 10;
            cur *= 10;
        }

        return (int) cnt;
    }
}
