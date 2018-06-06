package leetcode.array;

/**
 * @Description: 27. Remove Element
 * <p>
 * Given an array and a value, remove all instances of that value in-place and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * <p>
 * Example:
 * Given nums = [3,2,2,3], val = 3,
 * Your function should return length = 2, with the first two elements of nums being 2.
 * @Author: lc
 * @Date: Created in 2018/1/9
 */
public class _27
{
    public int removeElement1(int[] nums, int val)
    {
        int index = 0;
        int result = nums.length;
        while (index < result)
        {
            if (val == nums[index])
            {
                int temp = nums[index];
                nums[index] = nums[result - 1];
                nums[result - 1] = temp;
                result--;
            } else
                index++;
        }
        return result;
    }

    public int removeElement2(int[] nums, int val)
    {
        int begin = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] != val)
                nums[begin++] = nums[i];
        }
        return begin;
    }
}
