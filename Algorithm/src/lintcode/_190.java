package lintcode;

/**
 * @Description: 同52
 * @Author: lc
 * @Date: Created in 2018/3/6
 */
public class _190
{
    /*
     * @param nums: An array of integers
     * @return: nothing
     */
    public static void nextPermutation(int[] nums)
    {
        // write your code here
        boolean flag = true;
        for (int i = nums.length - 1; i > 0; i--)
        {
            // 从右向左寻找升序的转折点 i
            if (nums[i] > nums[i - 1])
            {
                flag = false;
                // 从右向左寻找第一个大于nums.get(i-1)的数，然后交换
                for (int j = nums.length - 1; j >= i; j--)
                {
                    if (nums[j] > nums[i - 1])
                    {
                        int temp = nums[j];
                        nums[j] = nums[i - 1];
                        nums[i - 1] = temp;
                        break;
                    }
                }
                // 倒置i到nums.size()-1的数组
                inverted(nums, i, nums.length - 1);
                break;
            }
        }

        if (flag)
        {
            inverted(nums, 0, nums.length - 1);
        }
    }

    public static void inverted(int[] nums, int left, int right)
    {
        while (left < right)
        {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args)
    {
        int[] nums = {2, 2, 7, 5, 4, 3, 2, 2, 1};
        _190.nextPermutation(nums);
    }
}
