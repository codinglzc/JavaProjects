package lintcode;

/**
 * @Description: 245. 子树
 * 有两个不同大小的二叉树： T1 有上百万的节点； T2 有好几百的节点。请设计一种算法，判定 T2 是否为 T1的子树。
 * <p>
 * 注意事项：
 * 若 T1 中存在从节点 n 开始的子树与 T2 相同，我们称 T2 是 T1 的子树。也就是说，如果在 T1 节点 n 处将树砍断，砍断的部分将与 T2 完全相同。
 * @Author: lc
 * @Date: Created in 2018/3/13
 */
public class _245
{
    /**
     * @param T1: The roots of binary tree T1.
     * @param T2: The roots of binary tree T2.
     * @return: True if T2 is a subtree of T1, or false.
     */
    public boolean isSubtree(TreeNode T1, TreeNode T2)
    {
        // write your code here
        if (T1 == null && T2 == null) return true;
        if (T1 == null && T2 != null) return false;
        if (T1 != null && T2 == null) return true;
        return recur(T1, T2) || isSubtree(T1.left, T2) || isSubtree(T1.right, T2);
    }

    public boolean recur(TreeNode T1, TreeNode T2)
    {
        if (T1 == null && T2 == null) return true;
        if (T1 != null && T2 != null)
        {
            if (T1.val == T2.val)
            {
                return recur(T1.left, T2.left) && recur(T1.right, T2.right);
            }
        }
        return false;
    }
}
