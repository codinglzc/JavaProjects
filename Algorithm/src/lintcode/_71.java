package lintcode;

import java.util.*;

/**
 * @Description: 71. 二叉树的锯齿形层次遍历
 * 给出一棵二叉树，返回其节点值的锯齿形层次遍历（先从左往右，下一层再从右往左，层与层之间交替进行）
 * <p>
 * 样例：
 * 给出一棵二叉树 {3,9,20,#,#,15,7},
 * ...3
 * ../ \
 * .9  20
 * .../  \
 * ..15   7
 * 返回其锯齿形的层次遍历为：
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 * @Author: lc
 * @Date: Created in 2018-04-09
 */
public class _71
{
    /**
     * @param root: A Tree
     * @return: A list of lists of integer include the zigzag level order traversal of its nodes' values.
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root)
    {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = true;
        while (!queue.isEmpty())
        {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            while (size-- > 0)
            {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            if (!flag)
            {
                Collections.reverse(temp);
            }
            flag = !flag;
            result.add(temp);
        }
        return result;
    }
}
