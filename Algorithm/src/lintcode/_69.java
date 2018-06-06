package lintcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description: 69. 二叉树的层次遍历
 * 给出一棵二叉树，返回其节点值的层次遍历（逐层从左往右访问）
 * <p>
 * 样例：
 * 给一棵二叉树 {3,9,20,#,#,15,7} ：
 * <p>
 * ...3
 * ../ \
 * .9  20
 * .../  \
 * ..15   7
 * 返回他的分层遍历结果：
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * <p>
 * 挑战:
 * 挑战1：只使用一个队列去实现它
 * 挑战2：用DFS算法来做
 * @Author: lc
 * @Date: Created in 2018-04-09
 */
public class _69
{
    /**
     * @param root: A Tree
     * @return: Level order a list of lists of integer
     */
    public List<List<Integer>> levelOrder(TreeNode root)
    {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        int parentSize = 1, childSize = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> temp = new ArrayList<>();
        do
        {
            TreeNode node = queue.poll();
            temp.add(node.val);
            parentSize--;

            if (node.left != null)
            {
                queue.offer(node.left);
                childSize++;
            }

            if (node.right != null)
            {
                queue.offer(node.right);
                childSize++;
            }

            if (parentSize == 0)
            {
                result.add(new ArrayList<>(temp));
                temp.clear();
                parentSize = childSize;
                childSize = 0;
            }
        } while (!queue.isEmpty());

        return result;
    }
}
