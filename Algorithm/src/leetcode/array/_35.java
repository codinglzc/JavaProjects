package leetcode.array;

/**
 * @Description: 35. Search Insert Position
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * <p>
 * You may assume no duplicates in the array.
 * <p>
 * Example 1:
 * Input: [1,3,5,6], 5
 * Output: 2
 * <p>
 * Example 2:
 * Input: [1,3,5,6], 2
 * Output: 1
 * <p>
 * Example 3:
 * Input: [1,3,5,6], 7
 * Output: 4
 * <p>
 * Example 1:
 * Input: [1,3,5,6], 0
 * Output: 0
 * @Author: lc
 * @Date: Created in 2018/1/10
 */
public class _35
{
    public int searchInsert(int[] nums, int target)
    {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right)
        {
            if (nums[left] > target)
                return left;
            if (nums[right] < target)
                return right + 1;

            mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return right + 1;
    }
}
