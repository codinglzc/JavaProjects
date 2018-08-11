package sorts;

import java.util.Arrays;

/**
 * @Description: 归并排序
 * 归并排序（Merge）是将两个（或两个以上）有序表合并成一个新的有序表，即把待排序序列分为若干个子序列，每个子序列是有序的。
 * 然后再把有序子序列合并为整体有序序列。
 * <p>
 * 归并排序是建立在归并操作上的一种有效的排序算法。该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。
 * 将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序表，称为2-路归并。
 * <p>
 * 归并排序算法稳定，数组需要O(n)的额外空间，链表需要O(log(n))的额外空间，时间复杂度为O(nlog(n))，算法不是自适应的，不需要对数据的随机读取。
 * <p>
 * 工作原理：
 * 1、申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列
 * 2、设定两个指针，最初位置分别为两个已经排序序列的起始位置
 * 3、比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置
 * 4、重复步骤3直到某一指针达到序列尾
 * 5、将另一序列剩下的所有元素直接复制到合并序列尾
 * @Author: lc
 * @Date: Created in 2018-04-17
 */
public class MergeSort
{
    public static void mergeSort(int[] arr, int start, int end)
    {
        if (start >= end) return;

        int mid = (start + end) / 2;

        // 子左边
        mergeSort(arr, start, mid);

        // 子右边
        mergeSort(arr, mid + 1, end);

        // 合并
        merge(arr, start, mid, end);

        System.out.println(Arrays.toString(arr));
    }

    private static void merge(int[] arr, int start, int mid, int end)
    {
        // 辅助数组，临时存储合并后的数组
        int[] tmp = new int[end - start + 1];
        // 左子数组和右子数组的起点索引
        int left = start, right = mid + 1;
        int index = 0;
        while (left <= mid && right <= end)
        {
            // 比较左子数组和右子数组当前索引的值，把较小的值放入辅助数组tmp中
            if (arr[left] < arr[right])
            {
                tmp[index++] = arr[left++];
            } else
            {
                tmp[index++] = arr[right++];
            }
        }

        // 把左子数组或右子数组剩下部分放入辅助数组tmp中
        while (left <= mid)
        {
            tmp[index++] = arr[left++];
        }

        while (right <= end)
        {
            tmp[index++] = arr[right++];
        }

        // 将合并后的辅助数组tmp复制到原数组arr中
        System.arraycopy(tmp, 0, arr, start, tmp.length);
    }

    public static void main(String[] args)
    {
        int a[] = {51, 46, 20, 18, 65, 97, 82, 30, 77, 50};
        mergeSort(a, 0, a.length - 1);
        System.out.println("排序结果：" + Arrays.toString(a));
    }

}
