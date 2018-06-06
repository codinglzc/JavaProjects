package lintcode;

/**
 * @Description: 65. 两个排序数组的中位数
 * 两个排序的数组A和B分别含有m和n个数，找到两个排序数组的中位数，要求时间复杂度应为O(log (m+n))。
 * <p>
 * 样例:
 * 给出数组A = [1,2,3,4,5,6] B = [2,3,4,5]，中位数3.5
 * 给出数组A = [1,2,3] B = [4,5]，中位数 3
 * @Author: lc
 * @Date: Created in 2018/3/7
 */
public class _65
{
    /*
     * 二分搜索法求解，时间复杂度：O(log(min(A, B)))
     *
     * 参考：https://leetcode.com/problems/median-of-two-sorted-arrays/discuss/2471/very-concise-ologminmn-iterative-solution-with-detailed-explanation
     *
     * @param A: An integer array
     * @param B: An integer array
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B)
    {
        // write your code here
        int N1 = A.length, N2 = B.length;
        if (N1 < N2) return findMedianSortedArrays(B, A); // Make sure B is the shorter one.

        int lo = 0, hi = N2 * 2;  // 2*N2 + 1 数组的头和尾
        while (lo <= hi)
        {
            int mid2 = (lo + hi) / 2;   // Try Cut B
            int mid1 = N1 + N2 - mid2;  // Calculate Cut 1 accordingly

            double L1 = mid1 == 0 ? Integer.MIN_VALUE : A[(mid1 - 1) / 2];  //Get L1, R1, L1, R2 respectively
            double L2 = mid2 == 0 ? Integer.MIN_VALUE : B[(mid2 - 1) / 2];
            double R1 = mid1 == 2 * N1 ? Integer.MAX_VALUE : A[mid1 / 2];
            double R2 = mid2 == 2 * N2 ? Integer.MAX_VALUE : B[mid2 / 2];

            if (L1 > R2) lo = mid2 + 1;         // A's lower half is too big; need to move C1 left (C2 right)
            else if (L2 > R1) hi = mid2 - 1;    // B's lower half is too big; need to move C2 right (C1 left)
            else return (Math.max(L1, L2) + Math.min(R1, R2)) / 2;      // Otherwise, that's the right cut.
        }
        return -1;
    }
}
