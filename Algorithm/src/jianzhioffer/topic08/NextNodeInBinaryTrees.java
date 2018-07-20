package jianzhioffer.topic08;

/**
 * @description: 面试题8：二叉树的下一个节点
 * 题目：给定一颗二叉树和其中的一个节点，如何找出中序遍历序列的下一个节点？
 * 树中的节点除了有两个分别指向左、右子节点的指针，还有一个指向父节点的指针。
 * @author: Liu Cong
 * @create: Created at 2018-06-14
 */
public class NextNodeInBinaryTrees
{
    static class BinaryTreeNode
    {
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
        BinaryTreeNode parent;

        public BinaryTreeNode()
        {
            value = 0;
            left = null;
            right = null;
            parent = null;
        }

        public BinaryTreeNode(int value)
        {
            this();
            this.value = value;
        }
    }

    /**
     * 步骤：
     * 1.判断该节点是否有右子树，如果有，跳到步骤2；反之跳到步骤3.
     * 2.找到右子树中的最左子节点，即为下一个节点。
     * 3.向上找父节点。当满足子节点是父节点的左儿子时，该父节点为下一个节点；当找不到时，则表明该节点没有下一个节点。
     *
     * @param node 节点
     * @return 下一个节点
     */
    public static BinaryTreeNode getNext(BinaryTreeNode node)
    {
        if (node == null) return null;

        BinaryTreeNode next = null;
        if (node.right != null)
        {
            BinaryTreeNode right = node.right;
            while (right.left != null)
                right = right.left;
            next = right;
        } else if (node.parent != null)
        {
            BinaryTreeNode child = node;
            BinaryTreeNode parent = child.parent;
            while (parent != null && parent.left == child)
            {
                child = parent;
                parent = child.parent;

            }
            next = parent;
        }
        return next;
    }
}
