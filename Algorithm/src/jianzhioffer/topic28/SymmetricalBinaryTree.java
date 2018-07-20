package jianzhioffer.topic28;

/**
 * <p>
 * 面试题28：对称的二叉树（P.159）
 * 题目：请实现一个函数，用来判断一颗二叉树是不是对称的。如果一颗二叉树和它的镜像一样，那么它是对称的。
 * </p>
 *
 * @author Liu Cong
 * @since 2018-07-11
 */
public class SymmetricalBinaryTree
{
    private class BinaryTreeNode
    {
        public int value;
        public BinaryTreeNode left;
        public BinaryTreeNode right;
    }

    /**
     * 前序遍历—————————中左右
     * 对称的前序遍历————中右左
     */
    public boolean isSymmetrical(BinaryTreeNode root)
    {
        return isSymmetrical(root, root);
    }

    private boolean isSymmetrical(BinaryTreeNode root1, BinaryTreeNode root2)
    {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;

        if (root1.value != root2.value) return false;

        return isSymmetrical(root1.left, root2.right) && isSymmetrical(root1.right, root2.left);
    }
}
