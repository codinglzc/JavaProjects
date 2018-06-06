package leetcode.array;

/**
 * @Description: 122. Best Time to Buy and Sell Stock II
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like
 * (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple
 * transactions at the same time (ie, you must sell the stock before you buy again).
 * @Author: lc
 * @Date: Created in 2018/1/4
 */
public class _122
{
    /**
     * 类似于买股票，但允许交易多次，而且交易必须是串行的，求最大的盈利。
     * 思路：求每次差值，只累加差值为正的（即只做盈利的交易）
     */
    public int maxProfit(int[] prices)
    {
        int result = 0;
        for (int i = 1; i < prices.length; i++)
        {
            result += 0 > (prices[i] - prices[i - 1]) ? 0 : (prices[i] - prices[i - 1]);
        }
        return result;
    }
}
