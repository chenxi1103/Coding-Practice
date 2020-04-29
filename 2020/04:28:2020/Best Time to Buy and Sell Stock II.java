/**
 * Say you have an array prices for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 */
class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int buy = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[i-1]) {
                profit += prices[i-1] - buy > 0 ? prices[i-1] - buy : 0;
                while (i < prices.length-1 && prices[i] > prices[i+1]) i++;
                buy = prices[i];
            }  
        }
        return Math.max(profit + prices[prices.length - 1] - buy, profit);
    }
}