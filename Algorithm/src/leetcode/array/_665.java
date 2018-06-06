/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package leetcode.array;

/**
 * @Description: 665. Non-decreasing Array
 * <p>
 * Given an array with n integers, your task is to check if it could become non-decreasing by modifying at most 1 element.
 * We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).
 * <p>
 * <p>
 * Example 1:
 * Input: [4,2,3]
 * Output: True
 * Explanation: You could modify the first
 * 4
 * to
 * 1
 * to get a non-decreasing array.
 * <p>
 * Example 2:
 * Input: [4,2,1]
 * Output: False
 * Explanation: You can't get a non-decreasing array by modify at most one element.
 * <p>
 * Note: The n belongs to [1, 10,000].
 * @Author: lc
 * @Date: Created in 2017/12/10
 */
public class _665
{
    /**
     * 思路：
     * <p>
     * 考虑数组中逆序发生的次数，如果cnt>=2，返回false。如果cnt==1的话需要判断一下。
     * <p>
     * <p>
     * 比如 xxx 5 3 7 xx  发生了一次逆序  5比7小 只需将3调整为7就可以了
     * 还有就是比如 xxxxx2725xxx 从7那下降了 然后从2后上升了 但是此时把7改成2就可以啦
     * 这个就是属于if (nums[index - 1] <= nums[index + 1])return true;
     * <p>
     * <p>
     * 就是先下降后上升 如果上升的更高 那就改一次就行了
     * <p>
     * 但是如果没更高  那就试试把左边的也下降一下 看满足条件不 如果满足就true 否则false
     *
     * @param nums
     * @return
     */
    public boolean checkPossibility(int[] nums)
    {
        if (nums.length <= 2)
            return true;
        int count = 0;
        int index = 0;
        for (int i = 0; i < nums.length - 1; i++)
        {
            if (nums[i] > nums[i + 1])
            {
                count++;
                index = i;
            }
            if (count > 1)
                return false;
        }
        if (count == 0)
            return true;
        if (count == 1)
        {
            if (index == 0 || index == nums.length - 2)
                return true;
            if (nums[index] <= nums[index + 2])
                return true;
            if (nums[index - 1] <= nums[index + 1])
                return true;
            return false;
        }
        return false;
    }

    public static void main(String[] args)
    {
        _665 obj = new _665();
        System.out.println(obj.checkPossibility(new int[]{4, 2, 1}));
    }
}
