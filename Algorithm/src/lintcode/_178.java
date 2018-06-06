package lintcode;

import java.util.*;

/**
 * @Description: 178. 图是否是树
 * 给出 n 个节点，标号分别从 0 到 n - 1 并且给出一个 无向 边的列表 (给出每条边的两个顶点), 写一个函数去判断这张｀无向｀图是否是一棵树
 * <p>
 * 注意事项：
 * 你可以假设我们不会给出重复的边在边的列表当中. 无向边　[0, 1] 和 [1, 0]　是同一条边， 因此他们不会同时出现在我们给你的边的列表当中。
 * <p>
 * 样例：
 * 给出n = 5 并且 edges = [[0, 1], [0, 2], [0, 3], [1, 4]], 返回 true.
 * 给出n = 5 并且 edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], 返回 false.
 * @Author: lc
 * @Date: Created in 2018/3/20
 */
public class _178
{
    /**
     * @param n:     An integer
     * @param edges: a list of undirected edges
     * @return: true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges)
    {
        // write your code here
        if (edges.length != n - 1) return false;

        Map<Integer, Set<Integer>> out = new HashMap<>();   // 记录所有节点的出度

        for (int i = 0; i < n; i++)
        {
            Set<Integer> set = new HashSet<>();
            out.put(i, set);
        }

        for (int i = 0; i < edges.length; i++)
        {
            int v = edges[i][0];
            int u = edges[i][1];
            if (!out.get(v).add(u)) return false;
            if (!out.get(u).add(v)) return false;
        }

        int[] visited = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (queue.size() > 0)
        {
            int temp = queue.poll();
            if (visited[temp] == 1) return false;
            visited[temp] = 1;
            for (Integer s : out.get(temp))
            {
                queue.add(s);
                out.get(s).remove(temp);
            }
        }
        for (int v : visited)
        {
            if (v == 0) return false;
        }

        return true;
    }
}
