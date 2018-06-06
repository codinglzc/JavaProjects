package lintcode;

import java.util.List;

/**
 * @Description: 104. 合并k个排序链表
 * 合并k个排序链表，并且返回合并后的排序链表。尝试分析和描述其复杂度。
 * <p>
 * 样例：
 * 给出3个排序链表[2->4->null,null,-1->null]，返回 -1->2->4->null
 * @Author: lc
 * @Date: Created in 2018/3/7
 */
public class _104
{
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists)
    {
        // write your code here
        if (lists.size() == 0)
            return null;

        ListNode res = lists.get(0);
        for (int i = 1; i < lists.size(); i++)
        {
            res = mergeTwoLists(res, lists.get(i));
        }
        return res;
    }

    public ListNode mergeTwoLists(ListNode A, ListNode B)
    {
        if (A == null)
            return B;
        if (B == null)
            return A;

        ListNode res = new ListNode(0);
        ListNode cur = res;
        while (A != null && B != null)
        {
            if (A.val < B.val)
            {
                cur.next = A;
                A = A.next;
            } else
            {
                cur.next = B;
                B = B.next;
            }
            cur = cur.next;
        }

        if (A == null)
        {
            cur.next = B;
        }

        if (B == null)
        {
            cur.next = A;
        }

        return res.next;
    }
}
