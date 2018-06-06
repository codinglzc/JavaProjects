package lintcode;

import java.util.ArrayList;

/**
 * @Description: 无向图
 * @Author: lc
 * @Date: Created in 2018-04-11
 */
public class UndirectedGraphNode
{
    int label;
    ArrayList<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x)
    {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}
