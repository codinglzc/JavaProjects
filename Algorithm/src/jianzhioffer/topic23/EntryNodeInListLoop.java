package jianzhioffer.topic23;

/**
 * <p>
 * 面试题23：链表中环的入口节点（P.139）
 * 题目：如果一个链表中包含环，如何找出环的入口节点？
 * </p>
 *
 * @author Liu Cong
 * @since 2018-07-09
 */
public class EntryNodeInListLoop
{
    private class ListNode
    {
        public int value;
        public ListNode next;
    }

    /**
     * 思路：1.找出环中任意一个节点；2.得到环中节点的数目；3.找到环的入口节点。
     * @param head 链表头节点
     * @return 如果有环，返回环入口节点；否则，返回 null。
     */
    public ListNode solution(ListNode head)
    {
        ListNode meetingNode = isHasMeetingNode(head);
        if (meetingNode == null) return null;

        // 得到环中节点的数目
        int nodesInLoop = 1;
        ListNode tmpNode = meetingNode;
        while (tmpNode.next != meetingNode)
        {
            tmpNode = tmpNode.next;
            nodesInLoop++;
        }

        // 先移动 tmpNode，次数为环中节点的数目
        tmpNode = head;
        for (int i = 0; i < nodesInLoop; i++)
        {
            tmpNode = tmpNode.next;
        }

        // 再移动 resNode 和 tmpNode
        ListNode resNode = head;
        while (resNode != tmpNode)
        {
            resNode = resNode.next;
            tmpNode = tmpNode.next;
        }

        return resNode;
    }

    /**
     * 判断一个链表中是否含有环
     *
     * @param head 链表头节点
     * @return 如果有环，则返回环中一个节点；否则，返回 null。
     */
    private ListNode isHasMeetingNode(ListNode head)
    {
        if (head == null) return null;

        ListNode slowNode = head.next;
        if (slowNode == null) return null;
        ListNode fastNode = slowNode.next;
        while (slowNode != null && fastNode != null)
        {
            if (slowNode == fastNode) return slowNode;

            slowNode = slowNode.next;

            fastNode = fastNode.next;
            if (fastNode == null) return null;
            fastNode = fastNode.next;
        }

        return null;
    }
}
