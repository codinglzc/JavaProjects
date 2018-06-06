package leetcode.array;

/**
 * @Description: 268. Missing Number
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 * <p>
 * Example 1
 * Input: [3,0,1]
 * Output: 2
 * <p>
 * Example 2
 * Input: [9,6,4,2,3,5,7,0,1]
 * Output: 8
 * <p>
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 * @Author: lc
 * @Date: Created in 2018/1/24
 */
public class _268
{
    public int missingNumber(int[] nums)
    {
        int result = 0;
        for (int i = 0; i < nums.length; i++)
        {
            result ^= i ^ nums[i];
        }
        return result ^ nums.length;
    }
}
