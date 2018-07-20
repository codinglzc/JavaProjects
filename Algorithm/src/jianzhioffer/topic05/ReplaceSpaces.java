package jianzhioffer.topic05;

/**
 * @description: 面试题5：替换空格（P.51）
 * 题目：请实现一个函数，把字符串中的每个空格替换成"%20"。例如，输入"We are happy."，则输出"We%20are%20happy."。
 * <p>
 * 要求：给定一个字符数组char[]，并假定字符数组的长度大于替换后字符串长度,且以'\0'结尾，算法要求空间复杂度为O(1)，即不能重新创建新数组。
 * @author: Liu Cong
 * @create: Created at 2018-06-13
 */
public class ReplaceSpaces
{

    /**
     * 分析：如果从头到尾扫描字符数组，每次碰到空格字符的时候进行替换。由于是把1个字符替换成3个字符，我们必须要把空格后面所有的字符都后移
     * 2个字节，否则就有两个字符被覆盖了。假设字符数组的长度是n。对每个空格字符，需要移动后面O(n)个字符，因此对于含有O(n)个空格字符的字
     * 符数组而言，总的时间效率是O(n²)。
     * <p>
     * 时间复杂度为O(n)的解法：从后面开始遍历字符数组。
     *
     * @param chars
     */
    public static void solution(char[] chars)
    {
        if (chars == null || chars.length <= 0) return;

        int oldLength = 0;
        int numberOfSpace = 0;
        while (chars[oldLength] != '\0')
        {
            if (chars[oldLength] == ' ') numberOfSpace++;
            oldLength++;
        }

        int lastIndexOfOldChars = oldLength - 1;
        int lastIndexOfNewChars = numberOfSpace * 2 + lastIndexOfOldChars;
        for (int i = lastIndexOfOldChars; i >= 0; i--)
        {
            if (chars[i] == ' ')
            {
                chars[lastIndexOfNewChars--] = '0';
                chars[lastIndexOfNewChars--] = '2';
                chars[lastIndexOfNewChars--] = '%';
            } else
            {
                chars[lastIndexOfNewChars--] = chars[i];
            }
        }
    }
}
