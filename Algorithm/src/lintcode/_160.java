package lintcode;

/**
 * @Description: 160. 寻找旋转排序数组中的最小值 II
 * 假设一个旋转排序的数组其起始位置是未知的（比如0 1 2 4 5 6 7 可能变成是4 5 6 7 0 1 2）。
 * 你需要找到其中最小的元素。
 * 数组中可能存在重复的元素。
 * <p>
 * 样例：
 * 给出[4,4,5,6,7,0,1,2]  返回 0
 * @Author: lc
 * @Date: Created in 2018/3/8
 */
public class _160
{
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums)
    {
        // write your code here
        int left = 0, right = nums.length - 1;

        while (left < right)
        {
            if (nums[left] < nums[right]) return nums[left];

            int mid = left + (right - left) / 2;

            if (nums[mid] >= nums[right])
                left = mid + 1;
            else
                right = mid;
        }
        return nums[left];
    }
}
