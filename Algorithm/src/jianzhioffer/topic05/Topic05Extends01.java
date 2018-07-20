package jianzhioffer.topic05;

/**
 * @description: 相关题目
 * 有两个排序的数组 A1 和 A2，内存在 A1 的末尾有足够多的空余空间容纳 A2。请实现一个函数，把 A2 中的所有数字插入 A1中，并且所有的数字是
 * 排序的。
 * @author: Liu Cong
 * @create: Created at 2018-06-13
 */
public class Topic05Extends01
{
    /**
     * 从后向前遍历
     *
     * @param nums1         eg:[1,3,5,7,9,0,0,0,0,0,]
     * @param lengthOfNums1 eg: 5
     * @param nums2         eg:[2,4,6,8,10,]
     */
    public static void solution(int[] nums1, int lengthOfNums1, int[] nums2)
    {
        if (nums1 == null || nums2 == null || nums1.length <= nums2.length || nums2.length <= 0)
            return;

        int newLength = lengthOfNums1 + nums2.length;
        int indexOfNewNums1 = newLength - 1;
        int indexOfNums1 = lengthOfNums1 - 1;
        int indexOfNums2 = nums2.length - 1;
        while (indexOfNums1 >= 0 && indexOfNums2 >= 0)
        {
            if (nums1[indexOfNums1] < nums2[indexOfNums2])
            {
                nums1[indexOfNewNums1--] = nums2[indexOfNums2--];
            } else
            {
                nums1[indexOfNewNums1--] = nums1[indexOfNums1--];
            }
        }

        if (indexOfNums2 >= 0)
        {
            while (indexOfNums2 >= 0)
            {
                nums1[indexOfNewNums1--] = nums2[indexOfNums2--];
            }
        }
    }
}
