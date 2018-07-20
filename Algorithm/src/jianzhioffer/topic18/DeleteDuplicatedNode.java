package jianzhioffer.topic18;

/**
 * @description: 面试题18：删除链表的节点（P.122）
 * 题目二：删除链表中重复的节点。
 * 在一个排序的链表中，如何删除重复的节点？
 * 例如：链表————1,2,3,3,4,4,5 删除重复节点之后为 1,2,5
 * @author: Liu Cong
 * @create: Created at 2018-06-22
 */
public class DeleteDuplicatedNode
{
    public static void deleteDuplication(ListNode head)
    {
        if (head == null) return;

        ListNode first = new ListNode();
        first.next = head;
        ListNode preNode = first;
        ListNode curNode = head;
        while (curNode != null && curNode.next != null)
        {
            if (curNode.value == curNode.next.value)
            {
                int value = curNode.value;
                while (curNode != null && curNode.value == value)
                {
                    curNode = curNode.next;
                }

                preNode.next = curNode;
            } else
            {
                preNode = curNode;
                curNode = curNode.next;
            }
        }
    }
}
