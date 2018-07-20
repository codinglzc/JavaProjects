package jianzhioffer.topic46;

/**
 * <p>
 * 面试题46：把数字翻译成字符串（P.231）
 * 题目：给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 "a"，1 翻译成 "b"，···， 11 翻译成 "l"，···，25 翻译成 "z"。
 * 一个数字可能有多个翻译。例如，12258 有 5 种不同的翻译，分别是"bccfi"，"bwfi"，"bczi","mcfi" 和 "mzi"。
 * 请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * </p>
 *
 * @author Liu Cong
 * @since 2018-07-14
 */
public class TranslateNumbersToStrings
{
    /**
     * 动态规划
     */
    public static int getTranslationCount(int number)
    {
        if (number < 0) return 0;

        String numStr = String.valueOf(number);
        int[] counts = new int[numStr.length()];
        int curCount;
        // 从右到左，而不是从左到右，目的是为了消除重复子问题计算
        for (int i = numStr.length() - 1; i >= 0; i--)
        {
            if (i == numStr.length() - 1)
                curCount = 1;
            else
            {
                curCount = counts[i + 1];

                int digit1 = numStr.charAt(i) - '0';
                int digit2 = numStr.charAt(i + 1) - '0';
                int converted = digit1 * 10 + digit2;
                if (converted >= 10 && converted <= 25)
                {
                    if (i + 2 < numStr.length())
                        curCount += counts[i + 2];
                    else
                        curCount += 1;
                }
            }

            counts[i] = curCount;
        }

        return counts[0];
    }

    public static void main(String[] args)
    {
        System.out.println(getTranslationCount(12258));
    }
}
