package lintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 90. k数和 II
 * Your title here...Given n unique integers, number k (1<=k<=n) and target.
 * Find all possible k integers where their sum is target.
 * <p>
 * 样例：
 * 给出[1,2,3,4]，k=2， target=5，返回 [[1,4],[2,3]]
 * @Author: 刘梓聪
 * @Date: Created in 2018/3/19
 */
public class _90
{
    /*
     * @param A: an integer array
     * @param k: a postive integer <= length(A)
     * @param targer: an integer
     * @return: A list of lists of integer
     */
    public List<List<Integer>> kSumII(int[] A, int k, int targer)
    {
        // write your code here
        Arrays.sort(A);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        recur(A, k, targer, res, temp, 0);
        return res;
    }

    public void recur(int[] A, int k, int targer, List<List<Integer>> res, List<Integer> temp, int index)
    {
        if (targer == 0 && k == 0)
        {
            res.add(new ArrayList<>(temp));
            return;
        }

        if (targer == 0 || k == 0) return;

        for (int i = index; i < A.length; i++)
        {
            if (A[i] > targer) break;
            temp.add(A[i]);
            recur(A, k - 1, targer - A[i], res, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
