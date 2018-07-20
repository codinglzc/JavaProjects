package jianzhioffer.topic40;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * <p>
 * 面试题40：最小的 K 个数（P.209）
 * 题目：输入 n 个整数据，找出其中最小的 k 个数。
 * 例如，输入 4,5,1,6,2,7,3,8 这8个数字，则最小的4个数字是 1,2,3,4.
 * </p>
 *
 * @author Liu Cong
 * @since 2018-07-13
 */
public class KLeastNumbers2
{
    /**
     * 解法二：时间复杂度为 O(nlogk)的算法啊，特别适合处理海量数据
     * <p>
     * 思路：基于最大堆或红黑树实现（这里基于jdk的优先队列实现）
     */
    public static Integer[] getLeastNumbers(int[] nums, int k)
    {
        if (nums == null || nums.length <= 0) return null;

        FixSizedPriorityQueue<Integer> queue = new FixSizedPriorityQueue<>(k);
        for (int num : nums)
        {
            queue.add(nums[k]);
        }

        return queue.getArrayFormQueue();
    }

    static class FixSizedPriorityQueue<T extends Comparable<T>>
    {
        private PriorityQueue<T> queue;
        private int maxSize; // 堆的最大容量

        public FixSizedPriorityQueue(int maxSize)
        {
            if (maxSize <= 0)
                throw new IllegalArgumentException();
            this.maxSize = maxSize;
            this.queue = new PriorityQueue<>(maxSize, new Comparator<T>()
            {
                @Override
                public int compare(T o1, T o2)
                {
                    return o2.compareTo(o1);
                }
            });
        }

        public void add(T o)
        {
            if (queue.size() < maxSize)
                queue.add(o);
            else
            {
                T peek = queue.peek();
                assert peek != null;
                if (o.compareTo(peek) < 0)
                {
                    queue.poll();
                    queue.add(o);
                }
            }
        }

        @SuppressWarnings("unchecked")
        public T[] getArrayFormQueue()
        {
            Object[] res = new Object[maxSize];
            for (int i = 0; i < maxSize; i++)
            {
                res[i] = queue.poll();
            }
            return (T[]) res;
        }
    }

}
