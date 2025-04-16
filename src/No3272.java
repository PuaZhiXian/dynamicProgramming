import java.util.*;

public class No3272 {
    public static void main(String[] args) {
        No3272 obj = new No3272();
//        System.out.println(obj.countGoodIntegers(1, 4));
        System.out.println(obj.countGoodIntegers(10, 1));
    }

    public long countGoodIntegers(int n, int k) {
        genFac();
        List<Long> lt = genValidPalindrome(0, n, k, new int[n]);
        return cntPermutation(lt, n);
    }

    long[] fac = new long[11];

    private void genFac() {
        fac[0] = 1;
        fac[1] = 1;
        int index = 2;
        for (int i = 2; i < fac.length; i++) {
            fac[i] = fac[i - 1] * index;
            index++;
        }
    }

    private List<Long> genValidPalindrome(int index, int digit, int k, int[] arr) {
        List<Long> ans = new ArrayList<>();
        if (index == Math.floor(digit / 2.0) + 1) { // base case
            int multiple = 1;
            long val = 0;
            for (int i = digit - 1; i >= 0; i--) {
                val += ((long) multiple * arr[i]);
                multiple *= 10;
            }
            if (val % k == 0) {
                ans.add(val);
            }
            return ans;
        }


        int i = index == 0 ? 1 : 0;
        for (; i <= 9; i++) {
            arr[index] = i;
            arr[digit - index - 1] = i;
            ans.addAll(genValidPalindrome(index + 1, digit, k, arr));
        }

        return ans;
    }

    private long cntPermutation(List<Long> lt, int digit) {
        long ans = 0;
        Set<String> set = new HashSet<>();

        int temp2 = (int) Math.pow(10, digit - 1);
        for (Long num : lt) {
            int temp = temp2;
            int[] arr = new int[10];
            while (temp >= 1) {
                arr[(int) (num / temp)]++;
                num = num % temp;
                temp = temp / 10;

            }

            StringBuilder builder = new StringBuilder();
            long below = 1;

            for (int i = 0; i < arr.length; i++) {
                for (int j = arr[i]; j > 0; j--) {
                    builder.append(i);
                }
                below = below * (fac[arr[i]]);
            }

            String check = builder.toString();

            if (!set.contains(check)) {
                set.add(check);
                if (arr[0] == 0) {
                    ans += (fac[digit]) / below;
//                    System.out.println(" " + (fac[digit]) / below);
                } else {
                    ans = ans + (fac[digit] / (below));
                    ans = ans - ((fac[digit - 1]) / (below / fac[arr[0]] * (fac[arr[0] - 1])));
//                    System.out.println();
                }
            }
        }
        return ans;
    }


}
