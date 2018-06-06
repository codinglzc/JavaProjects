package leetcode.array;

/**
 * @Description: 168. Excel Sheet Column Title
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * <p>
 * For example:
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 * @Author: lc
 * @Date: Created in 2017/12/13
 */
public class _168
{
    /**
     * 注意字母对应的数字是从1开始的
     * <p>
     * 递归求解
     */
    public String convertToTitle1(int n)
    {
        String[] str = new String[]{"", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O",
                "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        if (n <= 26)
            return str[n];
        else
            return (n % 26) == 0 ? (convertToTitle1(n / 26 - 1) + str[26]) : (convertToTitle1(n / 26) + str[n % 26]);
    }

    /**
     * 循环求解
     */
    public String convertToTitle2(int n)
    {
        StringBuilder sb = new StringBuilder();
        while (n > 0)
        {
            n--;
            sb.append((char) (n % 26 + 'A'));
            n /=26;
        }
        sb.reverse();
        return sb.toString();
    }
}
