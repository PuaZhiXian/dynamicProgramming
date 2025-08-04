import com.sun.xml.internal.ws.util.StringUtils;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class No2081 {
    public static void main(String[] args) {
        No2081 o = new No2081();
//        System.out.println(o.kMirror(2, 5));
//        System.out.println(o.kMirror(3, 7));
//        System.out.println(o.kMirror(7, 17));
        System.out.println(o.kMirror(4, 30));//53393239260
    }

    long sum = 0;
    int n;
    int k;

    public long kMirror(int k, int n) {
        this.n = n;
        this.k = k;
        int start = 1;
        int end = 10;

        for (int i = 0; i < 7; i++) {
            if (this.n == 0) {
                return sum;
            }
            helper(start, end);
            start *= 10;
            end *= 10;
        }

        return sum;
    }

    private void helper(int start, int end) {
        //ODD
        for (int i = start; i < end; i++) {
            String front = String.valueOf(i);
            StringBuilder back = new StringBuilder(String.valueOf(i).substring(0, front.length() - 1)).reverse();

            try {
                long base10 = Long.parseLong(front + back);
                String baseK = Long.toString(base10, k);
                isPalindrome(String.valueOf(base10));
                isPalindrome(baseK);

                sum += base10;
//                System.out.println("Adding " + base10);
                n--;
                if (n == 0) {
                    return;
                }
            } catch (Exception e) {
                if (!"no isPalindrome".equals(e.getMessage())) {
                    System.out.println(e.getMessage());
                }
            }

        }
        //EVEN
        for (int i = start; i < end; i++) {
            String front = String.valueOf(i);
            StringBuilder back = new StringBuilder(String.valueOf(i)).reverse();
            try {
                long base10 = Long.parseLong(front + back);
                String baseK = Long.toString(base10, k);
                isPalindrome(String.valueOf(base10));
                isPalindrome(baseK);
                sum += base10;
//                System.out.println("Adding " + base10);
                n--;
                if (n == 0) {
                    return;
                }
            } catch (Exception e) {
                if (!"no isPalindrome".equals(e.getMessage())) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public static void isPalindrome(String input) {
        if (input == null) {
            throw new RuntimeException("no isPalindrome");
        }
        int left = 0;
        int right = input.length() - 1;

        while (left < right) {
            if (input.charAt(left) != input.charAt(right)) {
                throw new RuntimeException("no isPalindrome");
            }
            left++;
            right--;
        }
    }
}


/**
 *         //LEN 1
 * //        for (int i = 1; i < 10; i++) {
 * //            String front = String.valueOf(i);
 * //            StringBuilder back = new StringBuilder(String.valueOf(i).substring(0, front.length() - 1)).reverse();
 * ////            System.out.println("front " + front +" back " + back);
 * //            System.out.println("generated num : " + (front + back));
 * //        }
 * ////        LEN 2
 * //        for (int i = 1; i < 10; i++) {
 * //            String front = String.valueOf(i);
 * //            StringBuilder back = new StringBuilder(String.valueOf(i)).reverse();
 * ////            System.out.println("front " + front +" back " + back);
 * //            System.out.println("generated num : " + (front + back));
 * //        }
 *
 *
 * //        //LEN 3
 * //        for (int i = 10; i < 100; i++) {
 * //            String front = String.valueOf(i);
 * //        StringBuilder back = new StringBuilder(String.valueOf(i).substring(0, front.length() - 1)).reverse();
 * ////            System.out.println("front " + front +" back " + back);
 * //            System.out.println("generated num : " + (front + back));
 * //        }
 * ////        LEN 4
 * //        for (int i = 10; i < 100; i++) {
 * //            String front = String.valueOf(i);
 * //            StringBuilder back = new StringBuilder(String.valueOf(i)).reverse();
 * ////            System.out.println("front " + front +" back " + back);
 * //            System.out.println("generated num : " + (front + back));
 * //        }
 *
 *         //LEN 5
 * //        for (int i = 100; i < 1000; i++) {
 * //            String front = String.valueOf(i);
 * //        StringBuilder back = new StringBuilder(String.valueOf(i).substring(0, front.length() - 1)).reverse();
 * ////            System.out.println("front " + front +" back " + back);
 * //            System.out.println("generated num : " + (front + back));
 * //        }
 *         //LEN 6
 * //        for (int i = 100; i < 1000; i++) {
 * //            String front = String.valueOf(i);
 * //            StringBuilder back = new StringBuilder(String.valueOf(i)).reverse();
 * ////            System.out.println("front " + front +" back " + back);
 * //            System.out.println("generated num : " + (front + back));
 * //        }
 *         //LEN 7
 * //        for (int i = 1000; i < 10000; i++) {
 * //            String front = String.valueOf(i);
 * //            StringBuilder back = new StringBuilder(String.valueOf(i).substring(0, front.length() - 1)).reverse();
 * ////            System.out.println("front " + front + " back " + back);
 * //            System.out.println("generated num : " + (front + back));
 * //            isPalindrome(front + back);
 * //        }
 * ////        LEN 8
 * //        for (int i = 1000; i < 10000; i++) {
 * //            String front = String.valueOf(i);
 * //            StringBuilder back = new StringBuilder(String.valueOf(i)).reverse();
 * ////            System.out.println("front " + front +" back " + back);
 * //            System.out.println("generated num : " + (front + back));
 * //            isPalindrome(front + back);
 * //        }
 * //        //LEN 9
 * //        for (int i = 10000; i < 100000; i++) {
 * //            String front = String.valueOf(i);
 * //            StringBuilder back = new StringBuilder(String.valueOf(i).substring(0, front.length() - 1)).reverse();
 * //            System.out.println("generated num : " + (front + back));
 * //            isPalindrome(front + back);
 * //        }
 * ////        LEN 10
 * //        for (int i = 10000; i < 100000; i++) {
 * //            String front = String.valueOf(i);
 * //            StringBuilder back = new StringBuilder(String.valueOf(i)).reverse();
 * //            System.out.println("generated num : " + (front + back));
 * //            isPalindrome(front + back);
 * //        }
 */
