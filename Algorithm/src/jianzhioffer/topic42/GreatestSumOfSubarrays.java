package jianzhioffer.topic42;

/**
 * <p>
 * 面试题42：连续子数组的最大和（P.218）
 * 题目：输入一个整型数组，数组里面有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。要求时间复杂度为O(n).
 * </p>
 *
 * @author Liu Cong
 * @since 2018-07-13
 */
public class GreatestSumOfSubarrays
{
    /**
     * 思路一：举例分析数组的规律
     * 思路二：应用动态规划法
     */
    public static int findGreatestSumOfSubArray(int[] nums)
    {
        if (nums == null || nums.length <= 0)
            throw new IllegalArgumentException();

        int curSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int num : nums)
        {
            if (curSum <= 0)
                curSum = num;
            else
                curSum += num;

            if (curSum > maxSum)
                maxSum = curSum;
        }

        return maxSum;
    }

    public static void main(String[] args)
    {
        System.out.println(findGreatestSumOfSubArray(new int[] {1,-2,3,10,-4,7,2,-5}));
    }
}
