package jianzhioffer.topic32;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>
 * 题目二：分行从上到下打印二叉树（P.174）
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 * </p>
 *
 * @author Liu Cong
 * @since 2018-07-11
 */
public class PrintTreesInLines
{
    private class BinaryTreeNode
    {
        public int value;
        public BinaryTreeNode left;
        public BinaryTreeNode right;
    }

    public void print(BinaryTreeNode root)
    {
        if (root == null) return;

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int nextLevel = 0;
        int toBePrinted = 1;
        while (!queue.isEmpty())
        {
            BinaryTreeNode node = queue.poll();
            System.out.print(node.value + " ");
            if (node.left != null)
            {
                queue.offer(node.left);
                nextLevel++;
            }
            if (node.right != null)
            {
                queue.offer(node.right);
                nextLevel++;
            }
            toBePrinted--;
            if (toBePrinted == 0)
            {
                System.out.println();
                toBePrinted = nextLevel;
                nextLevel = 0;
            }
        }
    }
}
