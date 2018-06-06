package lintcode;

import java.util.ArrayList;

/**
 * @Description: 176. 图中两个点之间的路线
 * 给出一张有向图，设计一个算法判断两个点 s 与 t 之间是否存在路线。
 * <p>
 * 样例
 * 如下图:
 * A----->B----->C
 * .\     |
 * ..\    |
 * ...\   |
 * ....\  v
 * .....->D----->E
 * for s = B and t = E, return true
 * <p>
 * for s = D and t = C, return false
 * @Author: lc
 * @Date: Created in 2018/3/20
 */
public class _176
{
    /*
     * @param graph: A list of Directed graph node
     * @param s: the starting Directed graph node
     * @param t: the terminal Directed graph node
     * @return: a boolean value
     */
    public boolean hasRoute(ArrayList<DirectedGraphNode> graph, DirectedGraphNode s, DirectedGraphNode t)
    {
        // write your code here
        if (s.label == t.label) return true;

        boolean flag = false;
        for (DirectedGraphNode nei : s.neighbors)
        {
            if (flag) break;
            flag = hasRoute(graph, nei, t);
        }
        return flag;
    }
}
