package jianzhioffer.topic07;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: 面试题7：重建二叉树（P.62）
 * 题目：输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如，输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则
 * 重建如图2.6所示的二叉树并输出它的头节点。
 * @author: Liu Cong
 * @create: Created at 2018-06-14
 */
public class ConstructBinaryTree
{
    static class BinaryTreeNode
    {
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;

        public BinaryTreeNode()
        {
            value = 0;
            left = null;
            right = null;
        }

        public BinaryTreeNode(int value)
        {
            this();
            this.value = value;
        }
    }

    /**
     * @param preOrder 前序遍历序列
     * @param inOder   中序遍历序列
     * @return 二叉树的根节点
     * @throws Exception 异常
     */
    public static BinaryTreeNode construct(int[] preOrder, int[] inOder) throws Exception
    {
        if (preOrder == null || inOder == null
                || preOrder.length <= 0 || inOder.length <= 0
                || preOrder.length != inOder.length)
            return null;

        return constructCore(preOrder, 0, preOrder.length - 1,
                inOder, 0, inOder.length - 1);
    }

    /**
     * @param preOrder      前序遍历序列
     * @param preIndexStart preIndexStart
     * @param preIndexEnd   preIndexEnd
     * @param inOder        中序遍历序列
     * @param inIndexStart  inIndexStart
     * @param inIndexEnd    inIndexEnd
     * @return 二叉树的根节点
     * @throws Exception 异常
     */
    private static BinaryTreeNode constructCore(int[] preOrder, int preIndexStart, int preIndexEnd,
                                                int[] inOder, int inIndexStart, int inIndexEnd) throws Exception
    {
        BinaryTreeNode root = new BinaryTreeNode(preOrder[preIndexStart]); // 前序遍历的第一个数是根节点

        // 当前序遍历和中序遍历都只剩一个节点的时候
        if (preIndexStart == preIndexEnd)
        {
            if (inIndexStart == inIndexEnd && preOrder[preIndexStart] == inOder[inIndexStart])
                return root;
            else
                throw new Exception("Invalid input.");
        }

        // 在中序遍历序列中找到根节点下标
        int inIndexMid = inIndexStart;
        for (; inIndexMid <= inIndexEnd; inIndexMid++)
        {
            if (inOder[inIndexMid] == root.value) break;
        }
        if (inIndexMid > inIndexEnd) throw new Exception("Invalid input.");

        int leftLength = inIndexMid - inIndexStart;
        int leftPreIndexEnd = preIndexStart + leftLength;
        if (leftLength > 0)
        {
            // 构建左子树
            root.left = constructCore(preOrder, preIndexStart + 1, leftPreIndexEnd,
                    inOder, inIndexStart, inIndexMid - 1);
        }
        if (inIndexEnd > inIndexMid)
        {
            // 构建右子树
            root.right = constructCore(preOrder, leftPreIndexEnd + 1, preIndexEnd,
                    inOder, inIndexMid + 1, inIndexEnd);
        }

        return root;
    }

    public static void print(BinaryTreeNode root)
    {
        if (root == null) return;

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty())
        {
            BinaryTreeNode node = queue.poll();
            System.out.print(node.value + " ");
            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception
    {
        int[] preOrder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inOrder = {4, 7, 2, 1, 5, 3, 8, 6};
        print(construct(preOrder, inOrder));

        // 所有节点没有左子树
        preOrder = new int[]{1,3,6,8};
        inOrder = new int[]{1,3,6,8};
        print(construct(preOrder, inOrder));

        // 所有节点没有右子树
        preOrder = new int[]{1,2,4,7};
        inOrder = new int[]{7,4,2,1};
        print(construct(preOrder, inOrder));

        // 只有一个节点
        preOrder = new int[]{1,};
        inOrder = new int[]{1,};
        print(construct(preOrder, inOrder));

        // 输入的前序遍历与中序遍历不起匹配
        preOrder = new int[]{2,};
        inOrder = new int[]{1,};
        //print(construct(preOrder, inOrder));
    }
}
