package lintcode;

import java.util.List;

/**
 * @Description: 51. 上一个排列
 * 给定一个整数数组来表示排列，找出其上一个排列。
 * <p>
 * 注意事项:
 * 排列中可能包含重复的整数
 * <p>
 * 样例:
 * 给出排列[1,3,2,3]，其上一个排列是[1,2,3,3]
 * 给出排列[1,2,3,4]，其上一个排列是[4,3,2,1]
 * @Author: lc
 * @Date: Created in 2018/3/6
 */
public class _51
{
    /*
     * @param nums: A list of integers
     * @return: A list of integers that's previous permuation
     */
    public List<Integer> previousPermuation(List<Integer> nums)
    {
        // write your code here
        for (int i = nums.size() - 1; i > 0; i--)
        {
            if (nums.get(i) < nums.get(i - 1))
            {
                for (int j = nums.size() - 1; j >= i; j--)
                {
                    if (nums.get(i - 1) > nums.get(j))
                    {
                        swap(nums, i - 1, j);
                        break;
                    }
                }
                swapList(nums, i, nums.size() - 1);
                return nums;
            }
        }
        swapList(nums, 0, nums.size() - 1);
        return nums;
    }

    private void swap(List<Integer> nums, int m, int n)
    {
        int t = nums.get(m);
        nums.set(m, nums.get(n));
        nums.set(n, t);
    }

    private void swapList(List<Integer> nums, int l, int r)
    {
        while (l < r)
        {
            swap(nums, l, r);
            l++;
            r--;
        }
    }
}
