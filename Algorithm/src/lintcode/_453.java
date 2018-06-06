package lintcode;

/**
 * @Description: 453. 将二叉树拆成链表
 * 将一棵二叉树按照前序遍历拆解成为一个假链表。所谓的假链表是说，用二叉树的 right 指针，来表示链表中的 next 指针。
 * <p>
 * 注意事项：
 * 不要忘记将左儿子标记为 null，否则你可能会得到空间溢出或是时间溢出。
 * <p>
 * 样例：
 * ..............1
 * ...............\
 * .....1          2
 * ..../ \          \
 * ...2   5    =>    3
 * ../ \   \          \
 * .3   4   6          4
 * .....................\
 * ......................5
 * .......................\
 * ........................6
 * @Author: lc
 * @Date: Created in 2018-03-21
 */
public class _453
{
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void flatten(TreeNode root)
    {
        // write your code here
        if (root == null) return;
        if (root.left == null)
        {
            flatten(root.right);
            return;
        }

        TreeNode oldRight = root.right;
        root.right = root.left;
        root.left = null;

        TreeNode temp = root.right;
        while (temp.right != null)
        {
            temp = temp.right;
        }
        temp.right = oldRight;
        flatten(root.right);
    }
}
