package jianzhioffer.topic31;

import java.util.Stack;

/**
 * <p>
 * 面试题31：栈的压入、弹出序列
 * 题目：输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如，序列{1,2,3,4,5}是某栈的压栈序列，序列{4,5,3,2,1}是该压栈序列对应的一个弹出序列，但{4,3,5,1,2}就不可能是该压栈序列的弹出序列。
 * </p>
 *
 * @author Liu Cong
 * @since 2018-07-11
 */
public class StackPushPopOrder
{
    /**
     * 思路：如何判断一个序列是不是栈的弹出序列？
     * 如果下一个弹出的数字刚好是栈顶数字，那么直接弹出；
     * 如果下一个弹出的数字不在栈顶，则把压栈序列中还没有入栈的数字压入辅助栈，直到把下一个需要弹出的数字压入栈顶为止；
     * 如果所有数字都压入栈后仍然没有找到下一个弹出的数字，那么该序列不可能是一个弹出序列。
     */
    public static boolean isPopOrder(int[] pushNums, int[] popNums)
    {
        if (pushNums == null || popNums == null || pushNums.length != popNums.length || pushNums.length <= 0)
            return false;

        int len = pushNums.length;
        Stack<Integer> stack = new Stack<>();
        int indexPopNums = 0;
        for (int pushNum : pushNums)
        {
            stack.push(pushNum);

            while (!stack.isEmpty() && indexPopNums < len)
            {
                if (stack.peek() == popNums[indexPopNums])
                {
                    stack.pop();
                    indexPopNums++;
                } else
                    break;
            }
        }

        return stack.isEmpty() && indexPopNums == len;
    }

    public static void main(String[] args)
    {
        System.out.println(isPopOrder(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}));
        System.out.println(isPopOrder(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2}));
    }
}
