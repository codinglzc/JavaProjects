package lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 68. 二叉树的后序遍历
 * 给出一棵二叉树，返回其节点值的后序遍历。
 * @Author: lc
 * @Date: Created in 2018/3/12
 */
public class _68
{
    /**
     * @param root: A Tree
     * @return: Postorder in ArrayList which contains node values.
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        recur(res, root);
        return res;
    }

    public void recur(List<Integer> res, TreeNode node)
    {
        if (node == null) return;

        recur(res, node.left);
        recur(res, node.right);
        res.add(node.val);
    }
}
