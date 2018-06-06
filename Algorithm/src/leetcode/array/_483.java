package leetcode.array;

/**
 * @Description: 483. Smallest Good Base
 * For an integer n, we call k>=2 a good base of n, if all digits of n base k are 1.
 * Now given a string representing n, you should return the smallest good base of n in string format.
 * <p>
 * Example 1:
 * Input: "13"
 * Output: "3"
 * Explanation: 13 base 3 is 111.
 * <p>
 * Example 2:
 * Input: "4681"
 * Output: "8"
 * Explanation: 4681 base 8 is 11111.
 * <p>
 * Example 3:
 * Input: "1000000000000000000"
 * Output: "999999999999999999"
 * Explanation: 1000000000000000000 base 999999999999999999 is 11.
 * <p>
 * Note:
 * The range of n is [3, 10^18].
 * The string representing n is always valid and will not have leading zeros.
 * @Author: lc
 * @Date: Created in 2017/12/13
 */
public class _483
{
    /**
     * 记k的最高次幂为m，从上界 int(log(n)/log(2.0)) 向下界 1 递减枚举m
     * <p>
     * 问题转化为计算1 + k + k^2 + ... + k^m = n的正整数解
     * <p>
     * 由n > k^m得： k < n ^ 1/m
     * <p>
     * 由n < (k + 1)^m得： k > (n ^ 1/m) - 1，此处使用了二项式定理
     * <p>
     * 因此k可能的解为：int(n ^ 1/m)
     * <p>
     * 最后验证1 + k + k^2 + ... + k^m 是否等于 n
     */
    public String smallestGoodBase(String n)
    {
        long num = Long.parseLong(n);
        for (int m = (int) (Math.log(num) / Math.log(2.0)); m >= 1; m--)
        {
            long k = (long) Math.pow(num, 1.0 / m);
            if (isGoodBase(num, k, m))
                return String.valueOf(k);
        }
        return String.valueOf(num - 1);
    }

    private boolean isGoodBase(long num, long base, int m)
    {
        long sum = num;
        long val = 1;
        // calculate k^0, k^1,  ..., k^m
        for (int i = 0; i <= m; i++)
        {
            sum -= val;
            val *= base;
        }
        return sum == 0;
    }

    public static void main(String[] args)
    {
        _483 obj = new _483();
        System.out.println(obj.smallestGoodBase("15"));
    }
}
