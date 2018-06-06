package lintcode;

/**
 * @Description: 388. 第k个排列
 * 给定 n 和 k，求123..n组成的排列中的第 k 个排列。
 * <p>
 * 样例:
 * 对于 n = 3, 所有的排列如下：
 * 123
 * 132
 * 213
 * 231
 * 312
 * 321
 * 如果 k = 4, 第4个排列为，231.
 * @Author: lc
 * @Date: Created in 2018/3/6
 */
public class _388
{
    /**
     * 思路查看：http://blog.csdn.net/modiziri/article/details/22389303
     *
     * @param n: n
     * @param k: the k th permutation
     * @return: return the k-th permutation
     */
    public String getPermutation(int n, int k)
    {
        // write your code here
        int[] result = new int[n];
        for (int i = 0; i < n; i++)
        {
            result[i] = i + 1;
        }

        int re = k - 1, count = 0;
        for (int i = n - 1; i >= 1; i--)
        {
            int fac = factorial(i);
            int aaa = re / fac;
            for (int j = count + aaa; j > count; j--)
            {
                int temp = result[j];
                result[j] = result[j - 1];
                result[j - 1] = temp;
            }
            re = re % fac;
            count++;
        }

        String xxx = "";
        for (int r : result)
        {
            xxx += "" + r;
        }
        return xxx;
    }

    private int factorial(int num)
    {
        if (num == 1)
            return 1;
        return num * factorial(num - 1);
    }
}
