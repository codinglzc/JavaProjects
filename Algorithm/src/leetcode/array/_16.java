package leetcode.array;

import java.util.Arrays;

/**
 * @Description: 16. 3Sum Closest
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * <p>
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * <p>
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * @Author: lc
 * @Date: Created in 2018/3/5
 */
public class _16
{
    public int threeSumClosest(int[] nums, int target)
    {
        int result = Integer.MAX_VALUE;
        int minDiffAbs = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++)
        {
            int left = i + 1, right = nums.length - 1;
            while (left < right)
            {
                int diff = nums[i] + nums[left] + nums[right] - target;
                int diffAbs = Math.abs(diff);
                result = diffAbs < minDiffAbs ? diff + target : result;
                minDiffAbs = Math.min(minDiffAbs, diffAbs);

                if (diff == 0)
                    return target;
                else if (diff > 0)
                    right--;
                else
                    left++;
            }
        }
        return result;
    }
}
