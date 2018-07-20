package jianzhioffer.topic09;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: 相关题目：用两个队列实现一个栈
 * @author: Liu Cong
 * @create: Created at 2018-06-15
 */
public class StackWithTwoQueues<T>
{
    private Queue<T> queue1 = new LinkedList<>();
    private Queue<T> queue2 = new LinkedList<>();

    public void push(T val)
    {
        if (!queue1.isEmpty())
        {
            queue1.offer(val);
        } else
        {
            queue2.offer(val);
        }
    }

    public T pop()
    {
        if (!queue1.isEmpty())
        {
            int size = queue1.size();
            for (int i = 0; i < size - 1; i++)
            {
                queue2.offer(queue1.poll());
            }
            return queue1.poll();
        } else
        {
            int size = queue2.size();
            for (int i = 0; i < size - 1; i++)
            {
                queue1.offer(queue2.poll());
            }
            return queue2.poll();
        }
    }

    public static void main(String[] args)
    {
        StackWithTwoQueues<Integer> stack = new StackWithTwoQueues<>();
        for (int i = 0; i < 10; i++)
        {
            stack.push(i);
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < 10; i++)
        {
            System.out.print(stack.pop() + " ");
        }

    }
}
