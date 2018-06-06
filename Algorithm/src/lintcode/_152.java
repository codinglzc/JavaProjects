package lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 152. 组合
 * 组给出两个整数n和k，返回从1......n中选出的k个数的组合。
 * <p>
 * 样例：
 * 例如 n = 4 且 k = 2
 * 返回的解为：
 * [[2,4],[3,4],[2,3],[1,2],[1,3],[1,4]]
 * @Author: lc
 * @Date: Created in 2018/3/15
 */
public class _152
{
    /**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */
    public List<List<Integer>> combine(int n, int k)
    {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        recur(n, k, res, temp, 1);
        return res;
    }

    public void recur(int n, int k, List<List<Integer>> res, List<Integer> temp, int index)
    {
        if (temp.size() == k)
        {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i <= n; i++)
        {
            temp.add(i);
            recur(n, k, res, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
