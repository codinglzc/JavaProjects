package leetcode.array;

/**
 * @Description: 485. Max Consecutive Ones
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 * <p>
 * Example 1:
 * Input: [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s.
 * The maximum number of consecutive 1s is 3.
 * <p>
 * Note:
 * The input array will only contain 0 and 1.
 * The length of input array is a positive integer and will not exceed 10,000
 * @Author: lc
 * @Date: Created in 2017/12/12
 */
public class _485
{
    public int findMaxConsecutiveOnes(int[] nums)
    {
        int max = 0;
        int count = 0;
        for (int num : nums)
        {
            if (num == 0)
            {
                max = max > count ? max : count;
                count = 0;
            } else
                count++;
        }
        if (count > max)
            max = count;
        return max;
    }
}
