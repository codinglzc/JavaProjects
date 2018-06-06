package lintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 18. 带重复元素的子集
 * 给定一个可能具有重复数字的列表，返回其所有可能的子集
 * <p>
 * 注意事项：
 * 1. 子集中的每个元素都是非降序的
 * 2. 两个子集间的顺序是无关紧要的
 * 3. 解集中不能包含重复子集
 * <p>
 * 样例：
 * 如果 S = [1,2,2]，一个可能的答案为：
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 * @Author: lc
 * @Date: Created in 2018/3/9
 */
public class _18
{
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums)
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
            List<Integer> list = new ArrayList<>(temp);
            if (!res.contains(list))
                res.add(list);
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
