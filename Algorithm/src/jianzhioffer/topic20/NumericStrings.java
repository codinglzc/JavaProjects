package jianzhioffer.topic20;

/**
 * @description: 面试题20：表示数值的字符串
 * 题目：请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如：字符串"+100"、"5e2"、"-123"、"3.1416" 及 "-1E-16" 都表示数值，但 "12e"、"1a3.14"、"1.2.3"、"+-5" 及 "1.2e+5.4"都不是。
 * @author: Liu Cong
 * @create: Created at 2018-06-24
 */
public class NumericStrings
{
    private static int index;

    /**
     * 表示数值的字符串遵循模式 A[.[B]][e|EC] 或者 .B[e|EC]，其中，
     * A：数值的整数部分
     * B：紧跟着小数点，为数值的小数部分
     * C：紧跟着'e'或'E'，为数值的指数部分
     * 并且，A 和 C 都是整数（可以有正负号，也可以没有），而 B 是一个无符号整数
     * <p>
     * 步骤：
     * 1.先扫描A部分
     * 2.如果遇到小数点，则扫描表示小数部分的B部分
     * 3.如果遇到'e'或'E'，则扫描表示指数的C部分
     *
     * @param str 字符串
     * @return Boolean
     */
    public static boolean isNumeric(String str)
    {
        if (str == null) return false;
        index = 0;

        // 扫描 A 部分
        boolean numeric = scanInteger(str);

        // 如果出现'.'，则接下来是数字的小数部分 B
        if (index >= 0 && index < str.length() && str.charAt(index) == '.')
        {
            index++;

            // 下面一行代码用 || 的原因：
            // 1.小数可以没有整数部分，如 .123 等于 0.123；
            // 2.小数点后面可以没有数字，如 233. 等于 233.0；
            // 3.当然，小数点前面和后面可以都有数字，如 233.666
            numeric = scanUnsignedInteger(str) || numeric;
        }

        // 如果出现 'e' 或 'E'，则接下来是数字的指数部分
        if (index >= 0 && index < str.length() && (str.charAt(index) == 'e' || str.charAt(index) == 'E'))
        {
            index++;

            // 下面一行代码用 && 的原因：
            // 1.当 e 或 E 前面没有数字时，整个字符串不能表示数字，如 .e1、e1；
            // 2.当 e 或 E 后面没有数字时，整个字符串不能表示数字，如 12e、12e+5.4
            numeric = scanInteger(str) && numeric;
        }

        return numeric && index == str.length();
    }

    /**
     * 用来扫描字符串中 0~9 的数位（类似于一个无符号整数），可以用来匹配前面数值模式中的 B 部分
     */
    private static boolean scanInteger(String str)
    {
        if (index < 0 || index >= str.length()) return false;

        if (str.charAt(index) == '+' || str.charAt(index) == '-')
            index++;

        // 当 str 中存在若干 0~9 的数字时，返回 true
        return scanUnsignedInteger(str);
    }

    /**
     * 用来以正负号为起始的 0~9 数字（类似于一个可能带正负号的整数）
     */
    private static boolean scanUnsignedInteger(String str)
    {
        if (index < 0 || index >= str.length()) return false;

        int before = index;
        while (index < str.length() && str.charAt(index) >= '0' && str.charAt(index) <= '9')
            index++;
        return index > before;
    }

    public static void main(String[] args)
    {
        System.out.println(isNumeric(null));
        System.out.println(isNumeric(""));
        System.out.println(isNumeric("+100"));
        System.out.println(isNumeric("5e2"));
        System.out.println(isNumeric("-123"));
        System.out.println(isNumeric("3.1416"));
        System.out.println(isNumeric("-1E-16"));
        System.out.println(isNumeric("12e"));
        System.out.println(isNumeric("1a3.14"));
        System.out.println(isNumeric("1.2.3"));
        System.out.println(isNumeric("+-5"));
        System.out.println(isNumeric("1.2e+5.4"));
    }
}