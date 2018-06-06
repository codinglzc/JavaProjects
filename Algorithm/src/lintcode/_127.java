package lintcode;

import java.util.*;

/**
 * @Description: 127. 拓扑排序
 * 给定一个有向图，图节点的拓扑排序被定义为：
 * 1. 对于每条有向边A--> B，则A必须排在B之前
 * 2. 拓扑排序的第一个节点可以是任何在图中没有其他节点指向它的节点
 * 找到给定图的任一拓扑排序
 * <p>
 * 注意事项：
 * 你可以假设图中至少存在一种拓扑排序
 * <p>
 * 样例：
 * 对于下列图：
 * <p>
 * 这个图的拓扑排序可能是：
 * <p>
 * [0, 1, 2, 3, 4, 5]
 * <p>
 * 或者
 * <p>
 * [0, 2, 3, 1, 5, 4]
 * <p>
 * 或者
 * <p>
 * ....
 * @Author: lc
 * @Date: Created in 2018/3/20
 */
public class _127
{
    /*
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph)
    {
        // write your code here
        ArrayList<DirectedGraphNode> res = new ArrayList<>();

        Map<DirectedGraphNode, Integer> ins = new HashMap<>();  // 记录每个节点的入度
        Queue<DirectedGraphNode> inis0 = new LinkedList<>();    // 记录入度为0的节点

        for (DirectedGraphNode node : graph)
        {
            for (DirectedGraphNode nei : node.neighbors)
            {
                ins.put(nei, ins.getOrDefault(nei, 0) + 1);
            }
        }

        for (DirectedGraphNode node : graph)
        {
            if (ins.getOrDefault(node, 0) == 0)
            {
                inis0.add(node);
            }
        }

        while (inis0.size() != 0)
        {
            DirectedGraphNode temp = inis0.poll();
            res.add(temp);

            for (DirectedGraphNode nei : temp.neighbors)
            {
                ins.put(nei, ins.get(nei) - 1);
                if (ins.get(nei) == 0)
                {
                    inis0.add(nei);
                }
            }
        }

        return res;
    }
}
