package jianzhioffer.topic15;

/**
 * @description: 面试题15：二进制中的 1 的个数
 * 题目：请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。
 * 例如，把 9 表示成二进制是 1001，有 2 位是 1.因此，如果输入 9，则该函数输出 2.
 * @author: Liu Cong
 * @create: Created at 2018-06-21
 */
public class NumberOf1InBinary
{
    /**
     * 位右移 + 位与
     * 缺点：当输入 n 为负数时，会引起死循环的解法（因为位右移是以符号位补齐）
     *
     * @param n 输入值
     * @return 二进制中 1 的个数据
     */
    public static int solution1(int n)
    {
        int count = 0;
        while (n != 0)
        {
            if ((n & 1) != 0) count++;
            n >>= 1;
        }
        return count;
    }

    /**
     * 位左移 + 位与
     * <p>
     * 循环的次数为 int 的位数，即 32 次
     *
     * @param n 输入值
     * @return 二进制中 1 的个数
     */
    public static int solution2(int n)
    {
        int count = 0;
        int flag = 1;
        while (flag != 0)
        {
            if ((n & flag) != 0) count++;
            flag <<= 1;
        }
        return count;
    }

    /**
     * 把一个整数减去 1，再和原整数做与运算，会把该整数最右边的 1 变成 0.
     * <p>
     * 循环次数为二进制中 1 的个数
     *
     * @param n 输入值
     * @return 二进制中 1 的个数
     */
    public static int solution3(int n)
    {
        int count = 0;
        while (n != 0)
        {
            count++;
            n = (n - 1) & n;
        }
        return count;
    }


    public static void main(String[] args)
    {
        //System.out.print(solution1(0x8000000) + " ");
        System.out.print(solution2(0x8000000) + " ");
        System.out.println(solution3(0x8000000));

        //System.out.print(solution1(0xFFFFFFFF) + " ");
        System.out.print(solution2(0xFFFFFFFF) + " ");
        System.out.println(solution3(0xFFFFFFFF));

        for (int i = -5; i <= 5; i++)
        {
            //System.out.print(solution1(i) + " ");
            System.out.print(solution2(i) + " ");
            System.out.println(solution3(i));
        }

        System.out.print(solution1(0) + " ");
        System.out.print(solution2(0) + " ");
        System.out.println(solution3(0));

        System.out.print(solution1(0x7FFFFFFF) + " ");
        System.out.print(solution2(0x7FFFFFFF) + " ");
        System.out.println(solution3(0x7FFFFFFF));
    }
}
