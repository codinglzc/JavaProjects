package leetcode.array;

/**
 * @Description: 169. Majority Element
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * <p>
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * <p>
 * Credits:
 * Special thanks to @ts for adding this problem and creating all test cases.
 * @Author: lc
 * @Date: Created in 2018/1/22
 */
public class _169
{
    public int majorityElement(int[] nums)
    {
        int result = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++)
        {
            if (count == 0)
            {
                result = nums[i];
                count++;
            } else if (nums[i] == result)
                count++;
            else
                count--;
        }
        return result;
    }
}
