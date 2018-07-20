package jianzhioffer.topic49;

/**
 * <p>
 * 面试题49：丑数
 * 题目：我们把只包含因子2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第1500个丑数。
 * 例如，6、8 都是丑数，但 14 不是，因为它包含因子 7.习惯上我们把 1 当做第一个丑数。
 * </p>
 *
 * @author Liu Cong
 * @since 2018-07-16
 */
public class UglyNumber
{
    /**
     * 逐个判断每个整数是不是丑数的解法，直观但不够高效。
     */
    public static int getUglyNumber1(int index)
    {
        if (index <= 0) return 0;

        int number = 0;
        int uglyFound = 0;
        while (uglyFound < index)
        {
            ++number;
            if (isUgly(number))
            {
                uglyFound++;
            }
        }
        return number;
    }

    private static boolean isUgly(int number)
    {
        while (number % 2 == 0) number /= 2;
        while (number % 3 == 0) number /= 3;
        while (number % 5 == 0) number /= 5;
        return number == 1;
    }

    /**
     * 创建数组保存已经找到的丑数，用空间换时间的解法。
     */
    public static int getUglyNumber2(int index)
    {
        if (index <= 0) return 0;

        int[] uglyNums = new int[index];
        uglyNums[0] = 1;
        int nextUglyIndex = 1;

        int multiply2Index = 0;
        int multiply3Index = 0;
        int multiply5Index = 0;

        while (nextUglyIndex < index)
        {
            int min = Math.min(Math.min(uglyNums[multiply2Index] * 2, uglyNums[multiply3Index] * 3), uglyNums[multiply5Index] * 5);
            uglyNums[nextUglyIndex] = min;

            while (uglyNums[multiply2Index] * 2 <= uglyNums[nextUglyIndex]) multiply2Index++;
            while (uglyNums[multiply3Index] * 3 <= uglyNums[nextUglyIndex]) multiply3Index++;
            while (uglyNums[multiply5Index] * 5 <= uglyNums[nextUglyIndex]) multiply5Index++;

            nextUglyIndex++;
        }

        return uglyNums[nextUglyIndex - 1];
    }

    public static void main(String[] args)
    {
        System.out.println(getUglyNumber1(1500));
        System.out.println(getUglyNumber2(1500));
    }
}
