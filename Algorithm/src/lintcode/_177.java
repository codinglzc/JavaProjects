package lintcode;

/**
 * @Description: 177. 把排序数组转换为高度最小的二叉搜索树
 * 给一个排序数组（从小到大），将其转换为一棵高度最小的排序二叉树。
 * @Author: lc
 * @Date: Created in 2018/3/13
 */
public class _177
{
    /*
     * @param A: an integer array
     * @return: A tree node
     */
    public TreeNode sortedArrayToBST(int[] A)
    {
        // write your code here
        TreeNode root = recur(A, 0, A.length - 1);
        return root;
    }

    public TreeNode recur(int[] A, int l, int r)
    {
        if (r - l < 0) return null;
        if (r - l == 0) return new TreeNode(A[l]);

        int mid = l + (r - l) / 2;
        TreeNode node = new TreeNode(A[mid]);
        node.left = recur(A, l, mid - 1);
        node.right = recur(A, mid + 1, r);
        return node;
    }
}
