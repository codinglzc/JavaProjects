package jianzhioffer.topic39;

/**
 * <p>
 * 面试题39：数组中出现此数据超过一半的数字（P.205）
 * 题目：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如，输入一个长度为 9 的数组{1,2,3,2,2,2,5,4,2}。由于数字 2 在数组中出现了 5 次，超过数组长度的一半，因此输出 2。
 * </p>
 *
 * @author Liu Cong
 * @since 2018-07-12
 */
public class MoreThanHalfNumber
{
    /**
     * 解法一：基于 partition 函数的时间复杂度为 O(n) 的算法
     * <p>
     * 详解见 P.206
     * <p>
     * 时间复杂度：O(n)
     * <p>
     * 缺点：需要修改原数组
     */
    public static int moreThanHalfNum(int[] nums)
    {
        if (nums == null || nums.length <= 0) return 0;

        int mid = nums.length >> 1;
        int start = 0;
        int end = nums.length - 1;
        int index = partition(nums, start, end);
        while (index != mid)
        {
            if (index > mid)
            {
                end = mid - 1;
                index = partition(nums, start, end);
            } else
            {
                start = mid + 1;
                index = partition(nums, start, end);
            }
        }

        int result = nums[mid];
        if (checkInvalidArray(nums, result)) return 0;
        return result;
    }

    private static boolean checkInvalidArray(int[] nums, int result)
    {
        int count = 0;
        for (int num : nums)
        {
            if (num == result) count++;
        }

        return count * 2 > nums.length;
    }

    private static int partition(int[] nums, int start, int end)
    {
        int midVal = nums[start];
        while (start < end)
        {
            while (start < end && nums[end] >= midVal) end--;
            if (start < end) nums[start++] = nums[end];

            while (start < end && nums[start] <= midVal) start++;
            if (start < end) nums[end--] = nums[start];
        }
        nums[start] = midVal;
        return start;
    }

    /**
     * 解法二：根据数组特点找出时间复杂度为O(n)的算法
     * <p>
     * 思路：数组中有一个数字出现的次数超过数组长度的一半，也就是说他出现的次数比其他所有数字出现次数的和还要多。因此，我们可以考虑在遍
     * 历数组的时候保存两个值：一个是数组中的一个数字；另一个是次数。当我们遍历到下一个数字的时候，如果下一个数字和我们之前保存的数字相
     * 同，则次数减1。如果次数为0，那么我们需要保存下一个数字，并把次数设为1。由于我们要找的数字出现的次数比其他所有数字出现的次数之和
     * 还要多，那么要找的数字肯定是最后一次把次数设为1时对应的数字。
     * <p>
     * 时间复杂度：O(n)
     */
    public static int moreThanHalfNumber(int[] nums)
    {
        if (nums == null || nums.length <= 0) return 0;

        int result = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++)
        {
            if (count == 0)
            {
                result = nums[i];
                count = 1;
            } else if (result == nums[i])
                count++;
            else
                count--;
        }

        return checkInvalidArray(nums, result) ? result : 0;
    }
}
