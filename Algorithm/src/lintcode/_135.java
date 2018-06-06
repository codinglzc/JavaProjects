package lintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 135. 数字组合
 * 给出一个候选数字的set(C)和目标数字(T),找到C中所有的组合，使找出的数字和为T。C中的数字可以无限制重复被选取。
 * <p>
 * 例如,给出候选数组[2,3,6,7]和目标数字7，所求的解为：
 * [7]，
 * [2,2,3]
 * <p>
 * 注意事项：
 * · 所有的数字(包括目标数字)均为正整数。
 * · 元素组合(a1, a2, … , ak)必须是非降序(ie, a1 ≤ a2 ≤ … ≤ ak)。
 * · 解集不能包含重复的组合。
 * <p>
 * 样例：
 * 给出候选set[2,3,6,7]和目标数字7
 * 返回 [[7],[2,2,3]]
 * @Author: lc
 * @Date: Created in 2018/3/15
 */
public class _135
{
    /**
     * @param candidates: A list of integers
     * @param target:     An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target)
    {
        // write your code here
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        recur(candidates, target, res, temp);
        return res;
    }

    public void recur(int[] candidates, int target, List<List<Integer>> res, List<Integer> temp)
    {
        if (target == 0)
        {
            res.add(new ArrayList<>(temp));
            return;
        }

        if (target < 0) return;

        for (int c : candidates)
        {
            if (temp.size() >= 1 && c < temp.get(temp.size() - 1)) continue;
            if (c > target) break;
            temp.add(c);
            recur(candidates, target - c, res, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
