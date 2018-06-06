package leetcode.array;

/**
 * @Description: 33. Search in Rotated Sorted Array I (_81: Search in Rotated Sorted Array II)
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * <p>
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * <p>
 * You may assume no duplicate exists in the array.
 * @Author: lc
 * @Date: Created in 2017/12/21
 */
public class _33
{
    /**
     * 时间复杂度：log(n)
     */
    public int search(int[] nums, int target)
    {
        int left = 0;
        int right = nums.length - 1;
        // 二分法查找
        while (left <= right)
        {
            int mid = left + (right - left) / 2;
            if (target == nums[mid])
                return mid;
            if (nums[left] <= nums[mid])
            {
                if (nums[left] <= target && target < nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            } else
            {
                if (nums[mid] < target && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return -1;
    }
}
