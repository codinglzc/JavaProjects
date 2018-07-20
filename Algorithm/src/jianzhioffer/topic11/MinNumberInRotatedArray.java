package jianzhioffer.topic11;

/**
 * @description: 面试题11：旋转数组的最小数字（P.82）
 * 题目：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组{3, 4, 5, 1, 2}为{1, 2, 3, 4, 5}的一个旋转，该数组的最小值为1.
 * @author: Liu Cong
 * @create: Created at 2018-06-19
 */
public class MinNumberInRotatedArray
{
    /**
     * 二分查找法
     * <p>
     * 时间复杂度：O(logn)
     * 空间复杂度：O(1)
     *
     * @param nums 旋转数组
     * @return 最小值
     */
    public static int solution1(int[] nums)
    {
        if (nums == null || nums.length <= 0) return -1;

        int left = 0;
        int right = nums.length - 1;
        int mid = left; // 如果旋转数组本身就是一个特例，即排序数组本身，则数组中的第一个数字就是最小值。因此需要把mid初始化为left。
        while (nums[left] >= nums[right])
        {
            if (right - left == 1)
            {
                mid = right;
                break;
            }

            mid = (right + left) >> 2;

            // 考虑一个特殊情况：如果下标为 left、right 和 mid 指向的三个数字相等，那么无法判断中间的数字是位于前面的子数组还是后面的子数组，那么就只能按顺序查找了。
            // 特例：{1,0,1,1,1} 和 {1,1,1,0,1}
            if (nums[left] == nums[right] && nums[left] == nums[mid])
            {
                int result = nums[left];
                for (int i = left + 1; i <= right; i++)
                {
                    if (nums[i] < result) result = nums[i];
                }
                return result;
            }

            // 缩小查找范围
            if (nums[mid] >= nums[left]) left = mid;
            else if (nums[mid] <= nums[right]) right = mid;
        }
        return nums[mid];
    }
}
