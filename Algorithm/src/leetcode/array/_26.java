/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package leetcode.array;

/**
 * @Description: 26. Remove Duplicates from Sorted Array
 * <p>
 * Given a sorted array, remove the duplicates in-place such that each element appear only once and return the new
 * length.
 * <p>
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra
 * memory.
 * <p>
 * Example:
 * <p>
 * Given nums = [1,1,2],
 * <p>
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't
 * matter what you leave beyond the new length.
 * @Author: lc
 * @Date: Created in 2017/12/10
 */
public class _26
{
    /*
     * 首先我们需要知道，对于一个排好序的数组来说，A[N + 1] >= A[N]，我们仍然使用两个游标i和j来处理，
     * 假设现在i = j + 1，如果A[i] == A[j]，那么我们递增i，直到A[i] != A[j]，
     * 这时候我们再设置A[j + 1] = A[i]，同时递增i和j，重复上述过程直到遍历结束。
     */
    public int removeDuplicates(int[] nums)
    {
        if (nums.length < 1)
            return 0;
        int l = 0;
        for (int r = 1; r < nums.length; r++)
        {
            if (nums[l] != nums[r])
            {
                nums[++l] = nums[r];
            }
        }
        return l + 1;
    }
}
