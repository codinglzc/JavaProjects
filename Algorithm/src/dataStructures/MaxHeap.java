package dataStructures;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description: 一个最大堆的实现
 * @Author: lzc
 * @Date: Created at 2018-06-07
 */
public class MaxHeap<T extends Comparable<T>>
{
    private List<T> heap;

    public MaxHeap(List<T> heap)
    {
        this.heap = heap;
        init();
    }

    /**
     * 根据树的性质建堆，树节点前一半一定是分支节点，即有孩子的，所以我们从这里开始调整初始堆
     */
    private void init()
    {
        for (int i = (heap.size() - 2) / 2; i >= 0; i--)
            adjust(i, heap.size() - 1); // i为最后一个分支节点的下标
    }

    /**
     * 调整堆，使其满足堆的定义
     *
     * @param i 调整的元素的下标
     * @param j 调整范围的下界
     */
    private void adjust(int i, int j)
    {
        int maxChild; // 存放左右孩子中较大值的索引
        while (i <= (j - 1) >> 1)
        {
            maxChild = (i << 1) + 1; // 获取节点i的左孩子
            if (maxChild + 1 <= j && heap.get(maxChild).compareTo(heap.get(maxChild + 1)) < 0)
                maxChild += 1;  // 使child指向值较大的孩子
            if (heap.get(maxChild).compareTo(heap.get(i)) > 0)
            {
                swap(maxChild, i); // 节点i下沉
                i = maxChild; // 交换后，以child为根的子树不一定满足堆定义，所以需要接着往下开始检查
            } else break;
        }
    }

    /**
     * 把堆中的a,b位置的值互换
     *
     * @param a 在heap数组中的索引a
     * @param b 在heap数组中的索引b
     */
    private void swap(int a, int b)
    {
        T tmp = heap.get(a);
        heap.set(a, heap.get(b));
        heap.set(b, tmp);
    }

    /**
     * 节点上浮，让插入的数和父节点的数值比较，当大于父节点的时候就和父节点的值互换
     *
     * @param index 需要上浮的节点
     */
    private void heapUp(int index)
    {
        for (; index > 0; index = (index - 1) >> 1)
        {
            int parent = (index - 1) >> 1; // 获取index的父节点的下标
            if (heap.get(index).compareTo(heap.get(parent)) > 0) // 如果index值大于父节点的值
            {
                swap(parent, index); // 交换
            }
        }
    }

    /**
     * 节点下沉，删除一个堆中一个数据的时候，根据堆的性质，应该把相应的位置下移，才能保持住堆性质不变
     *
     * @param index 需要下沉的节点
     */
    private void heapDown(int index)
    {
        int maxChild = (index << 1) + 1; // 获取index的左孩子下标
        while (maxChild < heap.size() - 1)
        {
            if (maxChild + 1 < heap.size() - 2 && heap.get(maxChild).compareTo(heap.get(maxChild + 1)) < 0)
                maxChild++; // 获取index左右孩子的最大值的下标
            if (heap.get(maxChild).compareTo(heap.get(index)) > 0)
            {
                swap(maxChild, index);
                index = maxChild;
                maxChild = (index << 1) + 1;
            } else break;
        }
    }

    /**
     * 向最大堆中插入元素
     *
     * @param val 被插入的值
     */
    public void insert(T val)
    {
        heap.add(val); // 在数组的尾部添加要插入的元素
        heapUp(heap.size() - 1); // 开始上升操作
    }

    /**
     * 删除堆中位置是index的元素
     * 操作原理：当删除节点的元素时，原来的位置就会出现一个孔，填充这个孔的方法就是，把最后的叶子节点元素赋给该孔，最后把该叶子节点删除
     *
     * @param index 被删除的元素下标
     * @return 返回被删除的元素
     */
    public T delete(int index)
    {
        T del = heap.get(index);
        heap.set(index, heap.get(heap.size() - 1)); // 把最后的一个叶子节点元素赋值给index位置
        heapDown(index); // 节点下沉
        heap.remove(heap.size() - 1); // 把最后一个位置的元素删除
        return del;
    }

    /**
     * 对一个最大堆heap排序
     */
    public void heapSort()
    {
        for (int i = heap.size() - 1; i > 0; i--)
        {
            // 把根节点跟最后一个元素交换位置，调整剩下的n-1个节点，即可排好序
            swap(0, i);
            adjust(0, i - 1);
        }
    }

    /**
     * 按照常规顺序打印堆
     */
    public void print()
    {
        heap.forEach(item -> System.out.print(item + " "));
        System.out.println();
    }

    public static void main(String[] args)
    {
        List<Integer> heap = new ArrayList<>();
        Collections.addAll(heap, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        heap.forEach(item -> System.out.print(item + " "));
        System.out.println();

        MaxHeap<Integer> maxHeap = new MaxHeap<Integer>(heap);
        maxHeap.print();

        // 插入元素
        maxHeap.insert(20);
        maxHeap.print();

        // 删除元素
        maxHeap.delete(1);
        maxHeap.print();

        // 排序
        maxHeap.heapSort();
        maxHeap.print();
    }
}
