public class No3021 {
    public static void main(String[] args) {
        No3021 o = new No3021();
        System.out.println(o.flowerGame(3, 2));
        System.out.println(o.flowerGame(1, 1));
    }

    public long flowerGame(int n, int m) {
        int evenCnt = 0;
        int oddCnt = 0;
        long ans = 0;
        for (int i = 1; i <= m; i++) {
            if (i % 2 == 0) {
                evenCnt++;
            } else {
                oddCnt++;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                ans += oddCnt;
            } else {
                ans += evenCnt;
            }
        }
        return ans;
    }
} 
