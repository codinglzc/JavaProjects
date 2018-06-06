package lintcode;

/**
 * @Description: 93. 平衡二叉树
 * 给定一个二叉树,确定它是高度平衡的。对于这个问题,一棵高度平衡的二叉树的定义是：一棵二叉树中每个节点的两个子树的深度相差不会超过1。
 * <p>
 * 样例：
 * 给出二叉树 A={3,9,20,#,#,15,7}, B={3,#,20,15,7}
 * <p>
 * A)  3            B)    3
 * .../ \                  \
 * ..9  20                 20
 * ..../  \                / \
 * ...15   7              15  7
 * 二叉树A是高度平衡的二叉树，但是B不是
 * @Author: lc
 * @Date: Created in 2018/3/7
 */

public class _93
{
    /*
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root)
    {
        // write your code here
        return maxDepth(root) != -1;
    }

    public int maxDepth(TreeNode node)
    {
        if (node == null)
            return 0;

        int left = maxDepth(node.left);
        int right = maxDepth(node.right);

        if (left == -1 || right == -1 || Math.abs(left - right) > 1)
            return -1;

        return Math.max(left, right) + 1;
    }
}
