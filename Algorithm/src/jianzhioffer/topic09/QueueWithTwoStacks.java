package jianzhioffer.topic09;

import java.util.Stack;

/**
 * @description: 面试题9：用两个栈实现队列（P.68）
 * 题目：用两个栈实现一个队列。队列声明如下，请实现它的两个函数 appendTail 和 deleteHead，分别完成在队列尾部插入节点和在队列头部删除节点的功能。
 * @author: Liu Cong
 * @create: Created at 2018-06-15
 */
public class QueueWithTwoStacks<T>
{
    private Stack<T> stack1 = new Stack<>();
    private Stack<T> stack2 = new Stack<>();

    public void appendTail(T val)
    {
        stack1.push(val);
    }

    public T deleteHead() throws Exception
    {
        if (stack2.isEmpty())
        {
            while (!stack1.isEmpty())
            {
                T tmp = stack1.pop();
                stack2.push(tmp);
            }
        }

        if (stack2.isEmpty()) throw new Exception("queue is empty");

        return stack2.pop();
    }

    public static void main(String[] args) throws Exception
    {
        QueueWithTwoStacks<Integer> queue = new QueueWithTwoStacks<>();
        for (int i = 0; i < 10; i++)
        {
            queue.appendTail(i);
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < 10; i++)
        {
            System.out.print(queue.deleteHead() + " ");
        }
    }
}
