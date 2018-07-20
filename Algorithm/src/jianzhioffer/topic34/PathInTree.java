package jianzhioffer.topic34;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 面试题34：二叉树中和为某一值得路径
 * 题目：输入一颗二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 * </p>
 *
 * @author Liu Cong
 * @since 2018-07-11
 */
public class PathInTree
{
    private class BinaryTreeNode
    {
        public int value;
        public BinaryTreeNode left;
        public BinaryTreeNode right;
    }

    /**
     * 回朔法
     */
    public static void findPath(BinaryTreeNode root, int expectedSum)
    {
        if (root == null) return;

        List<BinaryTreeNode> nodeList = new ArrayList<>();
        int currentSum = 0;
        findPath(root, expectedSum, nodeList, currentSum);
    }

    private static void findPath(BinaryTreeNode node, int expectedSum, List<BinaryTreeNode> nodeList, int currentSum)
    {
        currentSum += node.value;
        nodeList.add(node);

        // 如果是叶节点，并且路径上节点值的和等于输入的值，则打印出这条路径。
        boolean isLeaf = node.left == null && node.right == null;
        if (currentSum == expectedSum && isLeaf)
        {
            nodeList.forEach(binaryTreeNode -> System.out.print(binaryTreeNode.value + " "));
            System.out.println();
        }

        // 如果不是叶节点，则遍历它的子节点
        if (node.left != null)
            findPath(node.left, expectedSum, nodeList, currentSum);
        if (node.right != null)
            findPath(node.right, expectedSum, nodeList, currentSum);

        // 在返回父节点之前，在路径上删除当前节点
        nodeList.remove(nodeList.size() - 1);
    }
}
