public class BestTimeToBuyAndSellStock2_122 {
    public static void main(String[] args) {
        BestTimeToBuyAndSellStock2_122 obj = new BestTimeToBuyAndSellStock2_122();
        int[] arr1 = {7, 1, 5, 3, 6, 4};
        int[] arr2 = {1, 2, 3, 4, 5};
        int[] arr3 = {7, 6, 4, 3, 1};
        System.out.println(obj.maxProfit(arr1));
        System.out.println(obj.maxProfit(arr2));
        System.out.println(obj.maxProfit(arr3));
    }

    public int maxProfit(int[] prices) {
        int low = prices[0];
        int n = prices.length;
        int sum = 0;
        for (int i = 1; i < n; i++) {
            if (prices[i] > low) {
                sum += prices[i] -low;
            }
            low = prices[i];
        }
        return sum;
    }
}
