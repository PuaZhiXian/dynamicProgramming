public class No326 {
    public static void main(String[] args) {
        No326 o = new No326();
//        System.out.println(Math.pow(3, 20));
        System.out.println(o.isPowerOfThree(1162261467));
    }

    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }

        for (int i = 0; i < 50; i++) {
            int temp = (int) Math.pow(3, i);
            if (temp == n) {
                System.out.println(i);
                return true;
            }
        }


        return false;
    }

}
