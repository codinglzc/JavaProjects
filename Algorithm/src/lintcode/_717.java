package lintcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description: 717. Tree Longest Path With Same Value
 * 假设有一棵有 N 个节点的无向树, 编号为 1 到 N, 每一个节点都有一个int类型的值，不同的节点可以有相同的值。给一个长度为N的数组A，A[j]表示
 * 第j + 1个节点的值。再给一个长度为 (N - 1) * 2 的数组 E,对于任意的 0 <= j <= N - 2 都有 E[2 * j], E[2 * j + 1]表示节点 E[2 * j]
 * 与节点 E[2 * j + 1]有边相连。返回具有相同值的节点构成的最长路劲的长度，路劲的长度为路径边的数量。
 * <p>
 * 注意事项：
 * 假设: 1 <= N <= 1000
 * <p>
 * 样例：
 * 给出 A = [1, 1, 1 ,2, 2] 和 E = [1, 2, 1, 3, 2, 4, 2, 5]
 * 描述了下面的这棵树:
 * .....................1 （value = 1）
 * .................../   \
 * .....(value = 1) 2     3 (value = 1)
 * .............../  \
 * (value = 2)  4     5 (value = 2)
 * 你写的程序需要返回 2，因为最长路径为 2 -> 1 -> 3(所有节点的值均为1)。这条路径的边的数量为 2,所以答案是 2
 * @Author: lc
 * @Date: Created in 2018-03-21
 */
public class _717
{
    /**
     * @param A: as indicated in the description
     * @param E: as indicated in the description
     * @return: Return the number of edges on the longest path with same value.
     */

    public int ans = 0;

    public int LongestPathWithSameValue(int[] A, int[] E)
    {
        // write your code here
        int len = A.length;
        List<List<Integer>> ch = new ArrayList<>(); // 节点映射
        for (int i = 0; i <= len; i++)
        {
            ch.add(new ArrayList<>());
        }
        for (int i = 0; i < len - 1; i++)
        {
            ch.get(E[i * 2]).add(E[i * 2 + 1]);
            ch.get(E[i * 2 + 1]).add(E[i * 2]);
        }
        int tmp = dfs(1, 0, A, ch);
        ans = Math.max(ans, tmp);
        return ans - 1;
    }

    public int dfs(int index, int father, int[] A, List<List<Integer>> ch)
    {
        List<Integer> v = new ArrayList<>();    // 不知道这个对象用来干嘛
        for (int son : ch.get(index))
        {
            if (son != father)
            {
                if (A[son - 1] == A[index - 1])
                {
                    v.add(dfs(son, index, A, ch));
                } else
                {
                    dfs(son, index, A, ch);
                }
            }
        }

        // 为了防止v为空
        v.add(0);
        v.add(0);
        Collections.sort(v);
        Collections.reverse(v);
        ans = Math.max(ans, v.get(0) + v.get(1) + 1);
        return v.get(0) + 1;
    }
}
