public class BestTimeToBuyAndSellStockWithTransactionFee {
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 2, 8, 4, 9};
        int[] arr2 = {1, 3, 7, 5, 10, 3};
        BestTimeToBuyAndSellStockWithTransactionFee obj = new BestTimeToBuyAndSellStockWithTransactionFee();
        System.out.println(obj.maxProfit(arr1, 2));
        System.out.println(obj.maxProfit(arr2, 3));
    }

    public int maxProfit(int[] prices, int fee) {
        int totalProfit = 0;
        int moneyFromOwnPocket = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int temp = totalProfit;
            totalProfit = Math.max(totalProfit, prices[i] - moneyFromOwnPocket - fee);
            moneyFromOwnPocket = Math.min(moneyFromOwnPocket, prices[i] - temp);
        }

        return totalProfit;
    }
}
