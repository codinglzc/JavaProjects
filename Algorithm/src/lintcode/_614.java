package lintcode;

/**
 * @Description: 614. 二叉树的最长连续子序列 II
 * 给定一棵二叉树，找到最长连续序列路径的长度。
 * 路径起点跟终点可以为二叉树的任意节点。
 * <p>
 * 样例：
 * ....1
 * .../ \
 * ..2   0
 * ./
 * 3
 * 返回 4 // 0-1-2-3
 * <p>
 * 标签：
 * 二叉树 谷歌 深度优先搜索
 * @Author: lc
 * @Date: Created in 2018-04-19
 */
public class _614
{
    class ResultType
    {
        int max_length;
        int max_up;
        int max_down;

        public ResultType(int l, int u, int d)
        {
            this.max_length = l;
            this.max_up = u;
            this.max_down = d;
        }
    }

    /**
     * @param root: the root of binary tree
     * @return: the length of the longest consecutive sequence path
     */
    public int longestConsecutive2(TreeNode root)
    {
        return helper(root).max_length;
    }

    public ResultType helper(TreeNode node)
    {
        if (node == null) return new ResultType(0, 0, 0);

        ResultType left = helper(node.left);
        ResultType right = helper(node.right);

        int up = 0;
        int down = 0;
        int max_length = 1;

        if (node.left != null && node.left.val - 1 == node.val)
            up = Math.max(up, left.max_up + 1);

        if (node.left != null && node.left.val + 1 == node.val)
            down = Math.max(down, left.max_down + 1);

        if (node.right != null && node.right.val - 1 == node.val)
            up = Math.max(up, right.max_up + 1);

        if (node.right != null && node.right.val + 1 == node.val)
            down = Math.max(down, right.max_down + 1);

        max_length = Math.max(left.max_length, right.max_length);

        max_length = Math.max(up + 1 + down, max_length);

        return new ResultType(max_length, up, down);
    }
}
