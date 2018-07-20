package jianzhioffer.topic25;

/**
 * <p>
 * 面试题25：合并两个排序的链表（P.145）
 * 题目：输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * </p>
 *
 * @author Liu Cong
 * @since 2018-07-11
 */
public class MergeSortedLists
{
    private class ListNode
    {
        public int value;
        public ListNode next;
    }

    /**
     * 非递归解法
     */
    public ListNode solution1(ListNode head1, ListNode head2)
    {
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        ListNode node1 = head1, node2 = head2;
        ListNode resNode = new ListNode();
        ListNode curNode = resNode;
        while (node1 != null && node2 != null)
        {
            if (node1.value < node2.value)
            {
                curNode.next = node1;
                curNode = curNode.next;
                node1 = node1.next;
            } else
            {
                curNode.next = node2;
                curNode = curNode.next;
                node2 = node2.next;
            }
        }

        return resNode.next;
    }

    /**
     * 递归解法
     */
    public ListNode solution2(ListNode head1, ListNode head2)
    {
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        ListNode resNode;

        if (head1.value < head2.value)
        {
            resNode = head1;
            resNode.next = solution2(head1.next, head2);
        } else
        {
            resNode = head2;
            resNode.next = solution2(head1, head2.next);
        }

        return resNode;


    }
}
