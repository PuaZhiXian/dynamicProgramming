public class No1432 {
    public static void main(String[] args) {
        No1432 o = new No1432();
        System.out.println(o.maxDiff(123456));
    }

    public int maxDiff(int num) {
        String str = String.valueOf(num);
        int l = str.length();
        int max = num;
        int min = num;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                String s = str.replace(String.valueOf(i), String.valueOf(j));
                int n = Integer.parseInt(s);
                int ll = String.valueOf(n).length();

                max = (n == 0 || ll != l) ? max : Math.max(max, n);
                min = (n == 0 || ll != l) ? min : Math.min(min, n);
            }
        }

        return max - min;
    }
}
