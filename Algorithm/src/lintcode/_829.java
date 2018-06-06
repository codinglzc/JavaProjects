package lintcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:829. Word Pattern II
 * Given a `pattern` and a string `str`, find if `str` follows the same pattern.
 * <p>
 * Here *follow* means a full match, such that there is a bijection between a letter in `pattern` and a *non-empty*
 * substring in `str`.
 * (i.e if `a` corresponds to `s`, then `b` cannot correspond to `s`.
 * For example, given pattern = "ab", str = "ss", return `false`.)
 * <p>
 * 注意事项：
 * You may assume both pattern and str contains only lowercase letters.
 * <p>
 * 样例：
 * Given pattern = "abab", str = "redblueredblue", return true.
 * Given pattern = "aaaa", str = "asdasdasdasd", return true.
 * Given pattern = "aabb", str = "xyzabcxzyabc", return false.
 * @Author: lc
 * @Date: Created in 2018/3/19
 */
public class _829
{
    /**
     * @param pattern: a string,denote pattern string
     * @param str:     a string, denote matching string
     * @return: a boolean
     */
    public boolean wordPatternMatch(String pattern, String str)
    {
        // write your code here
        if (pattern.length() == 0 && str.length() == 0) return true;
        if (pattern.length() == 0 || str.length() == 0) return false;

        Map<String, String> map = new HashMap<>();
        return recur(pattern, str, map, 0, 0);
    }

    public boolean recur(String pattern, String str, Map<String, String> map, int pi, int si)
    {
        if (pi == pattern.length() && si == str.length()) return true;
        if (pi == pattern.length() || si == str.length()) return false;

        String key = pattern.substring(pi, pi + 1);

        if (map.containsKey(key))
        {
            String val = map.get(key);
            int valLen = val.length();
            if (si + valLen <= str.length() && str.substring(si, si + valLen).equals(val))
                return recur(pattern, str, map, pi + 1, si + valLen);
            return false;
        }

        boolean flag = false;
        for (int i = si + 1; i <= str.length(); i++)
        {
            if (flag) break;
            String val = str.substring(si, i);
            if (map.containsValue(val)) break;
            map.put(key, val);
            flag = flag || recur(pattern, str, map, pi + 1, i);
            map.remove(key);
        }
        return flag;
    }
}
