package leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 219. Contains Duplicate II
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array
 * such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 * @Author: lc
 * @Date: Created in 2018/1/23
 */
public class _219
{
    public boolean containsNearbyDuplicate(int[] nums, int k)
    {
        Set<Integer> s = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++)
        {
            if (i > k) s.remove(nums[i - k - 1]);
            if (!s.add(nums[i])) return true;
        }
        return false;
    }
}
