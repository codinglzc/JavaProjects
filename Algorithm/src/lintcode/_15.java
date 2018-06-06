package lintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 15. 全排列
 * 给定一个数字列表，返回其所有可能的排列。
 * <p>
 * 注意事项：
 * 你可以假设没有重复数字。
 * <p>
 * 样例：
 * 给出一个列表[1,2,3]，其全排列为：
 * <p>
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * @Author: lc
 * @Date: Created in 2018/3/9
 */
public class _15
{
    /*
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums)
    {
        // write your code here
        if (nums == null || nums.length == 0)
        {
            List<Integer> list = new ArrayList<>();
            res.add(list);
        }
        Arrays.sort(nums);
        recursive(nums, 0, nums.length - 1);
        return res;
    }

    public void recursive(int[] nums, int start, int end)
    {
        if (start == end)
        {
            List<Integer> list = new ArrayList<>();
            for (int n : nums)
                list.add(n);
            res.add(list);
        } else
        {
            for (int i = start; i <= end; i++)
            {
                swap(nums, start, i);
                recursive(nums, start + 1, end);
                swap(nums, start, i);
            }
        }
    }

    public void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
