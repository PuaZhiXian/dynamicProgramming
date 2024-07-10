public class No2582 {
    public static void main(String[] args) {
        System.out.println(passThePillow(4, 5));
        System.out.println(passThePillow(3, 2));
        System.out.println(passThePillow(9, 4));
        System.out.println(passThePillow(46, 1000));
    }

    public static int passThePillow(int n, int time) {
        int remainder = time % (n - 1);
        boolean fromFront = Math.ceil((double) time / (n - 1)) % 2 != 0;
        if (remainder == 0) {
            return fromFront ? n : 1;
        } else {
            return fromFront ? remainder + 1 : n - remainder;
        }
    }
}
