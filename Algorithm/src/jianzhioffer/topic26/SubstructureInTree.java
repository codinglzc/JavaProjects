package jianzhioffer.topic26;

/**
 * <p>
 * 面试题26：树的子结构（P.148）
 * 题目：输入两颗二叉树A和B，判断B是不是A的子结构。
 * </p>
 *
 * @author Liu Cong
 * @since 2018-07-11
 */
public class SubstructureInTree
{
    private class BinaryTreeNode
    {
        public double value;
        public BinaryTreeNode left;
        public BinaryTreeNode right;
    }

    public boolean hasSubTree(BinaryTreeNode root1, BinaryTreeNode root2)
    {
        boolean result = false;

        if (root1 != null && root2 != null)
        {
            // 因为计算机表示小数（包括float和double）都有误差，所以不能使用 == 来判断。
            if (Math.abs(root1.value - root2.value) < 0.0000001)
                result = doesTree1HaveTree2(root1, root2);

            if (!result) result = hasSubTree(root1.left, root2.left);
            if (!result) result = hasSubTree(root1.right, root2.right);
        }

        return result;
    }

    private boolean doesTree1HaveTree2(BinaryTreeNode root1, BinaryTreeNode root2)
    {
        if (root1 == null) return false;
        if (root2 == null) return true;

        if (Math.abs(root1.value - root2.value) >= 0.0000001)
            return false;

        return doesTree1HaveTree2(root1.left, root2.left) && doesTree1HaveTree2(root1.right, root2.right);
    }
}
