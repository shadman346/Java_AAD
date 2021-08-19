package _Dp;

public class SellStockInfiniteTransaction {
    public static void main(String[] args) {
        int[] arr= {7,1,5,3,6,4};
        System.out.println(maxProfit(arr));
    }
    public static int maxProfit(int[] prices) {
        int buy = prices[0], sell = 0;
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - buy < sell) {
                profit += sell;
                buy = prices[i];
            }

            sell = prices[i] - buy;

        }
        if (buy < sell) profit += sell;
        return profit;
    }
}
