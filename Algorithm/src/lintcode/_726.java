package lintcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: 726. 验证满二叉树 (BFS)
 * 如果一棵二叉树所有节点都有零个或两个子节点, 那么这棵树为满二叉树. 反过来说, 满二叉树中不存在只有一个子节点的节点.
 * <p>
 * 满二叉树
 * ....1
 * .../ \
 * ..2   3
 * ./ \
 * 4   5
 * <p>
 * 不是一棵满二叉树
 * ....1
 * .../ \
 * ..2   3
 * ./
 * 4
 * 样例：
 * 给出树 {1,2,3}, 返回 true
 * 给出树 {1,2,3,4}, 返回 false
 * 给出树 {1,2,3,4,5}, 返回 true
 * @Author: lc
 * @Date: Created in 2018-04-16
 */
public class _726
{
    /**
     * @param root: the given tree
     * @return: Whether it is a full tree
     */
    public boolean isFullTree(TreeNode root)
    {
        // write your code here
        if (root == null) return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty())
        {
            TreeNode tmp = q.poll();
            if (tmp.left == null && tmp.right == null) continue;
            if (tmp.left != null && tmp.right != null)
            {
                q.offer(tmp.left);
                q.offer(tmp.right);
                continue;
            }
            return false;
        }
        return true;
    }
}
