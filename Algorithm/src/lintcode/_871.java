package lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 871. Minimum Factorization
 * Given a positive integer a, find the smallest positive integer b whose multiplication of each digit equals to a.
 * <p>
 * If there is no answer or the answer is not fit in 32-bit signed integer, then return 0.
 * <p>
 * 样例：
 * Given a = 48, return 68.
 * Given a = 15, return 35.
 * @Author: lc
 * @Date: Created in 2018/3/19
 */
public class _871
{
    /**
     * @param a: a positive integer
     * @return: the smallest positive integer whose multiplication of each digit equals to a
     */
    public int smallestFactorization(int a)
    {
        // Write your code here
        List<Integer> res = new ArrayList<>();
        recur(a, res, 9);
        long result = 0;
        for (int i = 0; i < res.size(); i++)
        {
            result += (long) (res.get(i) * Math.pow(10, i));
        }
        return result > Integer.MAX_VALUE ? 0 : (int) result;
    }

    public void recur(int a, List<Integer> res, int reNum)
    {
        if (a < 10)
        {
            res.add(a);
            return;
        }

        if (a >= 10 && reNum == 2 && a % 2 != 0)
        {
            res.clear();
            return;
        }

        for (int i = reNum; i >= 2; i--)
        {
            if (a % i == 0)
            {
                res.add(i);
                recur(a / i, res, i);
                break;
            }
        }
    }
}
