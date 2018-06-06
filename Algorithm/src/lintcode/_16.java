package lintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 16. 带重复元素的排列
 * 给出一个具有重复数字的列表，找出列表所有不同的排列。
 * <p>
 * 样例：
 * 给出列表 [1,2,2]，不同的排列有：
 * <p>
 * [
 * [1,2,2],
 * [2,1,2],
 * [2,2,1]
 * ]
 * @Author: lc
 * @Date: Created in 2018/3/9
 */
public class _16
{
    /*
     * @param :  A list of integers
     * @return: A list of unique permutations
     */

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums)
    {
        // write your code here
        if (nums == null || nums.length == 0)
        {
            List<Integer> list = new ArrayList<>();
            res.add(list);
            return res;
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
            if (!res.contains(list))
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
