package lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 136. 分割回文串
 * 给定一个字符串s，将s分割成一些子串，使每个子串都是回文串。
 * 返回s所有可能的回文串分割方案。
 * <p>
 * 样例：
 * 给出 s = "aab"，返回
 * [
 * ["aa", "b"],
 * ["a", "a", "b"]
 * ]
 * @Author: lc
 * @Date: Created in 2018/3/15
 */
public class _136
{
    /*
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s)
    {
        // write your code here
        List<List<String>> res = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        recur(s, res, temp, 0);
        return res;
    }

    public void recur(String s, List<List<String>> res, List<String> temp, int index)
    {
        if (index == s.length())
        {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int j = index + 1; j <= s.length(); j++)
        {
            String str = s.substring(index, j);
            if (isPalindrome(str))
            {
                temp.add(str);
                recur(s, res, temp, j);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String str)
    {
        for (int i = 0; i < str.length() / 2; i++)
        {
            if (str.charAt(i) != str.charAt(str.length() - i - 1))
                return false;
        }
        return true;
    }
}
