package leetcode.array;

/**
 * @Description: 568. Min Cost Climbing Stairs
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
 * <p>
 * Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the
 * floor, and you can either start from the step with index 0, or the step with index 1.
 * <p>
 * Example 1:
 * Input: cost = [10, 15, 20]
 * Output: 15
 * Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
 * <p>
 * Example 2:
 * Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * Output: 6
 * Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
 * <p>
 * Note:
 * 1. cost will have a length in the range [2, 1000].
 * 2. Every cost[i] will be an integer in the range [0, 999].
 * @Author: lc
 * @Date: Created in 2018/3/2
 */
public class _568
{
    /**
     * @Description: 有一个楼梯，每次可以走1层或者2层，cost数组表示每一层所需要花费的值。可以从第一层或者第二层开始。求，到达顶端所花
     * 费大的最小的值。
     * <p>
     * 思路：
     * <p>
     * 这是一个动态规划(Dynamic programming, DP)的问题。
     * <p>
     * 如果我们用一个数组dp[]来存放到达每一层所需要的花费值。则则最终结果是求dp[cost.length]的值。因为每次可以走1层或者2层，并且可以
     * 从0或者从1开始，所以可以得到dp[0]为0，dp[1]为0。从2开始，dp[i]可以由通过dp[i-2]走2层或者通过dp[i-1]走一层到达，而这i-2和i-1
     * 层所要花费的值分别为cost[i-2]和cost[i-1]，所以，dp[i] = min(dp[i-2] + cost[i-2], dp[i-1] + cost[i-1])。该算法的空间复杂
     * 度为O(n)，时间复杂度为O(n)。
     * @Author: lc
     * @Date: Created in 2018/3/2
     */
    public int minCostClimbingStairs(int[] cost)
    {
        int dp0 = 0;
        int dp1 = 0;
        int result = 0;
        for (int i = 2; i < cost.length + 1; i++)
        {
            result = Math.min(dp0 + cost[i - 2], dp1 + cost[i - 1]);
            dp0 = dp1;
            dp1 = result;
        }
        return result;
    }
}
