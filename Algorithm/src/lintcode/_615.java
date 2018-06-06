package lintcode;

import java.util.*;

/**
 * @Description: 615. 课程表(BFS和拓扑查询)
 * 现在你总共有 n 门课需要选，记为 0 到 n - 1.
 * 一些课程在修之前需要先修另外的一些课程，比如要学习课程 0 你需要先学习课程 1 ，表示为[0,1]
 * 给定n门课以及他们的先决条件，判断是否可能完成所有课程？
 * <p>
 * 样例：
 * 给定 n = 2，先决条件为 [[1,0]] 返回 true
 * 给定 n = 2，先决条件为 [[1,0],[0,1]] 返回 false
 * @Author: lc
 * @Date: Created in 2018-04-13
 */
public class _615
{
    /*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: true if can finish all courses or false
     */
    public boolean canFinish(int numCourses, int[][] prerequisites)
    {
        // write your code here
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, Integer> indegrees = new HashMap<>();

        for (int i = 0; i < numCourses; i++)
        {
            map.put(i, new HashSet<Integer>());
            indegrees.put(i, 0);
        }

        for (int[] pre : prerequisites)
        {
            if (map.get(pre[0]).add(pre[1]))
                indegrees.put(pre[1], indegrees.get(pre[1]) + 1);
        }

        Queue<Integer> q = new LinkedList<>();
        for (Map.Entry<Integer, Integer> in : indegrees.entrySet())
        {
            if (in.getValue() == 0) q.offer(in.getKey());
        }

        int count = 0;
        while (!q.isEmpty())
        {
            int tmp = q.poll();
            for (int i : map.get(tmp))
            {
                indegrees.put(i, indegrees.get(i) - 1);
                if (indegrees.get(i) == 0)
                    q.offer(i);
            }
            count++;
        }

        return count == numCourses;
    }
}
