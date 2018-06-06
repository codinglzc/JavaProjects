/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package leetcode.array;

/**
 * @Description: 189. Rotate Array
 * Rotate an array of n elements to the right by k steps.
 * <p>
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * <p>
 * Note:
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * <p>
 * [show hint]
 * <p>
 * Related problem: Reverse Words in a String II
 * <p>
 * Credits:
 * Special thanks to @Freezen for adding this problem and creating all test cases.
 * @Author: lc
 * @Date: Created in 2017/12/10
 */
public class _189
{
    /*
     * 时间复杂度O(n)，空间复杂度O(1)
     * 三次交换
     */
    public void rotate(int[] nums, int k)
    {
        if (nums.length == 1)
            return;
        if (k > nums.length)
            k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int m, int n)
    {
        while (m < n)
        {
            int temp = nums[m];
            nums[m++] = nums[n];
            nums[n--] = temp;
        }
    }

    public static void main(String[] args)
    {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        _189 obj = new _189();

        obj.rotate(nums, 1);
        System.out.println(nums[0]);
        System.out.println(nums[1]);
        System.out.println(nums[2]);
        System.out.println(nums[3]);
        System.out.println(nums[4]);
    }
}
