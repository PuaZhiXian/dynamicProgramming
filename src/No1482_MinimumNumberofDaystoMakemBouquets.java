public class No1482_MinimumNumberofDaystoMakemBouquets {
    public static void main(String[] args) {
        System.out.println(minDays(new int[]{1, 10, 3, 10, 2}, 3, 1));
        System.out.println(minDays(new int[]{1, 10, 3, 10, 2}, 3, 2));
        System.out.println(minDays(new int[]{7, 7, 7, 7, 12, 7, 7}, 2, 3));
    }

    public static String get(String get) {


        return get;
    }

    public static int minDays(int[] bloomDay, int m, int k) {
        int result = -1;
        if (m * k > bloomDay.length) {
            return -1;
        }

        long min = 1;
        long max = 10000000000L;
        while (min < max) {
            long mid = (max + min) / 2;
            boolean able = able(bloomDay, mid, k, m);
            if (able) {
                result = (int) mid;
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return result;
    }

    public static boolean able(int[] bloomDay, long day, int k, int m) {
        int result = 0;
        int cont = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= day) {
                cont++;
            } else {
                cont = 0;
            }
            if (cont == k) {
                result++;
                cont = 0;
            }
            if (result == m) {
                return true;
            }
        }
        return false;
    }
}
