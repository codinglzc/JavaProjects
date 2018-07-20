package jianzhioffer.topic14;

/**
 * @description: 面试题14：剪绳子（P.96）
 * 题目：给你一根长度为 n 的绳子，请把绳子剪成 m 段（m、n都是整数，n>1 并且 m>1），每段绳子的长度记为 k[0], k[1], ···, k[m]。
 * 请问 k[0] * k[1] * ··· * k[m] 可能的最大乘积是多少？例如，当绳子的长度是 8 时，我们把它剪成长度分别为 2、3、3 的三段，此时
 * 得到的最大乘积是 18 。
 * <p>
 * 求解方法：动态规划和贪婪算法
 * @author: Liu Cong
 * @create: Created at 2018-06-21
 */
public class CuttingRope
{
    /**
     * 动态规划
     * <p>
     * 时间复杂度：O(n²)
     * 空间复杂度：O(n)
     *
     * @param length 绳子长度
     * @return 最优解
     */
    public static int solution1(int length)
    {
        if (length < 2) return 0;
        if (length == 2) return 1;
        if (length == 3) return 2;

        int[] products = new int[length + 1]; // 子问题的最优解存储在数组 products 里
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;

        for (int i = 4; i <= length; i++) // 为了避免重复计算子问题，按照从下而上的顺序计算
        {
            int max = 0;
            for (int j = 1; j <= i / 2; j++) // 计算所有可能的剪法，并比较得出最大值
            {
                int product = products[j] * products[i - j];
                if (product > max) max = product;
            }
            products[i] = max;
        }

        return products[length];
    }

    /**
     * 贪婪算法
     * <p>
     * 首先，当 n>=5 的时候，我么可以证明 2(n-2)>=n 并且 3(n-3)>=n。也就是说，当绳子剩下的长度大于或者等于 5 的时候，我们就把它剪成
     * 长度为 3 或者 2 的绳子段。另外，当 n>=5 时，3(n-3) >= 2(n-2)，因此我们应该尽可能地多剪长度为 3 的绳子段。
     * 由此，f(n) = f(3)*f(n-3) = f(3)*f(3)*f(n-3-3) = ··· = f(3)*···*f(3)*f(n - 3 - ··· - 3) 直到 n-3-···-3 = 2
     *
     * @param length 绳子长度
     * @return 最优解
     */
    public static int solution2(int length)
    {
        if (length < 2) return 0;
        if (length == 2) return 1;
        if (length == 3) return 2;

        // 尽可能多地剪去长度为 3 的绳子段
        int timesOf3 = length / 3;

        // 当绳子最后剩下的长度为 4 的时候，不能再剪去长度为 3 的绳子段
        // 此时更好的方法是把绳子剪成长度为 2 的两段，因为 2*2 > 3*1
        if (length - timesOf3 * 3 == 1)
            timesOf3--;

        int timesOf2 = (length - timesOf3 * 3) / 2;

        return (int) ((int) Math.pow(3, timesOf3) * Math.pow(2, timesOf2));
    }

    public static void main(String[] args)
    {
        for (int i = 0; i < 10; i++)
        {
            System.out.print(solution1(i) + " ");
            System.out.println(solution2(i));
        }
    }
}
