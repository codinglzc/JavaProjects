package lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 376. 二叉树的路径和
 * 给定一个二叉树，找出所有路径中各节点相加总和等于给定 目标值 的路径。
 * <p>
 * 一个有效的路径，指的是从根节点到叶节点的路径。
 * <p>
 * 样例：
 * 给定一个二叉树，和 目标值 = 5:
 * ....1
 * .../ \
 * ..2   4
 * ./ \
 * 2   3
 * 返回：
 * [
 * [1, 2, 2],
 * [1, 4]
 * ]
 * @Author: lc
 * @Date: Created in 2018-04-09
 */
public class _376
{
    /*
     * @param root: the root of binary tree
     * @param target: An integer
     * @return: all valid paths
     */
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target)
    {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        List<Integer> temp = new ArrayList<>();
        temp.add(root.val);
        recur(result, temp, root, target, root.val);
        return result;
    }

    public void recur(List<List<Integer>> result, List<Integer> temp, TreeNode node, int target, int sum)
    {
        if (node.left == null && node.right == null)
        {
            if (sum == target) result.add(new ArrayList<>(temp));
            return;
        }

        if (node.left != null)
        {
            temp.add(node.left.val);
            recur(result, temp, node.left, target, sum + node.left.val);
            temp.remove(temp.size() - 1);
        }

        if (node.right != null)
        {
            temp.add(node.right.val);
            recur(result, temp, node.right, target, sum + node.right.val);
            temp.remove(temp.size() - 1);
        }
    }
}
