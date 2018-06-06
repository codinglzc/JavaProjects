package leetcode.array;

/**
 * @Description: 581. Shortest Unsorted Continuous Subarray
 * Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending
 * order, then the whole array will be sorted in ascending order, too.
 * <p>
 * You need to find the shortest such subarray and output its length.
 * <p>
 * Example 1:
 * Input: [2, 6, 4, 8, 10, 9, 15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 * <p>
 * Note:
 * Then length of the input array is in range [1, 10,000].
 * The input array may contain duplicates, so ascending order here means <=.
 * @Author: lc
 * @Date: Created in 2018/1/31
 */
public class _581
{
    public static int findUnsortedSubarray(int[] nums)
    {
        int n = nums.length;
        int left = 0;
        int max = nums[0];
        int right = -1;
        int min = nums[n - 1];
        for (int i = 1; i < n; i++)
        {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[n - i - 1]);
            if (nums[i] < max) right = i;
            if (nums[n - i - 1] > min) left = n - i - 1;
        }
        return right - left + 1;
    }

    public static void main(String[] args)
    {
        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        _581.findUnsortedSubarray(nums);
    }
}
