public class No2594 {

    public static void main(String[] args) {
        No2594 obj = new No2594();
        System.out.println(obj.repairCars(new int[]{4, 3, 2, 1}, 10));
    }

    public long repairCars(int[] ranks, int cars) {
        long ans = 0;
        long low = 0;
        long high = 0;

        System.out.println(can(ranks, cars, 16));

        for (int i = 0; i < ranks.length; i++) {
            high = Math.max(high, ranks[i]);
        }
        high = high * cars * cars;

        long mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (can(ranks, cars, mid)) {
                high = mid - 1;
                ans = mid;
            } else {
                low = mid + 1;
            }
        }


        return ans;
    }

    private boolean can(int[] ranks, int cars, long time) {

        for (int i = 0; i < ranks.length; i++) {
            cars -= (int) Math.sqrt(time / ranks[i]);
            if (cars <= 0) {
                return true;
            }
        }

        return false;

    }

}
