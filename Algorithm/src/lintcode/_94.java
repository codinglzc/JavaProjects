package lintcode;

/**
 * @Description: 94. 二叉树中的最大路径和
 * 给出一棵二叉树，寻找一条路径使其路径和最大，路径可以在任一节点中开始和结束（路径和为两个节点之间所在路径上的节点权值之和）
 * <p>
 * 样例：
 * 给出一棵二叉树：
 * <p>
 * ...1
 * ../ \
 * .2   3
 * 返回 6
 * @Author: lc
 * @Date: Created in 2018/3/7
 */
public class _94
{
    /*
     * 一个节点线看作根节点，计算当前路径的最大值，然后看作子节点，计算当前分支的最大值，计算并返回
     *
     * @param root: The root of binary tree.
     * @return: An integer
     */
    public int maxPathSum(TreeNode root)
    {
        // write your code here
        int[] result = {Integer.MIN_VALUE};
        search(root, result);
        return result[0];
    }

    public int search(TreeNode node, int[] result)
    {
        if (node == null)
            return 0;

        int left = search(node.left, result);
        int right = search(node.right, result);
        int current = node.val + Math.max(left, 0) + Math.max(right, 0);

        result[0] = Math.max(result[0], current);

        return node.val + Math.max(left, Math.max(right, 0));
    }
}
