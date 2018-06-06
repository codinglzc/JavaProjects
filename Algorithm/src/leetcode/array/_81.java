package leetcode.array;

/**
 * @Description: 81. Search in Rotated Sorted Array II (_33: Search in Rotated Sorted Array I)
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?
 * Would this affect the run-time complexity? How and why?
 * <p>
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Write a function to determine if a given target is in the array.
 * The array may contain duplicates.
 * @Author: lc
 * @Date: Created in 2017/12/21
 */
public class _81
{
    /**
     * 当有重复数字，会存在A[mid] = A[end]的情况。此时右半序列A[mid-1 : end]可能是sorted，也可能并没有sorted，如下例子。
     * <p>
     * 3 1 2 3 3 3 3
     * 3 3 3 3 1 2 3
     * <p>
     * 所以当A[mid] = A[end] != target时，无法排除一半的序列，而只能排除掉A[end]：
     * <p>
     * A[mid] = A[end] != target时：搜寻A[start : end-1]
     */
    public boolean search(int[] nums, int target)
    {
        int left = 0;
        int right = nums.length - 1;
        // 二分法查找
        while (left <= right)
        {
            int mid = left + (right - left) / 2;
            if (target == nums[mid])
                return true;
            if (nums[left] < nums[mid])
            {
                if (nums[left] <= target && target < nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            } else if (nums[left] > nums[mid])
            {
                if (nums[mid] < target && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            } else
                // 无法排除一半的序列，而只能排除掉 nums[left]
                left++;
        }
        return false;
    }
}
