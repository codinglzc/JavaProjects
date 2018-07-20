package jianzhioffer.topic40;

/**
 * <p>
 * 面试题40：最小的 K 个数（P.209）
 * 题目：输入 n 个整数据，找出其中最小的 k 个数。
 * 例如，输入 4,5,1,6,2,7,3,8 这8个数字，则最小的4个数字是 1,2,3,4.
 * </p>
 *
 * @author Liu Cong
 * @since 2018-07-13
 */
public class KLeastNumbers1
{
    /**
     * 解法一：时间复杂度为 O(n) 的算法，只有当我们可以修改输入的数组时可用。
     * <p>
     * 基于 partition 函数来解决此问题。
     */
    public static int[] getLeastNumbers(int[] nums, int k)
    {
        if (nums == null || nums.length <= 0) return null;

        int start = 0;
        int end = nums.length - 1;
        int index = partition(nums, start, end);
        while (k - 1 != index)
        {
            if (index < k - 1)
            {
                start = index + 1;
                index = partition(nums, start, end);
            } else
            {
                end = index - 1;
                index = partition(nums, start, end);
            }
        }

        int[] result = new int[k];
        System.arraycopy(nums, 0, result, 0, k);
        return result;
    }

    private static int partition(int[] nums, int start, int end)
    {
        int midValue = nums[start];
        while (start < end)
        {
            while (start < end && nums[end] >= midValue) end--;
            if (start < end) nums[start++] = nums[end];

            while (start < end && nums[start] <= midValue) start++;
            if (start < end) nums[end--] = nums[start];
        }
        nums[start] = midValue;
        return start;
    }
}
