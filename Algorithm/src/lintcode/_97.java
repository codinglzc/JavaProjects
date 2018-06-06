package lintcode;

/**
 * @Description: 97. 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的距离。
 * <p>
 * 样例：
 * 给出一棵如下的二叉树:
 * .....1
 * ..../ \
 * ...2   3
 * ....../ \
 * .....4   5
 * 这个二叉树的最大深度为3.
 * @Author: lc
 * @Date: Created in 2018/3/7
 */
public class _97
{
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int maxDepth(TreeNode root)
    {
        // write your code here
        return depth(root);
    }

    public int depth(TreeNode node)
    {
        if (node == null)
            return 0;

        int left = depth(node.left);
        int right = depth(node.right);

        return Math.max(left, right) + 1;
    }
}
