package jianzhioffer.topic17;

/**
 * @description: 面试题17：打印从 1 到最大的 n 位数
 * 题目：输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。
 * 比如驶入 3， 则打印出 1、2、3 一直到最大的 3 位数 999.
 * @author: Liu Cong
 * @create: Created at 2018-06-22
 */
public class Print1ToMaxOfNDigits
{
    /**
     * 该解决方案没有考虑到大数问题。
     *
     * @param n
     */
    public static void solution1(int n)
    {
        int number = 1;
        int i = 0;
        while (i++ < n) number *= 10;
        for (i = 1; i < number; i++)
        {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    /**
     * 使用 char数组模拟数字加法的解法，成功考虑到大数问题。
     *
     * @param n
     */
    public static void solution2(int n)
    {
        if (n <= 0) return;

        char[] number = new char[n];
        for (int i = 0; i < n; i++)
        {
            number[i] = '0';
        }

        while (!increment(number))
        {
            printNumber(number);
        }
    }

    /**
     * 模拟 char 数组自增过程
     */
    private static boolean increment(char[] number)
    {
        boolean isOverflow = false;
        int nTakeOver = 0;
        for (int i = number.length - 1; i >= 0; i--)
        {
            int nSum = number[i] - '0' + nTakeOver;
            if (i == number.length - 1) nSum++;
            if (nSum >= 10)
            {
                if (i == 0) isOverflow = true;
                else
                {
                    nTakeOver = 1;
                    number[i] = '0';
                }
            } else
            {
                number[i] = (char) (nSum + '0');
                break;
            }
        }
        return isOverflow;
    }

    /*
     * 打印 char 数组
     */
    private static void printNumber(char[] number)
    {
        boolean isBeginPrint = false;
        for (char aNumber : number)
        {
            if (aNumber != '0') isBeginPrint = true;
            if (isBeginPrint)
            {
                System.out.print(aNumber);
            }
        }
        System.out.print(" ");
    }

    /**
     * 把问题转换成数字排列的解法，递归让代码更简洁。
     * 其实就是 n 个从 0 到 9 的全排列。
     *
     * @param n
     */
    public static void solution3(int n)
    {
        if (n <= 0) return;

        char[] number = new char[n];

        recur(number, 0);
    }

    private static void recur(char[] number, int index)
    {
        if (index >= number.length)
        {
            printNumber(number);
            return;
        }

        for (int i = 0; i < 10; i++)
        {
            number[index] = (char) (i + '0');
            recur(number, index + 1);
        }
    }

    public static void main(String[] args)
    {
        solution2(2);
        System.out.println();
        solution3(2);
    }
}
