package jianzhioffer.topic35;

/**
 * <p>
 * 面试题35：复杂链表的复制（P.187）
 * 题目：请实现函数 ComplexListNode Clone(ComplexListNode head)，复制一个复杂链表。在复杂链表中，每个节点除了有一个next指针指向下
 * 一个节点，还有一个sibling指针指向链表中的任意节点或者null。
 * </p>
 *
 * @author Liu Cong
 * @since 2018-07-12
 */
public class CopyComplexList
{
    private class ComplexListNode
    {
        public int value;
        public ComplexListNode next;
        public ComplexListNode sibling;
    }

    public ComplexListNode cloneList(ComplexListNode head)
    {
        // 1.第一步，复制原链表的任意节点 N 并创建新节点 N'，再把 N' 链接到 N 的后面。
        cloneNodes(head);

        // 2.第二步，设置复制出来的节点的 sibling。
        connectSiblingNodes(head);

        // 3.第三步，把这个长链表拆分成两个链表：把奇数位置的节点用 next 链接起来就是原始链表，把偶数位置的节点用 next 链接起来就是复制出来的链表。
        return reconnectNodes(head);
    }

    private ComplexListNode reconnectNodes(ComplexListNode head)
    {
        ComplexListNode node = head;
        ComplexListNode clonedHead = null;
        ComplexListNode clonedNode = null;

        if (node != null)
        {
            clonedHead = clonedNode = node.next;
            node.next = clonedNode.next;
            node = node.next;
        }

        while (node != null)
        {
            clonedNode.next = node.next;
            clonedNode = clonedNode.next;
            node.next = clonedNode.next;
            node = node.next;
        }
        return clonedHead;
    }

    private void connectSiblingNodes(ComplexListNode head)
    {
        ComplexListNode node = head;
        while (node != null)
        {
            ComplexListNode clonedNode = node.next;
            if (node.sibling != null)
                clonedNode.sibling = node.sibling.next;

            node = clonedNode.next;
        }
    }

    private void cloneNodes(ComplexListNode head)
    {
        ComplexListNode node = head;
        while (node != null)
        {
            ComplexListNode clonedNode = new ComplexListNode();
            clonedNode.value = node.value;
            clonedNode.next = node.next;
            clonedNode.sibling = null;

            node.next = clonedNode;

            node = clonedNode.next;
        }
    }
}
