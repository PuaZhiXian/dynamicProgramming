public class findTheKBeautyOfANumber {
    public static void main(String[] args) {
        findTheKBeautyOfANumber obj = new findTheKBeautyOfANumber();
        System.out.println(obj.divisorSubstrings(240, 2));
    }

    public int divisorSubstrings(int num, int k) {
        String numInString = String.valueOf(num);
        int l = numInString.length();
        int cnt = 0;
        for (int i = 0; i < l - k + 1; i++) {
            Integer sub = Integer.parseInt(numInString.substring(i, i + k));
            if (sub != 0 && num % sub == 0) {
                cnt++;
            }
        }
        return cnt;
    }
}
