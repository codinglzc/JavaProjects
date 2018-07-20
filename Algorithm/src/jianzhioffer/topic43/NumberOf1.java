package jianzhioffer.topic43;

/**
 * <p>
 * 面试题43：1~n整数中1出现的次数（P.221）
 * 题目：输入一个整数 n，求 1~n 这 n 个整数的十进制表示中 1 出现的次数。
 * 例如，输入 12, 1~12 这些整数中包含 1 的数字有 1,10,11 和 12，一共出现了 5 次。
 * </p>
 *
 * @author Liu Cong
 * @since 2018-07-13
 */
public class NumberOf1
{
    /**
     * 解法一：不考虑时间效率的解法
     * <p>
     * 时间复杂度：O(nlogn)
     */
    public static int numberOf1Between1AndN1(int n)
    {
        int count = 0;
        for (int i = 1; i <= n; i++)
        {
            int tmp = i;
            while (tmp > 0)
            {
                if (tmp % 10 == 1) count++;
                tmp /= 10;
            }
        }
        return count;
    }

    /**
     * 解法二：https://blog.csdn.net/ns_code/article/details/27563485
     * <p>
     * 按每一位来考虑，
     * 1)此位大于1，这一位上1的个数有 ([n / 10^(b+1) ] + 1) * 10^b
     * 2)此位等于0，为 ([n / 10^(b+1) ] ) * 10^b
     * 3)此位等于1，在0的基础上加上n mod 10^b + 1
     * <p>
     * 举个例子：
     * 30143:
     * 由于3>1,则个位上出现1的次数为(3014+1)*1
     * 由于4>1,则十位上出现1的次数为(301+1)*10
     * 由于1=1，则百位上出现1次数为(30+0)*100+(43+1)
     * 由于0<1，则千位上出现1次数为(3+0)*1000
     * 由于3>1，则万位上出现1此数据为(0+1)*10000
     * <p>
     * 注:以百位为例，百位出现1为100~199，*100的意思为单步出现了100~199，100次，*30是因为出现了30次100~199,+(43+1)是因为左后一次301**不完整导致。
     * <p>
     * 时间复杂度：O(logn)
     */
    public static int numberOf1Between1AndN2(int n)
    {
        if (n <= 0) return 0;

        int count = 0; // 统计 1 出现的次数
        for (int i = 1; n / i > 0; i *= 10) // i 是1,10,100,1000,...
        {
            int mod = n / i % 10; // 位上的数字
            if (mod > 1)
                count += (n / (i * 10) + 1) * i;
            else if (mod == 1)
                count += (n / (i * 10)) * i + n % i + 1;
            else
                count += (n / (i * 10)) * i;
        }
        return count;
    }

    public static void main(String[] args)
    {
        System.out.println(numberOf1Between1AndN1(12));
        System.out.println(numberOf1Between1AndN2(12));
    }
}
