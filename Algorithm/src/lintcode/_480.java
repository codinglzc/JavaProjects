package lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 480. 二叉树的所有路径
 * 给一棵二叉树，找出从根节点到叶子节点的所有路径。
 * <p>
 * 样例：
 * 给出下面这棵二叉树：
 * ...1
 * ./   \
 * 2     3
 * .\
 * ..5
 * 所有根到叶子的路径为：
 * [
 * "1->2->5",
 * "1->3"
 * ]
 * @Author: lc
 * @Date: Created in 2018-04-09
 */
public class _480
{
    /**
     * @param root: the root of the binary tree
     * @return: all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root)
    {
        // write your code here
        List<String> result = new ArrayList<>();
        if (root == null) return result;
        recur(result, root, String.valueOf(root.val));
        return result;
    }

    public void recur(List<String> result, TreeNode node, String temp)
    {
        if (node.left == null && node.right == null)
        {
            result.add(temp);
            return;
        }

        if (node.left != null)
        {
            recur(result, node.left, temp + "->" + node.left.val);
        }

        if (node.right != null)
        {
            recur(result, node.right, temp + "->" + node.right.val);
        }
    }
}
