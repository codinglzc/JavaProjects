package leetcode.array;

/**
 * @Description: 100. Same Tree
 * Given two binary trees, write a function to check if they are the same or not.
 * <p>
 * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 * 题目大意：
 * 给出两个树，判断这两个树的结构和数据是否相同。如果相同，返回true；反之，返回false；
 * @Author: lc
 * @Date: Created in 2017/12/26
 */
public class _100
{
    /**
     * 递归求解
     */
    public boolean isSameTree(_100_TreeNode p, _100_TreeNode q)
    {
        // 如果两个树对应的节点都为空，那肯定相同，返回 true
        if (p == null && q == null)
            return true;

        // 如果两个树对应的节点有一个为空，另一个不为空，那肯定不相同，返回 false
        if ((p != null && q == null) || (p == null && q != null))
            return false;

        // 只剩下两个树对应的节点都不为空了
        // 如果这两个节点的值相同，比较两个树的左儿子节点，比较两个树的右儿子节点；反之，返回fasle。
        if (p.val == q.val)
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

        return false;
    }
}
