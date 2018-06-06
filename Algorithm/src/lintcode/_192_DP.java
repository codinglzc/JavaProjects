package lintcode;

/**
 * @Description: 192. 通配符匹配
 * 判断两个可能包含通配符“？”和“*”的字符串是否匹配。匹配规则如下：
 * · '?' 可以匹配任何单个字符。
 * · '*' 可以匹配任意字符串（包括空字符串）。
 * 两个串完全匹配才算匹配成功。
 * 函数接口如下:
 * bool isMatch(const char *s, const char *p)
 * <p>
 * 样例:
 * 一些例子：
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "*") → true
 * isMatch("aa", "a*") → true
 * isMatch("ab", "?*") → true
 * isMatch("aab", "c*a*b") → false
 * @Author: lc
 * @Date: Created in 2018/3/16
 */
public class _192_DP
{
    /**
     * dpMatch: 动态规划解决匹配字符串的问题
     *
     * @param s
     * @param p
     * @return boolean  返回类型
     */
    public boolean dpMatch(String s, String p)
    {
        if (s == null || p == null)
        {
            return false;
        }
        //单独处理字符s为空的情况
        if (s.length() == 0)
        {
            if (p.length() == 0)
            {
                return true;
            }
            int j = 0;
            while (j < p.length() && p.charAt(j) == '*')
            {
                j++;
            }
            return j == p.length();
        }
        //数组，保存动态规划的结果
        boolean[][] result = new boolean[s.length()][p.length()];
        //首先初始化结果数组
        init(result, s, p);
        for (int i = 1; i < s.length(); i++)
        {
            for (int j = 1; j < p.length(); j++)
            {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')
                {
                    result[i][j] = result[i - 1][j - 1];
                } else if (p.charAt(j) == '*')
                {
                    result[i][j] = result[i - 1][j] || result[i][j - 1];
                }
            }
        }
        return result[s.length() - 1][p.length() - 1];
    }

    /**
     * init: 初始化数组
     *
     * @param result
     * @param s
     * @param p      void  返回类型
     */
    private void init(boolean[][] result, String s, String p)
    {
        //首先初始化第一个匹配传和第一个字符串的匹配情况
        if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '?' || p.charAt(0) == '*')
        {
            result[0][0] = true;
        }
        //初始化第一个字符串中字符和前j个匹配串的匹配情况
        for (int j = 1; j < p.length(); j++)
        {
            if (p.charAt(j) != '*')
            {
                break;
            }
            result[0][j] = true;
        }
        //初始化第一个匹配串中字符和前i个字符串中字符的匹配情况
        if (p.charAt(0) == '*')
        {
            for (int i = 1; i < s.length(); i++)
            {
                result[i][0] = true;
            }
        }
    }

    public static void main(String[] args)
    {
        _192_DP obj = new _192_DP();
        obj.dpMatch("aab", "c*a*b");
    }
}
