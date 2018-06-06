package lintcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Description:198. 排列序号II
 * 给出一个可能包含重复数字的排列，求这些数字的所有排列按字典序排序后该排列在其中的编号。编号从1开始。
 * <p>
 * 样例：
 * 给出排列[1, 4, 2, 2]，其编号为3。
 * @Author: lc
 * @Date: Created in 2018/3/19
 */
public class _198
{
    /**
     * @param A: An array of integers
     * @return: A long integer
     */
    public long permutationIndexII(int[] A)
    {
        // write your code here
        long no = 0;
        int len = A.length;
        for (int i = len - 1; i >= 0; i--)
        {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = i; j < len; j++)
            {
                map.put(A[j], map.getOrDefault(A[j], 0) + 1);
            }

            long num = factorial(len - i - 1);
            Set<Integer> isCalculates = new HashSet<>();
            for (int j = i + 1; j < len; j++)
            {
                if (A[j] < A[i] && isCalculates.add(A[j]))
                {
                    long temp = num;
                    map.put(A[j], map.get(A[j]) - 1);
                    for (Integer val : map.values())
                    {
                        temp /= factorial(val);
                    }
                    no += temp;
                    map.put(A[j], map.get(A[j]) + 1);
                }
            }

        }
        return no + 1;
    }

    public long factorial(int n)
    {
        long result = 1;
        for (int i = 1; i <= n; i++)
        {
            result *= (long) i;
        }
        return result;
    }
}
