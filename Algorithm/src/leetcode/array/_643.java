package leetcode.array;

/**
 * @Description: 643. Maximum Average Subarray I
 * Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average
 * value. And you need to output the maximum average value.
 * <p>
 * Example 1:
 * Input: [1,12,-5,-6,50,3], k = 4
 * Output: 12.75
 * Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
 * <p>
 * Note:
 * 1. 1 <= k <= n <= 30,000.
 * 2. Elements of the given array will be in the range [-10,000, 10,000].
 * @Author: lc
 * @Date: Created in 2018/2/25
 */
public class _643
{
    public double findMaxAverage(int[] nums, int k)
    {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i <= nums.length - k; i++)
        {
            int curSum = 0;
            for (int j = 0; j < k; j++)
            {
                curSum += nums[i + j];
            }
            maxSum = maxSum > curSum ? maxSum : curSum;
        }
        return ((double) maxSum) / k;
    }
}
