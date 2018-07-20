package jianzhioffer.topic22;

/**
 * <p>
 * 面试题22：链表中倒数第 K 个节点（P.134）
 * 题目：输入一个链表，输出该链表中倒数第 K 个节点。为了符合大多数人的习惯，本题从 1 开始计数，即链表的尾节点是倒数第 1 个节点。
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 * </p>
 *
 * @author Liu Cong
 * @since 2018-07-09
 */
public class KthNodeFromEnd
{
    private class ListNode
    {
        public int value;
        public ListNode next;
    }

    /**
     * 思路：维护两个指针即可
     * @param head 头节点
     * @param k K值
     * @return 倒数第 K 个节点
     */
    public ListNode solution1(ListNode head, int k)
    {
        if (head == null || k <= 0) return null;

        ListNode ahead = head;
        ListNode behind = head;
        for (int i = 0; i < k - 1; i++)
        {
            if (behind.next == null)
                return null;
            behind = behind.next;
        }

        while (behind.next != null)
        {
            ahead = ahead.next;
            behind = behind.next;
        }

        return ahead;
    }
}
