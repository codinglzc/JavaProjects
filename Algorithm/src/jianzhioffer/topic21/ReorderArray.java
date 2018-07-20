package jianzhioffer.topic21;

import java.lang.annotation.Target;
import java.util.Comparator;

/**
 * <p>
 * 面试题21：调整数组顺序使奇数位于偶数前面（P.129）
 * 题目：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * </p>
 *
 * @author Liu Cong
 * @since 2018-07-09
 */
public class ReorderArray
{
    /**
     * 思路：维护两个指针，第一个指针初始化时指向数组的第一个数字，它只向后移动；第二个指针初始化时指向数组的最后一个数字，它指向前移动。
     * 时间复杂度：O(n)
     *
     * @param nums 待排序数组
     */
    public static void solution1(int[] nums)
    {
        if (nums == null || nums.length <= 1) return;

        int start = 0, end = nums.length - 1;
        while (start < end)
        {
//            while (start < end && nums[start] % 2 == 1) start++;
            while (start < end && (nums[start] & 0x1) != 0) start++;
//            while (start < end && nums[end] % 2 == 0) end--;
            while (start < end && (nums[end] & 0x1) == 0) end--;

            if (start < end)
                swap(nums, start, end);
        }
    }

    private static void swap(int[] nums, int index1, int index2)
    {
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }

    /**
     * 思路同上；但增加了程序的可扩展性
     * @param nums 待排序数组
     */
    public static void solution2(int[] nums)
    {
        template(nums, args -> (args[0] & 0x1) == 0);
    }

    private static void template(int[] nums, Compara c)
    {
        if (nums == null || nums.length <= 1) return;

        int start = 0, end = nums.length - 1;
        while (start < end)
        {
//            while (start < end && nums[start] % 2 == 1) start++;
            while (start < end && !c.compara(nums[start])) start++;
//            while (start < end && nums[end] % 2 == 0) end--;
            while (start < end && c.compara(nums[start])) end--;

            if (start < end)
                swap(nums, start, end);
        }
    }

    @FunctionalInterface
    private interface Compara
    {
        boolean compara(int... args);
    }

}
