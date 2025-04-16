import java.util.HashSet;
import java.util.Set;

public class No564 {
    public static void main(String[] args) {
        No564 obj = new No564();

        System.out.println(obj.nearestPalindromic("1"));
        System.out.println(obj.nearestPalindromic("19"));
        System.out.println(obj.nearestPalindromic("123"));
        System.out.println(obj.nearestPalindromic("99"));
    }

    public String nearestPalindromic(String n) {
        Set<Long> possible = new HashSet<>();
        int l = n.length();
        possible.add((long) (Math.pow(10, l - 1) - 1));
        possible.add((long) (Math.pow(10, l) + 1));

        String str = n.substring(0, (int) Math.ceil(n.length() / 2.0));

        long equal = Long.parseLong(str);
        long add = equal + 1;
        long minus = equal - 1;
        StringBuilder strEqual = new StringBuilder(Long.toString(equal));
        StringBuilder strAdd = new StringBuilder(Long.toString(add));
        StringBuilder strMinus = new StringBuilder(Long.toString(minus));

        if (n.length() % 2 == 0) {
            strEqual.append(new StringBuilder(strEqual).reverse());
            strAdd.append(new StringBuilder(strAdd).reverse());
            strMinus.append(new StringBuilder(strMinus).reverse());

        } else {
            strEqual.append(new StringBuilder(strEqual).reverse().substring(1));
            strAdd.append(new StringBuilder(strAdd).reverse().substring(1));
            strMinus.append(new StringBuilder(strMinus).reverse().substring(1));

        }
        possible.add(Long.parseLong(strEqual.toString()));
        possible.add(Long.parseLong(strAdd.toString()));
        possible.add(Long.parseLong(strMinus.toString()));

        long cur = Long.parseLong(n);
        possible.remove(cur);

        long min = Long.MAX_VALUE;
        long ans = 0L;
        for (Long num : possible) {
            if (min > Math.abs(num - cur)) {
                min = Math.abs(num - cur);
                ans = num;
            } else if (min == Math.abs(num - cur)) {
                ans = Math.min(num, ans);
            }
        }

        return Long.toString(ans);
    }
}
