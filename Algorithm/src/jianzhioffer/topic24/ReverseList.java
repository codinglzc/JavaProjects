package jianzhioffer.topic24;

/**
 * <p>
 * 面试题24：反转链表（P.142）
 * 题目：定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * </p>
 *
 * @author Liu Cong
 * @since 2018-07-09
 */
public class ReverseList
{
    private class ListNode
    {
        public int value;
        public ListNode next;
    }

    public ListNode reverseList(ListNode head)
    {
        ListNode resNode = null;

        ListNode preNode = null;
        ListNode curNode = head;
        ListNode nextNode;

        while (curNode != null)
        {
            nextNode = curNode.next;

            if (nextNode == null)
                resNode = curNode;

            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }

        return resNode;
    }
}
