package jianzhioffer.topic30;

import java.util.Stack;

/**
 * <p>
 * 面试题30：包含 min 函数的栈（P.165）
 * 题目：定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数。在该栈中，调用 min、push 及 pull 的时间复杂度都是O(1)
 * </p>
 *
 * @author Liu Cong
 * @since 2018-07-11
 */
public class MinInStack<T extends Comparable<T>>
{
    private Stack<T> dataStack;
    private Stack<T> minStack;

    public MinInStack()
    {
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(T item)
    {
        if (dataStack.isEmpty())
        {
            dataStack.push(item);
            minStack.push(item);
        } else
        {
            dataStack.push(item);
            T minItem = minStack.peek();
            if (item.compareTo(minItem) < 0)
                minStack.push(item);
            else
                minStack.push(minItem);
        }
    }

    public T pop()
    {
        if (dataStack.isEmpty() && minStack.isEmpty())
            throw new RuntimeException("MinInStack is empty!");

        minStack.pop();
        return dataStack.pop();
    }

    public T min()
    {
        if (dataStack.isEmpty() && minStack.isEmpty())
            throw new RuntimeException("MinInStack is empty!");

        return minStack.peek();
    }
}
