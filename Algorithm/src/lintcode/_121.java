package lintcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @Description: 121. 单词接龙 II
 * 给出两个单词（start和end）和一个字典，找出所有从start到end的最短转换序列
 * <p>
 * 比如：
 * 1. 每次只能改变一个字母。
 * 2. 变换过程中的中间单词必须在字典中出现。
 * 注意事项：
 * · 所有单词具有相同的长度。
 * · 所有单词都只包含小写字母。
 * <p>
 * 样例
 * 给出数据如下：
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * <p>
 * 返回
 * [
 * ["hit","hot","dot","dog","cog"],
 * ["hit","hot","lot","log","cog"]
 * ]
 * @Author: lc
 * @Date: Created in 2018/3/15
 */
public class _121
{
    /* 这个方法会超时。
     *
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: a list of lists of string
     */
    public List<List<String>> findLadders(String start, String end, Set<String> dict)
    {
        // write your code here
        List<List<String>> res = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        temp.add(start);
        DFS(res, temp, start, end, dict);
        return res;
    }

    public void DFS(List<List<String>> res, List<String> temp, String start, String end, Set<String> dict)
    {
        if (res.size() > 0 && res.get(0).size() < temp.size() + 1) return;

        if (isSeq(start, end))
        {
            temp.add(end);
            staySmallest(res, temp);
            temp.remove(temp.size() - 1);
            return;
        }

        for (String str : dict)
        {
            if (temp.contains(str)) continue;
            if (temp.size() <= 0 || isSeq(str, temp.get(temp.size() - 1)))
            {
                temp.add(str);
                DFS(res, temp, str, end, dict);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public boolean isSeq(String str1, String str2)
    {
        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();
        int count = 0;
        if (c1.length != c2.length) return false;
        for (int i = 0; i < c1.length; i++)
        {
            if (c1[i] != c2[i]) count++;
            if (count == 2) return false;
        }
        return count == 1;
    }

    public void staySmallest(List<List<String>> res, List<String> temp)
    {
        if (res.size() <= 0)
        {
            res.add(new ArrayList<>(temp));
            return;
        } else
        {
            if (res.get(0).size() < temp.size()) return;
            if (res.get(0).size() == temp.size())
            {
                res.add(new ArrayList<>(temp));
                return;
            }
            if (res.get(0).size() > temp.size())
            {
                res.clear();
                res.add(new ArrayList<>(temp));
                return;
            }
        }
    }
}
