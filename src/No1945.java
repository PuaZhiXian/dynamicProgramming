public class No1945 {

    public static void main(String[] args) {
        No1945 obj = new No1945();
//        System.out.println(obj.getLucky("zbax", 2));
        System.out.println(obj.getLucky("leetcode", 2));
    }

    public int getLucky(String s, int k) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int temp = s.charAt(i) - 'a' + 1;
            int tempSum = 0;
            while (temp > 0) {
                int reminder = temp % 10;
                tempSum += reminder;
                temp = temp / 10;
            }
            sum += tempSum;
        }

        return helper(sum, k-1);
    }

    public int helper(int sum, int k) {
        if (k == 0) {
            return sum;
        }

        int temp = 0;
        while (sum > 0) {
            int reminder = sum % 10;
            temp += reminder;
            sum = sum / 10;
        }
        return helper(temp, k - 1);
    }
}
