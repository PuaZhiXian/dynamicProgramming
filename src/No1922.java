import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class No1922 {
    public static void main(String[] args) {
        No1922 obj = new No1922();
//        System.out.println(obj.countGoodNumbers(1));
//        System.out.println(obj.countGoodNumbers(2));
//        System.out.println(obj.countGoodNumbers(3));
        System.out.println(obj.countGoodNumbers(4));
//        System.out.println("1 : " + Math.pow(2, 1));
//        System.out.println("2 : " + Math.pow(2, 2));
//        System.out.println("3 : " + Math.pow(2, 3));
//        System.out.println("4 : " + Math.pow(2, 4));
//        System.out.println("5 : " + Math.pow(2, 5));
//        System.out.println("6 : " + Math.pow(2, 6));
//        System.out.println("7 : " + Math.pow(2, 7));
//        System.out.println("8 : " + Math.pow(2, 8));
//        System.out.println("9 : " + Math.pow(2, 9));
//        System.out.println("10 : " + Math.pow(2, 10));

//        System.out.println(obj.countGoodNumbers(10_00000_00000_00000L));
//        System.out.println(obj.countGoodNumbers(50)); //564908303
//        System.out.println(obj.countGoodNumbers(806166225460393L)); //643535977
//        System.out.println(obj.countGoodNumbers(4)); //400

//        System.out.println(obj.temp(2, 0));
//        System.out.println(obj.temp(2, 1));
//        System.out.println(obj.temp(2, 2));
//        System.out.println(obj.temp(2, 3));
//        403083112730196L

       /* System.out.println();
        //26
        long ans = 2;
        for (int i = 0; i < 26 - 1; i++) {
            ans *= 2 % obj.mod;
        }


        long ans2 = 10;
        for (int i = 0; i < 26 - 3; i++) {
            ans2 = (ans2 * 10) % obj.mod;
        }
        long ans3 = (ans2 * ans) % obj.mod;

        System.out.println("2 " + ans);
        System.out.println("10 " + ans2);
        System.out.println("2*10 " + ans3);
        System.out.println((ans3 * 5) % obj.mod);*/


    }

    long mod = 1000000007;

    public int countGoodNumbers(long n) {
        long oddCnt = n / 2; //4
        long evenCnt = n - n / 2; //5
        return (int) (rec(4, oddCnt) * rec(5, evenCnt) % mod);
    }

    private long rec(long a, long b) {

        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = (res * a) % mod;
            }
            a = (a * a) % mod;
            b >>= 1;
        }
        return res;
    }

}
