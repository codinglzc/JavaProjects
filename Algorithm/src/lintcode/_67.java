package lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 67. 二叉树的中序遍历
 * 给出一棵二叉树,返回其中序遍历
 * @Author: lc
 * @Date: Created in 2018/3/12
 */
public class _67
{
    /**
     * @param root: A Tree
     * @return: Inorder in ArrayList which contains node values.
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        recur(res, root);
        return res;
    }

    public void recur(List<Integer> res, TreeNode node)
    {
        if (node == null) return;

        recur(res, node.left);
        res.add(node.val);
        recur(res, node.right);
    }
}
