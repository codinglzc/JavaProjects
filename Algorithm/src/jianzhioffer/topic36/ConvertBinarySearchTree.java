package jianzhioffer.topic36;

/**
 * <p>
 * 面试题36：二叉搜索树与双向链表（P.191）
 * 题目：输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 * </p>
 *
 * @author Liu Cong
 * @since 2018-07-12
 */
public class ConvertBinarySearchTree
{
    private class BinaryTreeNode
    {
        public int value;
        public BinaryTreeNode left;
        public BinaryTreeNode right;
    }

    public BinaryTreeNode convert(BinaryTreeNode root)
    {
        BinaryTreeNode lastNodeInList = new BinaryTreeNode();
        convert(root, lastNodeInList);

        // 此时，lastNodeInList指向双向链表的尾节点，我们需要返回头节点
        BinaryTreeNode headInList = lastNodeInList;
        while (headInList.left != null)
            headInList = headInList.left;
        // 第一个节点是之前我们自己 new 出来的一个节点，所以需要去除
        headInList = headInList.right;
        headInList.left = null;

        return headInList;
    }

    private void convert(BinaryTreeNode node, BinaryTreeNode lastNodeInList)
    {
        if (node == null) return;

        if (node.left != null)
            convert(node.left, lastNodeInList);

        node.left = lastNodeInList;
        lastNodeInList.right = node;
        lastNodeInList = node;

        if (node.right != null)
            convert(node.right, lastNodeInList);
    }
}
