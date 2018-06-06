package leetcode.array;

/**
 * @Description: 283. Move Zeroes
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * <p>
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 * <p>
 * Note:
 * 1. You must do this in-place without making a copy of the array.
 * 2. Minimize the total number of operations.
 * @Author: lc
 * @Date: Created in 2018/1/25
 */
public class _283
{
    public void moveZeroes(int[] nums)
    {
        int zeroNum = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] == 0)
                zeroNum++;
            else if (zeroNum > 0)
            {
                nums[i - zeroNum] = nums[i];
                nums[i] = 0;
            }
        }
    }
}
