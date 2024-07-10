public class No1550 {
    public static void main(String[] args) {
        System.out.println(threeConsecutiveOdds(new int[]{2, 6, 4, 1}));
        System.out.println(threeConsecutiveOdds(new int[]{1, 2, 34, 3, 4, 5, 7, 23, 12}));
    }

    public static boolean threeConsecutiveOdds(int[] arr) {
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                cnt++;
                if (cnt == 3) {
                    return true;
                }
            } else {
                cnt = 0;
            }

        }
        return false;
    }
}
