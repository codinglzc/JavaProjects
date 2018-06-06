package lintcode;

/**
 * @Description: 52. 下一个排列
 * 给定一个整数数组来表示排列，找出其之后的一个排列。
 * <p>
 * 注意事项:
 * 排列中可能包含重复的整数
 * <p>
 * 样例:
 * 给出排列[1,3,2,3]，其下一个排列是[1,3,3,2]
 * 给出排列[4,3,2,1]，其下一个排列是[1,2,3,4]
 * @Author: lc
 * @Date: Created in 2018/3/6
 */
public class _52
{
    /**
     * @param nums: A list of integers
     * @return: A list of integers
     */
    public int[] nextPermutation(int[] nums)
    {
        // write your code here
        for (int i = nums.length - 1; i > 0; i--)
        {
            // 从右向左寻找升序的转折点 i
            if (nums[i] > nums[i - 1])
            {
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
                int left = i, right = nums.length - 1;
                while (left < right)
                {
                    int temp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = temp;
                    left++;
                    right--;
                }
                return nums;
            }
        }

        int left = 0, right = nums.length - 1;
        while (left < right)
        {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
        return nums;
    }
}
