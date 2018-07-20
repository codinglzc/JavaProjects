package jianzhioffer.topic06;

/**
 * @description: 面试题6：从尾到头打印链表
 * 题目：输入一个链表的头节点，从尾到头反过来打印出每个节点的值。
 * @author: Liu Cong
 * @create: Created at 2018-06-13
 */
public class PrintListInReversedOrder
{
    static class Node
    {
        int val;
        Node next = null;

        public Node(int val)
        {
            this.val = val;
        }
    }

    public static void printListReversingly(Node head)
    {
        if (head == null) return;

        if (head.next != null)
        {
            printListReversingly(head.next);
        }
        System.out.println(head.val);
    }

    public static void main(String[] args)
    {
        Node head = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        head.next = node1;
        node1.next = node2;

        printListReversingly(head);
    }
}
