package leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 448. Find All Numbers Disappeared in an Array
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * <p>
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * <p>
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 * <p>
 * <p>
 * Example:
 * <p>
 * Input:
 * [4,3,2,7,8,2,3,1]
 * <p>
 * Output:
 * [5,6]
 * @Author: lc
 * @Date: Created in 2018/1/26
 */
public class _448
{
    public static List<Integer> findDisappearedNumbers(int[] nums)
    {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++)
        {
            int val = Math.abs(nums[i]) - 1;
            if (nums[val] > 0)
                nums[val] = -nums[val];
        }
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] > 0)
                result.add(i + 1);
        }
        return result;
    }

    public static void main(String[] args)
    {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        _448.findDisappearedNumbers(nums);
    }
}
