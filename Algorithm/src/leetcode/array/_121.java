package leetcode.array;

/**
 * @Description: 121. Best Time to Buy and Sell Stock
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an
 * algorithm to find the maximum profit.
 * <p>
 * Example 1:
 * Input: [7, 1, 5, 3, 6, 4]
 * Output: 5
 * max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
 * <p>
 * Example 2:
 * Input: [7, 6, 4, 3, 1]
 * Output: 0
 * In this case, no transaction is done, i.e. max profit = 0.
 * @Author: lc
 * @Date: Created in 2018/1/4
 */
public class _121
{
    /**
     * 类似于买股票，但只允许交易一次，求盈利最大的一次买卖。
     * 思路：Here, the logic is to calculate the difference (maxCur += prices[i] - prices[i-1]) of the original array, and
     * find a contiguous subarray giving maximum profit. If the difference falls below 0, reset it to zero.
     */
    public int maxProfit(int[] prices)
    {
        int difCur = 0; // 当前差值
        int maxSoFar = 0; // 目前为止最大的差值
        for (int i = 1; i < prices.length; i++)
        {
            difCur += prices[i] - prices[i - 1];
            difCur = 0 > difCur ? 0 : difCur;
            maxSoFar = maxSoFar > difCur ? maxSoFar : difCur;
        }
        return maxSoFar;
    }
}
