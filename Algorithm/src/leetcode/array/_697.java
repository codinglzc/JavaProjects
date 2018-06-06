package leetcode.array;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 697. Degree of an Array
 * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.
 * <p>
 * Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
 * <p>
 * Example 1:
 * Input: [1, 2, 2, 3, 1]
 * Output: 2
 * Explanation:
 * The input array has a degree of 2 because both elements 1 and 2 appear twice.
 * Of the subarrays that have the same degree:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * The shortest length is 2. So return 2.
 * <p>
 * Example 2:
 * Input: [1,2,2,3,1,4,2]
 * Output: 6
 * <p>
 * Note:
 * 1. `nums.length` will be between 1 and 50,000.
 * 2. `nums[i]` will be an integer between 0 and 49,999.
 * @Author: lc
 * @Date: Created in 2018/2/28
 */
public class _697
{
    public static int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        Map<Integer, Integer> left = new HashMap<Integer, Integer>();
        Map<Integer, Integer> right = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++)
        {
            if(!left.containsKey(nums[i])) left.put(nums[i], i);
            right.put(nums[i], i);
            count.put(nums[i], 1 + count.getOrDefault(nums[i], 0));
        }

        int result = nums.length;
        int degree = Collections.max(count.values());
        for (int x : count.keySet())
        {
            if(count.get(x) == degree)
                result = Math.min(result, right.get(x) - left.get(x) + 1);
        }
        return result;
    }

    public static void main(String[] args)
    {
        int[] nums = {1,2,2,3,1};
        _697.findShortestSubArray(nums);
    }
}
