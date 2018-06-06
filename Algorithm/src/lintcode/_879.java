package lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 879. Output Contest Matches
 * http://www.lintcode.com/zh-cn/problem/output-contest-matches/
 * @Author: lc
 * @Date: Created in 2018/3/19
 */
public class _879
{
    /**
     * @param n: a integer, denote the number of teams
     * @return: a string
     */
    public String findContestMatch(int n)
    {
        // write your code here
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++)
        {
            res.add(i + "");
        }
        recur(n, res);
        return res.get(0);
    }

    public void recur(int n, List<String> res)
    {
        if (res.size() == 1) return;

        int num = n / 2;
        for (int i = 0; i < num; i++)
        {
            res.set(i, "(" + res.get(i) + "," + res.get(n - 1 - i) + ")");
            res.remove(n - 1 - i);
        }
        recur(num, res);
    }
}
