package jianzhioffer.topic16;

/**
 * @description: 面试题16：数值的整数次方
 * 题目：实现函数 double Power(double base, int exponent)，求 base 的 exponent 次方。不得使用库函数，同时不需要考虑大数问题。
 * @author: Liu Cong
 * @create: Created at 2018-06-22
 */
public class Power
{
    /**
     * 考虑到特殊情况：
     * 1.base 为 0，exponent 小于 0，对计算无意义。
     * 2.当 exponent 小于 0 时，应该先求正数次方，然后再求倒。
     *
     * @param base     基数
     * @param exponent 指数（可正、可为0,、可为正）
     * @return 结果
     * @throws Exception 输入异常
     */
    public static double power(double base, int exponent) throws Exception
    {
        if (base == 0.0 && exponent < 0)
            throw new Exception("InvalidInput");

        int absExponent = exponent >= 0 ? exponent : -exponent;

        double result = powerWithPositiveExponent(base, absExponent);

        if (exponent < 0) result = 1.0 / result;

        return result;
    }

    /**
     * 采用如下公式求 a 的 n 次方：
     * 1.如果 n 为偶数，那么 power(a, n) = power(a, n/2) * power(a, n/2)
     * 2.如果 n 为奇数，那么 power(a, n) = power(a, (n-1)/2) * power(a, (n-1)/2) * a
     * <p>
     * 时间复杂度：O(logn)
     *
     * @param base        基数
     * @param absExponent 正指数
     * @return 结果
     */
    private static double powerWithPositiveExponent(double base, int absExponent)
    {
        if (absExponent == 0) return 1;

        if (absExponent == 1) return base;

        // 用右移运算代替了除以 2
        double result = powerWithPositiveExponent(base, absExponent >> 1);
        result *= result;

        // 用位与运算符代替了求余运算符(%)来判断一个数是奇数还是偶数
        if ((absExponent & 0x1) == 1) result *= base;

        return result;
    }
}
