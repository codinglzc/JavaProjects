package leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 217. Contains Duplicate I
 * Given an array of integers, find if the array contains any duplicates. Your function should return true if any value
 * appears at least twice in the array, and it should return false if every element is distinct.
 * @Author: lc
 * @Date: Created in 2018/1/23
 */
public class _217
{
    public boolean containsDuplicate(int[] nums)
    {
        Set<Integer> s = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++)
        {
            if (s.contains(nums[i]))
                return true;
            s.add(nums[i]);
        }
        return false;
    }
}
