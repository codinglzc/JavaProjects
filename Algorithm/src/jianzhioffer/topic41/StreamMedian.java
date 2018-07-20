package jianzhioffer.topic41;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <p>
 * 面试题41：数据流中的中位数
 * 题目：如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * </p>
 *
 * @author Liu Cong
 * @since 2018-07-13
 */
public class StreamMedian
{
    private Queue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());
    private Queue<Integer> min = new PriorityQueue<>();
    private boolean isOddCount = true;

    public void insert(int item)
    {
        if (isOddCount) // 如果数据总数为偶数，则插入到最小堆
        {
            if (max.size() > 0 && item < max.peek())
            {
                max.offer(item);
                min.offer(max.poll());
            } else
                min.offer(item);
            isOddCount = false;
        } else // 如果数据总数为奇数，则插入到最大堆
        {
            if (min.size() > 0 && item > min.peek())
            {
                min.offer(item);
                max.offer(min.poll());
            } else
                max.offer(item);
            isOddCount = true;
        }
    }

    public double getMedian()
    {
        if (max.size() == 0 && min.size() == 0) return 0.0;

        //noinspection ConstantConditions
        return isOddCount ? (max.peek() + min.peek()) / 2.0 : min.peek();
    }

    public static void main(String[] args)
    {
        StreamMedian streamMedian = new StreamMedian();
        streamMedian.insert(5);
        System.out.println(streamMedian.getMedian());
        streamMedian.insert(3);
        System.out.println(streamMedian.getMedian());
        streamMedian.insert(2);
        System.out.println(streamMedian.getMedian());
        streamMedian.insert(1);
        System.out.println(streamMedian.getMedian());
        streamMedian.insert(4);
        System.out.println(streamMedian.getMedian());
    }
}
