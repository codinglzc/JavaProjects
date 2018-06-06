package lintcode;

import java.util.*;

/**
 * @Description: 605. 序列重构(BFS + 拓扑排序)
 * 判断是否序列 org 能唯一地由 seqs重构得出. org是一个由从1到n的正整数排列而成的序列，1 ≤ n ≤ 10^4。 重构表示组合成seqs的一个最短的
 * 父序列 (意思是，一个最短的序列使得所有 seqs里的序列都是它的子序列).
 * 判断是否有且仅有一个能从 seqs重构出来的序列，并且这个序列是org。
 * <p>
 * 样例：
 * 给定 org = [1,2,3], seqs = [[1,2],[1,3]]
 * 返回 false
 * 解释:
 * [1,2,3] 并不是唯一可以被重构出的序列，还可以重构出 [1,3,2]
 * <p>
 * 给出 org = [1,2,3], seqs = [[1,2]]
 * 返回 false
 * 解释:
 * 能重构出的序列只有 [1,2].
 * <p>
 * 给定 org = [1,2,3], seqs = [[1,2],[1,3],[2,3]]
 * 返回 true
 * 解释:
 * 序列 [1,2], [1,3], 和 [2,3] 可以唯一重构出 [1,2,3].
 * <p>
 * 给定org = [4,1,5,2,6,3], seqs = [[5,2,6,3],[4,1,5,2]]
 * 返回 true
 * @Author: lc
 * @Date: Created in 2018-04-12
 */
public class _605
{
    /**
     * @param org:  a permutation of the integers from 1 to n
     * @param seqs: a list of sequences
     * @return: true if it can be reconstructed only one or false
     */
    public boolean sequenceReconstruction(int[] org, int[][] seqs)
    {
        // write your code here
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, Integer> indegrees = new HashMap<>();

        for (int e : org)
        {
            map.put(e, new HashSet<>());
            indegrees.put(e, 0);
        }

        int n = org.length;
        int count = 0;
        for (int[] seq : seqs)
        {
            count += seq.length;
            if (seq.length > 0 && (seq[0] < 1 || seq[0] > n)) return false;

            for (int i = 1; i < seq.length; i++)
            {
                if (seq[i] < 1 || seq[i] > n) return false;

                if (map.get(seq[i - 1]).add(seq[i]))
                {
                    indegrees.put(seq[i], indegrees.getOrDefault(seq[i], 0) + 1);
                }
            }
        }

        if (count < n) return false;

        Queue<Integer> q = new LinkedList<>();
        for (Map.Entry<Integer, Integer> in : indegrees.entrySet())
        {
            if (in.getValue() == 0) q.offer(in.getKey());
        }

        int cnt = 0;
        while (q.size() == 1)
        {
            int ele = q.poll();
            if (org[cnt] != ele) return false;
            for (int next : map.get(ele))
            {
                indegrees.put(next, indegrees.get(next) - 1);
                if (indegrees.get(next) == 0) q.offer(next);
            }
            cnt++;
        }

        return cnt == n;
    }
}
