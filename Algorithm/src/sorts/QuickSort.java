package sorts;

import java.util.Arrays;

/**
 * @Description: 快速排序
 * 1、基本思想：
 * 实现快速排序算法的关键在于先在数组中选择一个数字，接下来把数组中的数字分为两部分，比选择的数字小的数字移到数组的左边，比选择的数字大的
 * 数字移到数组的右边。
 * <p>
 * 2、实现思路：
 * 1) 以第一个关键字 K 1 为控制字，将 [K 1 ,K 2 ,…,K n ] 分成两个子区，使左区所有关键字小于等于 K 1 ，右区所有关键字大于等于 K 1 ，
 * 最后控制字居两个子区中间的适当位置。在子区内数据尚处于无序状态。
 * 2) 把左区作为一个整体，用1的步骤进行处理，右区进行相同的处理。（即递归）
 * 3) 重复第1、2步，直到左区处理完毕。
 * <p>
 * 3、性能分析：
 * 时间复杂度一般为O(N*logN)，最坏为O(N*N)。
 * 快速排序虽然总体的平均效率是最好的，但也不是任何时候都是最优的算法。比如数组是倒序排列的，而每一轮排序的时候都以第一个数字作为比较
 * 的标准，此时快速排序的效率只有O(n²)。
 * @Author: lc
 * @Date: Created in 2018-04-17
 */
public class QuickSort
{
    public static void quickSort(int[] arr, int start, int end)
    {
        if (start > end) return;

        // 分割点
        int mid = partition(arr, start, end);
        System.out.println(Arrays.toString(arr));

        // 递归左子数组
        quickSort(arr, start, mid - 1);

        // 递归右子数组
        quickSort(arr, mid + 1, end);
    }

    private static int partition(int[] arr, int start, int end)
    {
        int midVal = arr[start];

        while (start < end)
        {
            // 先从右边开始查找第一个比 midVal 小的数，然后把其赋值给arr[start]
            while (start < end && arr[end] >= midVal) end--;

            if (start < end) arr[start++] = arr[end];

            // 再从左边开始查找第一个比 midVal 大的数，然后把其赋值给arr[end]
            while (start < end && arr[start] <= midVal) start++;

            if (start < end) arr[end--] = arr[start];
        }

        // 此时 start == end
        arr[start] = midVal;

        return start;
    }

    public static void main(String[] args)
    {
        int a[] = {51, 46, 20, 18, 65, 97, 82, 30, 77, 50};
        quickSort(a, 0, a.length - 1);
        System.out.println("排序结果：" + Arrays.toString(a));
    }
}
