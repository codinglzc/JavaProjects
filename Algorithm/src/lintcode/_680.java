package lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 680. 分割字符串
 * 给一个字符串,你可以选择在一个字符或两个相邻字符之后拆分字符串,使字符串由仅一个字符或两个字符组成,输出所有可能的结果
 * <p>
 * 样例：
 * 给一个字符串"123"
 * 返回[["1","2","3"],["12","3"],["1","23"]]
 * @Author: lc
 * @Date: Created in 2018/3/19
 */
public class _680
{
    /*
     * @param : a string to be split
     * @return: all possible split string array
     */
    public List<List<String>> splitString(String s)
    {
        // write your code here
        List<List<String>> res = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        recur(s, res, temp, 0, s.length());
        return res;
    }

    public void recur(String s, List<List<String>> res, List<String> temp, int index, int len)
    {
        if (index == len)
        {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 1; i <= 2; i++)
        {
            if (index + i > len) break;
            String sub = s.substring(index, index + i);
            temp.add(sub);
            recur(s, res, temp, index + i, len);
            temp.remove(temp.size() - 1);
        }
    }
}
