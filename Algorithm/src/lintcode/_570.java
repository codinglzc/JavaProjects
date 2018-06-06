package lintcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description: 570. 寻找丢失的数 II
 * 给一个由 1 - n 的整数随机组成的一个字符串序列，其中丢失了一个整数，请找到它。
 * <p>
 * 注意事项：
 * n <= 30
 * <p>
 * 样例：
 * 给出 n = 20, str = 19201234567891011121314151618
 * 丢失的数是 17 ，返回这个数。
 * @Author: lc
 * @Date: Created in 2018/3/16
 */
public class _570
{
    /**
     * @param n:   An integer
     * @param str: a string with number from 1-n in random order and miss one number
     * @return: An integer
     */
    public int findMissing2(int n, String str)
    {
        // write your code here
        List<Set<Integer>> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        recur(n, str, res, set, 0);
        if (res.size() > 0)
        {
            for (int i = 1; i <= n; i++)
            {
                if (!res.get(0).contains(i)) return i;
            }
        }
        return 0;
    }

    public void recur(int n, String str, List<Set<Integer>> res, Set<Integer> set, int index)
    {
        if (index == str.length() && set.size() == n - 1)
        {
            res.add(new HashSet<>(set));
            return;
        }

        int len = n < 10 ? 1 : 2;
        for (int i = 1; i <= len; i++)
        {
            if (index + i > str.length()) return;
            String sub = str.substring(index, index + i);
            if (sub.startsWith("0")) return;
            int num = Integer.valueOf(sub);
            if (num > n || set.contains(num)) continue;
            set.add(num);
            recur(n, str, res, set, index + i);
            set.remove(num);
        }
    }

    public static void main(String[] args)
    {
        _570 obj = new _570();
        int res = obj.findMissing2(20, "19201234567891011121314151618");
        System.out.println(res);
    }
}
