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
public class _192
{
    /**
     * dfs算法解决此问题超时，考虑使用dp算法
     * @param s: A string
     * @param p: A string includes "?" and "*"
     * @return: is Match?
     */
    public boolean isMatch(String s, String p)
    {
        // write your code here
        StringBuilder sb = new StringBuilder();
        char[] p_arr = p.toCharArray();
        for (int i = 0; i < p_arr.length; i++)
        {
            if (i > 0 && p_arr[i] == '*' && p_arr[i - 1] == '*') continue;
            sb.append(p_arr[i]);
        }
        System.out.println(sb.toString());
        return recur(s, sb.toString(), 0, 0);
    }

    public boolean recur(String s, String p, int s_index, int p_index)
    {
        System.out.println(s_index + "/t" + p_index);
        if (s_index == s.length() && p_index == p.length()) return true;
        if (s_index < s.length() && p_index == p.length()) return false;
        if (s_index == s.length() && p_index < p.length())
        {
            if (p.charAt(p_index) == '*')
                return recur(s, p, s_index, p_index + 1);
            else return false;
        }

        char s_char = s.charAt(s_index);
        char p_char = p.charAt(p_index);
        if (p_char == '*')
        {
            boolean flag = false;
            for (int i = s_index; i <= s.length(); i++)
            {
                flag = flag || recur(s, p, i, p_index + 1);
                if (flag) break;
            }
            return flag;
        } else if (p_char == '?')
        {
            return recur(s, p, s_index + 1, p_index + 1);
        } else
        {
            return p_char == s_char ? recur(s, p, s_index + 1, p_index + 1) : false;
        }
    }

    public static void main(String[] args)
    {
        _192 obj = new _192();
        String s = "abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb";
        String p = "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb";
        System.out.println(obj.isMatch(s, p));
    }
}
