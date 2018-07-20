package jianzhioffer.topic44;

/**
 * <p>
 * 面试题44：数字序列中某一位的数字（P.225）
 * 题目：数字以 0123456789101112131415···的格式序列化到一个字符序列中。在这个序列中，第 5 位（从 0 开始计数）是 5，第 13 位是 1，
 * 第 19 位是 4，等等。请写一个函数，求任意第 n 为对应的数字。
 * </p>
 *
 * @author Liu Cong
 * @since 2018-07-13
 */
public class DigitsInSequence
{
    public static int digitAtIndex(int index)
    {
        if (index < 0)
            throw new IllegalArgumentException();

        int digits = 1;
        while (true)
        {
            int numbers = countOfIntegers(digits);
            if (index < numbers * digits)
                return digitAtIndex(index, digits);
            index -= numbers * digits;
            digits++;
        }
    }

    /**
     * 当我们知道要找的那一位数字位于某m位数之中后，就可以用如下函数找出去那一位数字
     */
    private static int digitAtIndex(int index, int digits)
    {
        int number = beginNumber(digits) + index / digits;
        int indexFromRight = digits - index % digits;
        for (int i = 1; i < indexFromRight; i++)
        {
            number /= 10;
        }
        return number % 10;
    }

    /**
     * 得到m位数的第一个数字。
     * 例如，第一个两位数是10；第一个三位数是100。
     * @param digits 位数
     * @return 数字
     */
    private static int beginNumber(int digits)
    {
        if (digits == 1) return 0;

        return (int) Math.pow(10, digits - 1);
    }

    /**
     * 得到 m 位的数字总共有多少个？
     * 例如，输入2，则返回两位数（10~99）的个数90；输入3，则返回三位数（100~999）的个数900.
     *
     * @param digits 位数
     * @return 个数
     */
    private static int countOfIntegers(int digits)
    {
        if (digits == 1) return 10;

        return (int) (9 * Math.pow(10, digits - 1));
    }

    public static void main(String[] args)
    {
        System.out.println(digitAtIndex(1001));
    }
}
