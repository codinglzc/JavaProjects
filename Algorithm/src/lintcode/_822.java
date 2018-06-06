package lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 822. Reverse Order Storage
 * Give a linked list, and store the values of linked list in reverse order into an array.
 * <p>
 * 样例：
 * Given 1 -> 2 -> 3 -> null, return [3,2,1].
 * @Author: lc
 * @Date: Created in 2018/3/14
 */
public class _822
{
    /**
     * @param head: the given linked list
     * @return: the array that store the values in reverse order
     */
    public List<Integer> reverseStore(ListNode head)
    {
        // write your code here
        List<Integer> res = new ArrayList<>();
        ListNode node = head;
        while (node != null)
        {
            res.add(node.val);
            node = node.next;
        }
        for (int i = 0; i < res.size() / 2; i++)
        {
            int temp = res.get(i);
            res.set(i, res.get(res.size() - 1 - i));
            res.set(res.size() - 1 - i, temp);
        }
        return res;
    }
}
