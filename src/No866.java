public class No866 {
    public static void main(String[] args) {
        No866 o = new No866();
        System.out.println(o.primePalindrome(10502));
    }

    int n;

    public int primePalindrome(int n) {
        this.n = n;
        int start = 1;
        int end = 10;

        int ans = -1;
        for (int i = 0; i < 7; i++) {
            if (Math.pow(end, 2) - 1 >= n) {
                ans = helper(start, end);
            }
            if (ans != -1) {
                return ans;
            }
            start *= 10;
            end *= 10;
        }

        return ans;
    }

    private int helper(int start, int end) {
        System.out.println("start " + start + " end " + end);
        //ODD
        for (int i = start; i < end; i++) {
            String front = String.valueOf(i);
            StringBuilder back = new StringBuilder(String.valueOf(i).substring(0, front.length() - 1)).reverse();

            try {
                long base10 = Long.parseLong(front + back);
                isPalindrome(String.valueOf(base10));
                if (base10 >= n && isPrime((int) base10)) {
                    return (int) base10;
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
                isPalindrome(String.valueOf(base10));
                if (base10 >= n && isPrime((int) base10)) {
                    return (int) base10;
                }

            } catch (Exception e) {
                if (!"no isPalindrome".equals(e.getMessage())) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return -1;
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

    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;

        int sqrt = (int) Math.sqrt(num);
        for (int i = 3; i <= sqrt; i += 2) {
            if (num % i == 0) return false;
        }

        return true;
    }
}
