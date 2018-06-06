package lintcode;

/**
 * @Description: 106. 排序列表转换为二分查找树
 * 给出一个所有元素以升序排序的单链表，将它转换成一棵高度平衡的二分查找树
 * @Author: lc
 * @Date: Created in 2018/3/13
 */
public class _106
{
    /*
     * @param head: The first node of linked list.
     * @return: a tree node
     */
    public TreeNode sortedListToBST(ListNode head)
    {
        // write your code here
        ListNode temp = head;
        int n = 0;
        while (temp != null)
        {
            n++;
            temp = temp.next;
        }

        TreeNode root = recur(head, n);
        return root;
    }

    public TreeNode recur(ListNode head, int n)
    {
        if (head == null || n == 0) return null;
        if (n == 1) return new TreeNode(head.val);

        ListNode temp = head;
        for (int i = 0; i < n / 2; i++)
        {
            temp = temp.next;
        }

        TreeNode node = new TreeNode(temp.val);
        node.left = recur(head, n / 2);
        node.right = recur(temp.next, n - n / 2 - 1);
        return node;
    }

}
