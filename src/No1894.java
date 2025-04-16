public class No1894 {
    public static void main(String[] args) {
        No1894 obj = new No1894();
//        System.out.println(obj.chalkReplacer(new int[]{5, 1, 5}, 22));
        System.out.println(obj.chalkReplacer(new int[]{3, 4, 1, 2}, 25));

    }

    public int chalkReplacer(int[] chalk, int k) {
        int index = 0;
        long sum = 0;
        for (int num : chalk) {
            sum += num;
        }
        k = (int) (k % sum);
        if (k == 0) {
            return index;
        }

        for (int i = 0; i < chalk.length; i++) {
            k -= chalk[i];
            if (k < 0) {
                return index;
            }
            index++;
        }


        return index;
    }
}
