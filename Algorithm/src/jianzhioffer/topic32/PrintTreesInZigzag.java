package jianzhioffer.topic32;

import java.util.*;

/**
 * <p>
 * 题目三：之字形打印二叉树（P.176）
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，
 * 其他行以此类推。
 * </p>
 *
 * @author Liu Cong
 * @since 2018-07-11
 */
public class PrintTreesInZigzag
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

        List<Stack<BinaryTreeNode>> stackList = new ArrayList<>();
        stackList.add(new Stack<>());
        stackList.add(new Stack<>());
        stackList.get(0).push(root);
        int current = 0;
        while (!stackList.get(0).isEmpty() || !stackList.get(1).isEmpty())
        {
            BinaryTreeNode node = stackList.get(current).pop();
            System.out.print(node.value + " ");

            if (current == 0)
            {
                if (node.left != null)
                    stackList.get(1).push(node.left);
                if (node.right != null)
                    stackList.get(1).push(node.right);
            } else
            {
                if (node.right != null)
                    stackList.get(0).push(node.right);
                if (node.left != null)
                    stackList.get(0).push(node.left);
            }

            if (stackList.get(current).isEmpty())
            {
                System.out.println();
                current = 1 - current;
            }
        }
    }

}
