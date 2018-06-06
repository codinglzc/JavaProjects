package lintcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description: 616. 安排课程
 * 你需要去上n门九章的课才能获得offer，这些课被标号为 0 到 n-1 。
 * 有一些课程需要“前置课程”，比如如果你要上课程0，你需要先学课程1，我们用一个匹配来表示他们： [0,1]
 * <p>
 * 给你课程的总数量和一些前置课程的需求，返回你为了学完所有课程所安排的学习顺序。
 * <p>
 * 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
 * <p>
 * 样例：
 * 给定 n = 2, prerequisites = [[1,0]]
 * 返回 [0,1]
 * <p>
 * 给定 n = 4, prerequisites = [1,0],[2,0],[3,1],[3,2]]
 * 返回 [0,1,2,3] or [0,2,1,3]
 * @Author: lc
 * @Date: Created in 2018-04-13
 */
public class _616
{
    /*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: the course order
     */
    public int[] findOrder(int numCourses, int[][] prerequisites)
    {
        // write your code here
        List[] record = new ArrayList[numCourses];
        int[] indegrees = new int[numCourses];

        for (int i = 0; i < numCourses; i++)
        {
            record[i] = new ArrayList<Integer>();
        }

        for (int[] pre : prerequisites)
        {
            record[pre[1]].add(pre[0]);
            indegrees[pre[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++)
        {
            if (indegrees[i] == 0)
            {
                q.offer(i);
            }
        }

        int[] result = new int[numCourses];
        int count = 0;
        while (!q.isEmpty())
        {
            int course = q.poll();
            for (int i = 0; i < record[course].size(); i++)
            {
                int pointer = (int) record[course].get(i);
                indegrees[pointer]--;
                if (indegrees[pointer] == 0)
                    q.offer(pointer);
            }
            result[count++] = course;
        }

        return count == numCourses ? result : new int[0];
    }
}
