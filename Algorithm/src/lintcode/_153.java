package lintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 153. 数字组合 II
 * 给出一组候选数字(C)和目标数字(T),找出C中所有的组合，使组合中数字的和为T。C中每个数字在每个组合中只能使用一次。
 * <p>
 * 注意事项：
 * · 所有的数字(包括目标数字)均为正整数。
 * · 元素组合(a1, a2, … , ak)必须是非降序(ie, a1 ≤ a2 ≤ … ≤ ak)。
 * · 解集不能包含重复的组合。
 * <p>
 * 样例：
 * 给出一个例子，候选数字集合为[10,1,6,7,2,1,5] 和目标数字 8  ,
 * 解集为：[[1,7],[1,2,5],[2,6],[1,1,6]]
 * @Author: lc
 * @Date: Created in 2018/3/16
 */
public class _153
{
    /**
     * @param num:    Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target)
    {
        // write your code here
        Arrays.sort(num);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        recur(num, target, res, temp, 0);
        return res;
    }

    public void recur(int[] num, int target, List<List<Integer>> res, List<Integer> temp, int index)
    {
        if (target == 0)
        {
            List<Integer> item = new ArrayList<>(temp);
            if (!res.contains(item))
                res.add(item);
            return;
        }

        if (target < 0) return;

        for (int i = index; i < num.length; i++)
        {
            temp.add(num[i]);
            recur(num, target - num[i], res, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
