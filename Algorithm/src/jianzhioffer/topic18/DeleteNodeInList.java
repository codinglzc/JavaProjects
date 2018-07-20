package jianzhioffer.topic18;

/**
 * @description: 面试题18：删除链表的节点（P.119）
 * 题目一：在 O(1)时间内删除链表节点。
 * 给定单向链表的头指针和一个节点指针，定义一个函数在 O(1) 时间内删除该节点。
 * @author: Liu Cong
 * @create: Created at 2018-06-22
 */
public class DeleteNodeInList
{
    /**
     * 思路：如果我们把下一个节点的内容复制到需要删除的节点上覆盖原有的内容，再把下一个节点删除，那就相当于把当前需要删除的节点删除了。
     * <p>
     * 时间复杂度：[(n-1)*O(1) + O(n)] / n = O(1)
     *
     * @param head        链表头节点
     * @param toBeDeleted 要删除的节点
     */
    public static void deleteNode(ListNode head, ListNode toBeDeleted)
    {
        if (head == null || toBeDeleted == null) return;

        if (toBeDeleted.next != null) // 要删除的节点不是尾节点
        {
            ListNode next = toBeDeleted.next;
            toBeDeleted.value = next.value;
            toBeDeleted.next = next.next;
            next = null;
        }
        // 链表只有一个节点，删除头节点（也是尾节点）
        else if (head == toBeDeleted)
        {
            head = null;
            toBeDeleted = null;
        }
        // 链表中有多个节点，且 toBeDeleted 为尾节点
        else
        {
            ListNode tmp = head;
            while (tmp.next != toBeDeleted)
            {
                tmp = tmp.next;
            }
            tmp.next = null;
            toBeDeleted = null;
        }
    }
}
