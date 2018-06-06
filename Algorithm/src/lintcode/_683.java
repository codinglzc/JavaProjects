package lintcode;

import java.util.Set;

/**
 * @Description:683. 单词拆分 III
 * 给出一个单词表和一条去掉所有空格的句子，根据给出的单词表添加空格, 返回可以构成的句子的数量, 保证构成的句子中所有的单词都可以在单词表中找到.
 * <p>
 * 注意事项：
 * 忽略大小写
 * <p>
 * 样例：
 * 给一个字符串 CatMat, 给出字典 ["Cat", "Mat", "Ca", "tM", "at", "C", "Dog", "og", "Do"], 返回 3
 * 我们可以构成一下 3 条语句: CatMat = Cat Mat CatMat = Ca tM at CatMat = C at Mat
 * @Author: lc
 * @Date: Created in 2018/3/19
 */
public class _683
{
    /*
     * @param : A string
     * @param : A set of word
     * @return: the number of possible sentences.
     */

    //private int count = 0;

    public int wordBreak3(String s, Set<String> dict)
    {
        // Write your code here
        int[] res = new int[1];
        res[0] = 0;
        recur(s, dict, res, 0, s.length());
        return res[0];
    }

    public void recur(String s, Set<String> dict, int[] res, int index, int len)
    {
        if (index == len)
        {
            res[0] += 1;
            return;
        }

        int maxLen = Integer.MIN_VALUE;
        int minLen = Integer.MAX_VALUE;
        for (String str : dict)
        {
            if (str.startsWith(s.substring(index, index + 1))) ;
            {
                maxLen = maxLen > str.length() ? maxLen : str.length();
                minLen = minLen < str.length() ? minLen : str.length();
            }
        }

        for (int i = minLen; i <= maxLen; i++)
        {
            if (index + i > len) break;
            String sub = s.substring(index, index + i);
            if (dict.contains(sub))
            {
                recur(s, dict, res, index + i, len);
            }
        }
    }
}
