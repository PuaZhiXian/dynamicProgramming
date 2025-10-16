public class No2749 {
    public static void main(String[] args) {
        No2749 o = new No2749();
    }

    long[] power = new long[61];

    public int makeTheIntegerZero(int num1, int num2) {
        for (long k = 1; ; k++) {
            long targetSum = num1 - k * num2;

            if (targetSum < 0) {
                break;
            }

            if (Long.bitCount(targetSum) <= k && k <= targetSum) {
                return (int) k;
            }
        }
        return -1;
    }
} 
