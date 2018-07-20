package jianzhioffer.topic27;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>
 * 面试题27：二叉树的镜像（P.157）
 * 题目：请完成一个函数，输入一颗二叉树，该函数输出去它的镜像。
 * </p>
 *
 * @author Liu Cong
 * @since 2018-07-11
 */
public class MirrorOfBinaryTree
{
    private class BinaryTreeNode
    {
        public int value;
        public BinaryTreeNode left;
        public BinaryTreeNode right;
    }

    /**
     * 递归求解
     */
    public void mirrorRecursively(BinaryTreeNode node)
    {
        if (node == null) return;

        BinaryTreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;

        mirrorRecursively(node.left);
        mirrorRecursively(node.right);
    }

    /**
     * 非递归求解
     */
    public void mirrorCycle(BinaryTreeNode node)
    {
        if (node == null) return;

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty())
        {
            BinaryTreeNode n = queue.poll();

            BinaryTreeNode tmp = n.left;
            n.left = n.right;
            n.right = tmp;

            if (n.left != null) queue.offer(n.left);
            if (n.right != null) queue.offer(n.right);
        }
    }
}
