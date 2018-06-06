package lintcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @Description: 137. 克隆图(BFS)
 * 克隆一张无向图，图中的每个节点包含一个 label 和一个列表 neighbors。
 * 你的程序需要返回一个经过深度拷贝的新图。这个新图和原图具有同样的结构，并且对新图的任何改动不会对原图造成任何影响。
 * <p>
 * 样例:
 * 比如，序列化图 {0,1,2#1,2#2,2} 共有三个节点, 因此包含两个个分隔符#。
 * 1. 第一个节点label为0，存在边从节点0链接到节点1和节点2
 * 2. 第二个节点label为1，存在边从节点1连接到节点2
 * 3. 第三个节点label为2，存在边从节点2连接到节点2(本身),从而形成自环。
 * 我们能看到如下的图：
 * <p>
 * ...1
 * ../ \
 * ./   \
 * 0 --- 2
 * ...../ \
 * .....\_/
 * @Author: lc
 * @Date: Created in 2018-04-11
 */
public class _137
{
    /*
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node)
    {
        // write your code here
        if (node == null) return null;

        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        Map<UndirectedGraphNode, Boolean> isVisited = new HashMap<>();
        Map<UndirectedGraphNode, UndirectedGraphNode> oldToNew = new HashMap<>();

        queue.offer(node);
        isVisited.put(node, true);
        UndirectedGraphNode result = new UndirectedGraphNode(node.label);
        oldToNew.put(node, result);

        while (!queue.isEmpty())
        {
            UndirectedGraphNode tmp = queue.poll();
            for (int i = 0; i < tmp.neighbors.size(); i++)
            {
                if (!isVisited.getOrDefault(tmp.neighbors.get(i), false))
                {
                    queue.offer(tmp.neighbors.get(i));
                    isVisited.put(tmp.neighbors.get(i), true);
                    UndirectedGraphNode newNode = new UndirectedGraphNode(tmp.neighbors.get(i).label);
                    oldToNew.put(tmp.neighbors.get(i), newNode);

                    oldToNew.get(tmp).neighbors.add(newNode);
                } else
                {
                    oldToNew.get(tmp).neighbors.add(oldToNew.get(tmp.neighbors.get(i)));
                }
            }
        }
        return result;
    }
}
