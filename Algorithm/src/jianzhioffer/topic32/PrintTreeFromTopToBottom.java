package jianzhioffer.topic32;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>
 * 面试题32：从上到下打印二叉树（P.171）
 * 题目一：不分行从上到下打印二叉树
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * </p>
 *
 * @author Liu Cong
 * @since 2018-07-11
 */
public class PrintTreeFromTopToBottom
{
    private class BinaryTreeNode
    {
        private int value;
        private BinaryTreeNode left;
        private BinaryTreeNode right;
    }

    /**
     * 本质上，这就是广度优先遍历二叉树。
     * 类似的还有广度优先遍历有向图，也是基于队列实现的。
     */
    public void printFromTopToBottom(BinaryTreeNode root)
    {
        if (root == null) return;

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty())
        {
            BinaryTreeNode node = queue.poll();
            assert node != null;
            System.out.print(node.value + " ");

            if (node.left != null)
                queue.offer(node.left);

            if (node.right != null)
                queue.offer(node.right);
        }
        System.out.println();
    }
}
