package lintcode;

/**
 * @Description: 140. 快速幂
 * 计算an % b，其中a，b和n都是32位的整数。
 * <p>
 * 样例：
 * 例如 231 % 3 = 2
 * 例如 1001000 % 1000 = 0
 * @Author: lc
 * @Date: Created in 2018/3/8
 */
public class _140
{
    /**
     * 1. 每次对n／2，减少一半的计算量，直至n=0或n=1;每次返回余数，平方再求余。
     * 注意n是奇数偶数，如果是技术，要补回舍去的1次幂，即乘以a％b，再求余。
     * 2. 注意变量res的类型必须是long，不然结果会出错。
     *
     * @param a: A 32bit integer
     * @param b: A 32bit integer
     * @param n: A 32bit integer
     * @return: An integer
     */
    public int fastPower(int a, int b, int n)
    {
        // write your code here
        if (n == 0)
            return 1 % b;
        if (n == 1)
            return a % b;

        long res = (long) fastPower(a, b, n / 2);
        res = res * res % b;

        if (n % 2 == 1)
            res = res * (a % b) % b;

        return (int) res;
    }
}
