import java.util.Arrays;

public class No2523 {
    public static void main(String[] args) {
        No2523 obj = new No2523();
//int i = 1000000;

//        System.out.println(Arrays.toString(obj.closestPrimes(999959, 999961)));
//        System.out.println(Arrays.toString(obj.closestPrimes(850350, 851803)));
        System.out.println(Arrays.toString(obj.closestPrimes(822, 838394)));
    }

    public int[] closestPrimes(int left, int right) {
        int scalar = left;
        int[] list = new int[right - left + 1];
        int[] primary = new int[(list.length / 2) + 1];
        int index = 0;
        int[] ans = new int[2];

        if (left > 2) {
            if (left % 2 != 0) {
                int t = left + 1;
                while (t <= right) {
                    list[t - scalar] = -1;
                    t += 2;
                }
            } else {
                int t = left;
                while (t <= right) {
                    list[t - scalar] = -1;
                    t += 2;
                }
            }
        }


        for (int i = 0; i < list.length; i++) {
            int temp = i + scalar;

            if (list[i] == -1) {
                continue;
            }
            boolean isPrimary = isPrime(temp);
            if (isPrimary) {
                primary[index] = i;
                index++;
            }
            if (temp > 1) {
                while (temp <= right) {
                    list[temp - scalar] = -1;
                    temp += (i + scalar);
                }
            }
        }

        if (index <= 1) {
            ans[0] = -1;
            ans[1] = -1;
            return ans;
        }
        int minGap = right - left + 2;
        for (int i = 0; i < index - 1; i++) {
            int tempGap = primary[i + 1] - primary[i];
            if (tempGap < minGap) {
                ans[0] = primary[i] + scalar;
                ans[1] = primary[i + 1] + scalar;
                minGap = tempGap;
                if (minGap == 1) {
                    return ans;
                }
            }
        }


        return ans;
    }

    public static boolean isPrime(int n) {
        int count = 0;
        int sqrt = (int) Math.sqrt(n);

        if (n < 2) {
            return false;
        }

        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0) {
                count++;
            }
        }

        if (count == 0) {
            return true;
        }
        return false;
    }
}