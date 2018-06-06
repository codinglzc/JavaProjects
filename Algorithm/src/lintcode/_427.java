package lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 427. 生成括号
 * 给定 n 对括号，请写一个函数以将其生成新的括号组合，并返回所有组合结果。
 * <p>
 * 样例：
 * 给定 n = 3, 可生成的组合如下:
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 * @Author: lc
 * @Date: Created in 2018/3/14
 */
public class _427
{
    /**
     * @param n: n pairs
     * @return: All combinations of well-formed parentheses
     */
    public List<String> generateParenthesis(int n)
    {
        // write your code here
        List<String> res = new ArrayList<>();
        recur(res, n, n, "");
        return res;
    }

    public void recur(List<String> res, int left, int right, String temp)
    {
        if (left < 0 || right < 0 || left > right) return;

        if (left == 0 && right == 0)
        {
            res.add(temp);
            return;
        }

        if (left == 0)
        {
            while (right > 0)
            {
                temp += ")";
                right--;
            }
            res.add(temp);
            return;
        }

        recur(res, left - 1, right, temp + "(");
        recur(res, left, right - 1, temp + ")");
    }
}
