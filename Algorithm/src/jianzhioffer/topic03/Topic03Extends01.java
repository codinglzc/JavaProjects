package jianzhioffer.topic03;

/**
 * @description: 衍生题目：不修改数组找出重复的数字。（P. 41）
 * 在一个长度为 n+1 的数组里的所有的数字都在 1~n 的范围内，所以数组中至少有一个数字是重复的。请找出数组中任意一个重复的数字，但不能修改
 * 输入的数字。例如，如果输入长度为 8 的数组{2,3,5,4,3,2,6,7}，那么对应的输出是重复的数字 2 或者 3。
 * @author: Liu Cong
 * @create: Created at 2018-06-11
 */
public class Topic03Extends01
{
    /**
     * 法1：使用 Topic03中的哈希表的方法可以解决，但是需要额外的O(n)存储空间。
     */

    /**
     * 法2
     * <p>
     * 分析：假如没有重复的数字，那么在从 1~n 的范围里只有 n 个数字。由于数组里包含超过 n 个数字，所以一定包含了重复的数字。看起来在某
     * 范围里数字的个数对解决这个问题很重要。
     * <p>
     * 步骤：我们把从 1~n 的数字从中间的数字 m 分为两部分，前面一半为 1~m，后面一半为 m+1~n。如果 1~m 的数字的数目超过 m，那么这一半
     * 的区间里一定包含重复的数字；否则，另一半 m+1~n 的区间里一定包含重复的数字。我们可以继续把包含重复数字的区间一分为二，直到找到一
     * 个重复的数字。这个过程和二分查找算法很类似，只是多了一步统计区间里数字的数目。
     * <p>
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(1)
     * <p>
     * 评价：这种算法不能保证找出所有重复的数字。
     * <p>
     * 总结：如果题目提出不同的功能要求（找出任意一个重复的数字、找出所有重复的数字）或者性能要求（时间效率优先、空间效率优先），那么我们
     * 最终选取的算法也将不同。
     *
     * @param nums 输入数组
     * @return 如果找到重复数字则返回其中一个；反之返回-1。
     */
    public static int solution(int[] nums)
    {
        if (nums == null || nums.length <= 0) return -1;
        for (int num : nums) if (num < 1 || num >= nums.length) return -1;

        int start = 1, end = nums.length - 1;
        while (start <= end)
        {
            int mid = start + (end - start) >> 1;
            // 计算在[start, mid]区间的个数
            int count = 0;
            for (int num : nums)
            {
                if (start <= num && num <= mid) count++;
            }

            if (start == end)
            {
                if (count > 1) return start;
                else break;
            }

            if (count > (mid - start + 1))
                end = mid;
            else
                start = mid + 1;
        }
        return -1;
    }
}
