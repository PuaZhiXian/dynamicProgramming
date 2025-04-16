public class No2999 {
    public static void main(String[] args) {
        No2999 o = new No2999();
        System.out.println(o.numberOfPowerfulInt(123546, 32486458654L, 4, "1"));
    }

    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        if (finish < Long.parseLong(s)) {
            return 0;
        }
        return temp(finish + "", limit, Long.parseLong(s), 0, true) - temp((start - 1) + "", limit, Long.parseLong(s), 0, true);
    }

    private long temp(String finish, long limit, long s, int index, boolean prev) {
        if (Long.parseLong(finish) < s) {
            return 0;
        }
        if (finish.length() - index == (s + "").length()) {
            long end = Long.parseLong(finish.substring(index));
            if (prev) {
                return end >= s ? 1 : 0;
            } else {
                return 1;
            }
        }
        int cur = Integer.parseInt(finish.substring(index, index + 1));
        long ans = 0;
        if (prev) {
            if (cur > limit) {
                ans = (limit + 1) * temp(finish, limit, s, index + 1, false);
            } else {
                long allPart = cur * temp(finish, limit, s, index + 1, false);
                long partialPart = temp(finish, limit, s, index + 1, true);
                ans = allPart + partialPart;
            }
        } else {
            ans = (limit + 1) * temp(finish, limit, s, index + 1, false);
        }

        return ans;
    }


}
