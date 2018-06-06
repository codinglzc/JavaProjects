package lintcode;

/**
 * @Description: 155. 二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 * <p>
 * 二叉树的最小深度为根节点到最近叶子节点的距离。
 * <p>
 * 样例：
 * 给出一棵如下的二叉树:
 * ....1
 * .../ \
 * ..2   3
 * ...../ \
 * ....4   5
 * 这个二叉树的最小深度为 2
 * @Author: lc
 * @Date: Created in 2018/3/20
 */
public class _155
{
    /**
     * @param root: The root of binary tree
     * @return: An integer
     */

    public int minDep;

    public int minDepth(TreeNode root)
    {
        // write your code here
        if (root == null) return 0;
        minDep = Integer.MAX_VALUE;
        recur(root, 1);
        return minDep;
    }

    public void recur(TreeNode node, int dep)
    {
        if (node.left == null && node.right == null)
        {
            minDep = minDep < dep ? minDep : dep;
            return;
        }

        if (node.left != null) recur(node.left, dep + 1);
        if (node.right != null) recur(node.right, dep + 1);
    }
}
