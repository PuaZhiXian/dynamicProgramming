public class No1497 {
    public static void main(String[] args) {
        No1497 obj = new No1497();
        System.out.println(obj.canArrange(new int[]{1, 2, 3, 4, 5, 6}, 7));
    }

    public boolean canArrange(int[] arr, int k) {
        int[] cnt = new int[10_00000];
        for (int i = 0; i < arr.length; i++) {
            cnt[((arr[i] % k) + k) % k]++;
        }
        if (cnt[0] % 2 != 0) {
            return false;
        }

        for (int i = 1; i < Math.min(cnt.length / 2, k/2); i++) {
            if (cnt[i] != cnt[k - i]) {
                System.out.printf("comparing %s : %s\n", i, k - i);
                return false;
            }

        }
        return true;
    }
}
