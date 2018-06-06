package lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 66. 二叉树的前序遍历
 * 给出一棵二叉树，返回其节点值的前序遍历。
 * <p>
 * 前序遍历：根节点->左子树->右子树
 * <p>
 * 中序遍历：左子树->根节点->右子树
 * <p>
 * 后序遍历：左子树->右子树->根节点
 * @Author: lc
 * @Date: Created in 2018/3/12
 */
public class _66
{
    /**
     * @param root: A Tree
     * @return: Preorder in ArrayList which contains node values.
     */
    public List<Integer> preorderTraversal(TreeNode root)
    {
        // write your code here
        List<Integer> res = new ArrayList<>();
        recur(res, root);
        return res;
    }

    public void recur(List<Integer> res, TreeNode node)
    {
        if (node == null) return;

        res.add(node.val);
        recur(res, node.left);
        recur(res, node.right);
    }
}
