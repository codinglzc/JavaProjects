package leetcode.array;

import java.util.Arrays;

/**
 * @Description: 561. Array Partition I
 * Given an array of 2n integers, your task is to group these integers into n pairs of integer,
 * say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
 * <p>
 * Example 1:
 * Input: [1,4,3,2]
 * Output: 4
 * Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
 * <p>
 * Note:
 * n is a positive integer, which is in the range of [1, 10000].
 * All the integers in the array will be in the range of [-10000, 10000].
 * @Author: lc
 * @Date: Created in 2017/12/11
 */
public class _561
{
    /*
     * 这道题让我们分割数组，两两一对，让每对中较小的数的和最大。这题难度不大，用贪婪算法就可以了。由于我们要最大化每对中的较小值之和，
     * 那么肯定是每对中两个数字大小越接近越好，因为如果差距过大，而我们只取较小的数字，那么大数字就浪费掉了。明白了这一点，我们只需要给
     * 数组排个序，然后按顺序的每两个就是一对，我们取出每对中的第一个数即为较小值累加起来即可
     */
    public int arrayPairSum(int[] nums)
    {
        // 对指定的 int 型数组按数字升序进行排序。该排序算法是一个经过调优的快速排序法，改编自 Jon L. Bentley 和 M. Douglas McIlroy
        // 合著的 Engineering a Sort Function", Software-Practice and Experience Vol. 23(11) P. 1249-1265 (November 1993)。
        // 此算法在许多数据集上提供 n*log(n) 性能，这导致其他快速排序会降低二次型性能。
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2)
        {
            sum += nums[i];
        }
        return sum;
    }
}
