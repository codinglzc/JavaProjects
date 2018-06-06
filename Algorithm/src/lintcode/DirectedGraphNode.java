package lintcode;

import java.util.ArrayList;

/**
 * @Description:
 * @Author: lc
 * @Date: Created in 2018/3/20
 */
public class DirectedGraphNode
{
    int label;
    ArrayList<DirectedGraphNode> neighbors;

    DirectedGraphNode(int x)
    {
        label = x;
        neighbors = new ArrayList<DirectedGraphNode>();
    }
}
