package leetcode.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Description: 496. Next Greater Element I
 * You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2.
 * Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
 * <p>
 * The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist,
 * output -1 for this number.
 * <p>
 * Example 1:
 * Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * Output: [-1,3,-1]
 * Explanation:
 * For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
 * For number 1 in the first array, the next greater number for it in the second array is 3.
 * For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
 * <p>
 * Example 2:
 * Input: nums1 = [2,4], nums2 = [1,2,3,4].
 * Output: [3,-1]
 * Explanation:
 * For number 2 in the first array, the next greater number for it in the second array is 3.
 * For number 4 in the first array, there is no next greater number for it in the second array, so output -1.
 * <p>
 * Note:
 * 1. All elements in nums1 and nums2 are unique.
 * 2. The length of both nums1 and nums2 would not exceed 1000.
 * <p>
 * 题目大意：给定两个整型数组，nums1是nums2的子数组，nums1和nums2中都没有重复的元素。对nums1中的每个数，
 * 寻找它在nums2中对应数字的右边的第一个比它大的数，如果不存在则为-1，将结果存放在一个数组中返回。
 * @Author: lc
 * @Date: Created in 2017/12/18
 */
public class _496
{
    /**
     * 时间复杂度O(n1 * n2)
     * 暴力解法，遍历 nums1 和 nums2
     * <p>
     * 思路是遍历nums1，对每一个数，找到它在nums2的位置，然后从这个位置开始向后遍历，如果能找到比它大的，就记下第一个比它大的数，否则记为-1
     */
    public int[] nextGreaterElement1(int[] nums1, int[] nums2)
    {
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++)
        {
            boolean flag = false;
            boolean is = false;
            for (int j = 0; j < nums2.length; j++)
            {
                if (nums1[i] == nums2[j])
                    flag = true;
                if (flag && nums1[i] < nums2[j])
                {
                    result[i] = nums2[j];
                    is = true;
                    break;
                }
            }
            if (!is)
                result[i] = -1;
        }
        return result;
    }

    /**
     * 时间复杂度O(n1 + n2)
     * <p>
     * 思路比较特别，说不清楚，自己看代码。
     */
    public int[] nextGreaterElement2(int[] nums1, int[] nums2)
    {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // 用来存储 num 和下一个比他大的数的映射关系
        Stack<Integer> stack = new Stack<Integer>(); // 维护一个堆栈，只要是降序就直接 push；如果出现较大的值就 pop。
        for (int n : nums2)
        {
            while (!stack.isEmpty() && stack.peek() < n)
                map.put(stack.pop(), n);
            stack.push(n);
        }
        for (int i = 0; i < nums1.length; i++)
        {
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }
        return nums1;
    }

    public static void main(String[] args)
    {
        _496 obj = new _496();
        int[] nums1 = {1, 3, 5, 2, 4};
        int[] nums2 = {6, 5, 4, 3, 2, 1, 7};
        obj.nextGreaterElement2(nums1, nums2);
    }
}
