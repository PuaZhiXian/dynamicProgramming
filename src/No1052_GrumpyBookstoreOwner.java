public class No1052_GrumpyBookstoreOwner {
    public static void main(String[] args) {
        System.out.println(maxSatisfied(
                new int[]{1, 0, 1, 2, 1, 1, 7, 5},
                new int[]{0, 1, 0, 1, 0, 1, 0, 1},
                3
        ));
        System.out.println(maxSatisfied(
                new int[]{1,},
                new int[]{0,},
                1
        ));
    }

    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int start = 0;
        int end = 0;
        int sum = 0;
        int originalSum = 0;

        while (end < minutes) {
            if (grumpy[end] == 1) {
                sum += customers[end];
            } else {
                originalSum += customers[end];
            }
            end++;
        }
        int max = sum;

        while (end < customers.length) {
            if (grumpy[start] != 0) {
                sum -= customers[start];
            }

            if (grumpy[end] == 0) {
                originalSum += customers[end];
            } else {
                sum += customers[end];
            }
            start++;
            end++;
            max = Math.max(sum, max);
        }
        return originalSum + max;
    }
}
