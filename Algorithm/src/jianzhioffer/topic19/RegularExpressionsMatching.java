package jianzhioffer.topic19;

/**
 * @description: 面试题19：正则表达式匹配
 * 题目：请实现一个函数用来匹配包含'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含 0 次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
 * @author: Liu Cong
 * @create: Created at 2018-06-24
 */
public class RegularExpressionsMatching
{
    /**
     * 主要是第二个字符是"*"时，情况比较复杂。
     * 在模式上有两种选择：可以在模式上向后移动两个字符，也可以保持模式不变。
     * 在字符串上也有两种类似的选择。
     * 两者求并集，但是不可以两者都为"保持不变状态"，即有三种选择的并集作为结果。
     *
     * @param str     字符串
     * @param pattern 匹配模式
     * @return boolean
     */
    public static boolean match(String str, String pattern)
    {
        if (str == null || pattern == null) return false;

        if (str.length() <= 0 && pattern.length() <= 0)
            return true;

        if (str.length() > 0 && pattern.length() <= 0)
            return false;

        return matchCore(str, 0, pattern, 0);
    }

    private static boolean matchCore(String str, int indexOfStr, String pattern, int indexOfPattern)
    {
        if (indexOfStr >= str.length() && indexOfPattern >= pattern.length()) return true;

        if (indexOfStr < str.length() && indexOfPattern >= pattern.length()) return false;

        if (indexOfPattern + 1 < pattern.length() && pattern.charAt(indexOfPattern + 1) == '*')
        {
            // 如果第二个字符是'*'
            if (indexOfStr < str.length() && (str.charAt(indexOfStr) == pattern.charAt(indexOfPattern)
                    || pattern.charAt(indexOfPattern) == '.'))
                return matchCore(str, indexOfStr + 1, pattern, indexOfPattern + 2) // move on the next state
                        || matchCore(str, indexOfStr + 1, pattern, indexOfPattern) // stay on the current state
                        || matchCore(str, indexOfStr, pattern, indexOfPattern + 2); // ingore a "*"
            else
                return matchCore(str, indexOfStr, pattern, indexOfPattern + 2); // ingore a "*"
        }

        if (indexOfPattern + 1 >= pattern.length() || pattern.charAt(indexOfPattern + 1) != '*')
        {
            // 如果第二个字符不是'*'
            if (indexOfStr < str.length() && (str.charAt(indexOfStr) == pattern.charAt(indexOfPattern)
                    || pattern.charAt(indexOfPattern) == '.'))
                return matchCore(str, indexOfStr + 1, pattern, indexOfPattern + 1);
        }
        return false;
    }

    public static void main(String[] args)
    {
        System.out.println(match("", ""));
        System.out.println(match(null, null));
        System.out.println(match("aaa", "a.a"));
        System.out.println(match("aaa", "ab*ac*a"));
        System.out.println(match("aaa", "aa.a"));
        System.out.println(match("aaa", "ab*a"));
        System.out.println(match("aaa", ""));
    }
}
