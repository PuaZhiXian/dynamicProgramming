public class No2579 {
    public static void main(String[] args) {
        No2579 obj = new No2579();
//        obj.coloredCells(1);
//        obj.coloredCells(2);
//        obj.coloredCells(3);
        System.out.println(obj.coloredCells(4));
        obj.coloredCells(4);
    }

    public long coloredCells(int n) {
        if (n == 1) {
            return 1;
        }
        return (long) ((Math.pow(n, 2)) * 2 - ((2L * n) - 1));
    }
}
