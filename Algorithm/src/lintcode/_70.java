package lintcode;

import java.util.*;

/**
 * @Description: 70. 二叉树的层次遍历 II
 * 给出一棵二叉树，返回其节点值从底向上的层次序遍历（按从叶节点所在层到根节点所在的层遍历，然后逐层从左往右遍历）
 * <p>
 * 样例：
 * 给出一棵二叉树 {3,9,20,#,#,15,7},
 * ...3
 * ../ \
 * .9  20
 * .../  \
 * ..15   7
 * 按照从下往上的层次遍历为：
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 * @Author: lc
 * @Date: Created in 2018-04-09
 */
public class _70
{
    /**
     * @param root: A tree
     * @return: buttom-up level order a list of lists of integer
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root)
    {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty())
        {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            while (size-- > 0)
            {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left != null)
                {
                    queue.offer(node.left);
                }
                if (node.right != null)
                {
                    queue.offer(node.right);
                }
            }
            result.add(temp);
        }
        Collections.reverse(result);
        return result;
    }
}
