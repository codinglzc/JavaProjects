package lintcode;

/**
 * @Description: 428. x的n次幂
 * 实现 pow(x,n)
 * <p>
 * 样例：
 * Pow(2.1, 3) = 9.261
 * Pow(0, 1) = 0
 * Pow(1, 0) = 1
 * @Author: lc
 * @Date: Created in 2018/3/8
 */
public class _428
{
    /* -3 % 2 = -1
     * @param x: the base number
     * @param n: the power number
     * @return: the result
     */
    public double myPow(double x, int n)
    {
        // write your code here
        if (n == 0) return 1.0;
        if (n == 1) return x;
        if (n == -1) return 1.0 / x;

        double res = myPow(x, n / 2);
        res *= res;

        if (Math.abs(n % 2) == 1)
            res *= myPow(x, n % 2);

        return res;
    }
}
