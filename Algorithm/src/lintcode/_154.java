package lintcode;

/**
 * @Description: 154. 正则表达式匹配
 * Implement regular expression matching with support for '.' and '*'.
 * -------------------------------------------------
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 * The function prototype should be:
 * bool isMatch(string s, string p)
 * -------------------------------------------------
 * <p>
 * 样例：
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab", "c*a*b") → true
 * @Author: lc
 * @Date: Created in 2018/3/16
 */
public class _154
{
    /**
     * @param s: A string
     * @param p: A string includes "." and "*"
     * @return: A boolean
     */
    public boolean isMatch(String s, String p)
    {
        // write your code here
        return recur(s, p, 0, 0);
    }

    public boolean recur(String s, String p, int s_index, int p_index)
    {
        if (s_index == s.length() && p_index == p.length()) return true;
        if (s_index < s.length() && p_index == p.length()) return false;
        if (s_index == s.length() && p_index < p.length()) return false;

        char s_char = s.charAt(s_index);
        char p_char = p.charAt(p_index);
        if (p_char == '.')
        {
            if (p_index + 1 < p.length() && p.charAt(p_index + 1) == '*')
            {
                boolean flag = false;
                for (int i = s_index; i <= s.length(); i++)
                {
                    flag = flag || recur(s, p, i, p_index + 2);
                    if (flag) break;
                }
                return flag;
            }
            return recur(s, p, s_index + 1, p_index + 1);
        } else
        {
            if (p_index + 1 < p.length() && p.charAt(p_index + 1) == '*')
            {
                boolean flag = false;
                for (int i = s_index; i <= s.length(); i++)
                {
                    flag = flag || recur(s, p, i, p_index + 2);
                    if ((i < s.length() && s.charAt(i) != p_char) || flag) break;
                }
                return flag;
            }
            return s_char == p_char ? recur(s, p, s_index + 1, p_index + 1) : false;
        }
    }
}
