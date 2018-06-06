package lintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 17. 子集
 * 给定一个含不同整数的集合，返回其所有的子集
 * <p>
 * 注意事项：
 * 子集中的元素排列必须是非降序的，解集必须不包含重复的子集
 * <p>
 * 样例：
 * 如果 S = [1,2,3]，有如下的解：
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 * @Author: lc
 * @Date: Created in 2018/3/9
 */
public class _17
{
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums)
    {
        // write your code here
        Arrays.sort(nums);
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++)
        {
            temp.clear();
            dfs(nums, 0, i, temp);
        }
        return res;
    }

    public void dfs(int[] nums, int start, int size, List<Integer> temp)
    {
        if (temp.size() == size)
        {
            res.add(new ArrayList<>(temp));
        } else
        {
            for (int i = start; i < nums.length; i++)
            {
                temp.add(nums[i]);
                dfs(nums, i + 1, size, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
