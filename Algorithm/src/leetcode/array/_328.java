package leetcode.array;

/**
 * @Description: 328. Odd Even Linked List
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking
 * about the node number and not the value in the nodes.
 * <p>
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 * <p>
 * Example:
 * Given 1->2->3->4->5->NULL,
 * return 1->3->5->2->4->NULL.
 * <p>
 * Note:
 * The relative order inside both the even and odd groups should remain as it was in the input.
 * The first node is considered odd, the second node even and so on ...
 * <p>
 * 题目大意：
 * 给定一个单链表，将其节点进行分组，使得所有的奇数节点排列在前，偶数节点在后。请注意这里的奇偶指的是节点序号而不是节点的值。
 * 你应当尝试“就地”完成此问题。程序应当满足O(1)的空间复杂度和O(nodes)的时间复杂度。
 * @Author: lc
 * @Date: Created in 2017/12/26
 */
public class _328
{
    public _328_ListNode oddEvenList(_328_ListNode head)
    {
        if (head == null)
            return head;
        _328_ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null)
        {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
