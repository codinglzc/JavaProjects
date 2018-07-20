package jianzhioffer.topic48;

/**
 * <p>
 * 面试题48：最长不含重复字符的子字符串（P.236）
 * 题目：请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * 假设字符串中只包含 'a' ~ 'z' 的字符。
 * 例如，在字符串 "arabcacfr" 中，最长的不含重复字符的子字符串是 "acfr"，长度为 4 。
 * </p>
 *
 * @author Liu Cong
 * @since 2018-07-16
 */
public class LongestSubstringWithoutDup
{
    public static int longestSubstringWithoutDuplication(String str)
    {
        int maxLen = 0;
        int curLen = 0;
        int[] position = new int[24];
        for (int i = 0; i < position.length; i++)
        {
            position[i] = -1;
        }
        char[] chs = str.toCharArray();
        for (int i = 0; i < chs.length; i++)
        {
            int pos = position[chs[i] - 'a'];
            if (pos == -1 || i - pos > curLen)
                curLen++;
            else
            {
                maxLen = curLen > maxLen ? curLen : maxLen;
                curLen = i - pos;
            }
            position[chs[i] - 'a'] = i;
        }

        return maxLen > curLen ? maxLen : curLen;
    }

    public static void main(String[] args)
    {
        System.out.println(longestSubstringWithoutDuplication("arabcacfr"));
    }
}
