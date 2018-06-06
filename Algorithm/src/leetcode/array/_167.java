/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package leetcode.array;

/**
 * @Description: 167. Two Sum II - Input array is sorted
 * <p>
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a
 * specific target number.
 * <p>
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must
 * be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 * <p>
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 * <p>
 * Input: numbers={2, 7, 11, 15}, target=9
 * <p>
 * Output: index1=1, index2=2
 * @Author: lc
 * @Date: Created in 2017/12/10
 */
public class _167
{
    /*
     * 复杂度为 O(n²)
     */
    public int[] twoSum1(int[] numbers, int target)
    {
        for (int i = 0; i < numbers.length - 1; i++)
        {
            for (int j = i + 1; j < numbers.length; j++)
            {
                if ((numbers[i] + numbers[j]) == target)
                    return new int[]{i + 1, j + 1};
            }
        }
        return null;
    }

    /*
     * 复杂度为O(nlogn)
     *
     * 二分法
     */
    public int[] twoSum2(int[] numbers, int target)
    {
        for (int i = 0; i < numbers.length - 1; i++)
        {
            int oth = target - numbers[i];
            int left = i + 1;
            int right = numbers.length - 1;
            while (left < right)
            {
                int mid = left + (right + left) / 2;
                if (numbers[mid] == oth)
                {
                    return new int[]
                            {i + 1, mid + 1};
                } else if (numbers[mid] < oth)
                {
                    left = mid + 1;
                } else
                {
                    right = mid;
                }
            }
        }
        return null;
    }

    /*
     * 复杂度为O(n)
     *
     * 我们只需要两个指针，一个指向开头，一个指向末尾，然后向中间遍历，如果指向的两个数相加正好等于target的话，
     * 直接返回两个指针的位置即可，若小于target，左指针右移一位，若大于target，右指针左移一位，以此类推直至两个指针相遇停止。
     */
    public int[] twoSum3(int[] numbers, int target)
    {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right)
        {
            int t = numbers[left] + numbers[right];
            if (t == target)
                return new int[]{left + 1, right + 1};
            else if (t < target)
                left++;
            else
                right--;
        }
        return null;
    }

    public static void main(String[] args)
    {
        _167 test = new _167();
        int[] arr = test.twoSum2(new int[]{2, 3, 4}, 6);
        for (int i : arr)
        {
            System.out.println(i);
        }
    }
}
