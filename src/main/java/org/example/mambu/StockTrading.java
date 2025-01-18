package org.example.mambu;

/**
 * In share trading, a buyer buys shares and sells on a future date. Given the stock price of n days, the trader is
 * allowed to make at most k transactions, where a new transaction can only start after the previous transaction is
 * complete, find out the maximum profit that a share trader could have made.
 * Examples:
 * Input: Price = [10, 22, 5, 75, 65, 80], K = 2
 * Output: 87
 * Explanation: Buy on 1st day at 10 and sell on 2nd day at 22. Then, again buy on 3rd day at 5 and sell on 6th day at 80. Total profit = 12 + 75 = 87
 */
public class StockTrading {

    public static void main(String[] args) {

        int[] prices = {10, 22, 5, 75, 65, 80};
//        int[] prices = {400, 200, 100, 900, 1000, 50, 700};

        StockTrading stockTrading = new StockTrading();
        int max2 = stockTrading.findProfitMultipleTransactions(prices);
        System.out.println(max2);
    }

    int findProfitOneTransaction(int[] prices) {

        int maxProfit = 0;
        int buy = prices[0];

        for (int i = 1; i < prices.length; i++) {

            int currentProfit = prices[i] - buy;

            maxProfit = Math.max(maxProfit, currentProfit);

            if (prices[i] < buy) {
                buy = prices[i];
            }
        }

        return maxProfit;
    }

    int findProfitMultipleTransactions(int[] prices) {
        int totalProfit = 0;

        int buy = -1;

        for (int i = 0; i < prices.length; i++) {
            if (buy == -1 && i + 1 < prices.length && prices[i + 1] > prices[i]) {
                // we buy as the buy is -1 and next day price is bigger
                buy = prices[i];
            }

            if (buy > 0) {
                if (i + 1 >= prices.length || prices[i + 1] < prices[i]) {
                    // we sell because buy > 0 and next day price is smaller (or the last day)
                    totalProfit += prices[i] - buy;
                    System.out.printf("buy at %d, sell at %d, profit %d, totalProfit %d\n", buy, prices[i], prices[i] - buy, totalProfit);
                    buy = -1;
                }
            }
        }

        return totalProfit;
    }
}
