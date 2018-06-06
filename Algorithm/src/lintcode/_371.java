package lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 371. 用递归打印数字
 * 用递归的方法找到从1到最大的N位整数。
 * <p>
 * 样例：
 * 给出 N = 1, 返回[1,2,3,4,5,6,7,8,9].
 * 给出 N = 2, 返回[1,2,3,4,5,6,7,8,9,10,11,...,99].
 * @Author: lc
 * @Date: Created in 2018/3/13
 */
public class _371
{
    /**
     * @param n: An integer
     * @return: An array storing 1 to the largest number with n digits.
     */
    public List<Integer> numbersByRecursion(int n)
    {
        // write your code here
        List<Integer> result = new ArrayList<>();
        if (n == 0) return result;
        if (n == 1)
        {
            for (int i = 1; i <= 9; i++)
                result.add(i);
            return result;
        }

        List<Integer> temp = numbersByRecursion(n - 1);
        result.addAll(temp);
        for (int i = 1; i <= 9; i++)
        {
            result.add((int) Math.pow(10, n - 1) * i);
            for (int j = 0; j < temp.size(); j++)
            {
                result.add((int) Math.pow(10, n - 1) * i + temp.get(j));
            }
        }
        return result;
    }
}
