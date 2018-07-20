package jianzhioffer.topic04;

/**
 * @description: 面试题4：二维数组中的查找（P.44）
 * 题目：在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个方法，输入这样的一个二维数组
 * 和一个整数，判断数组中是否含有该整数。
 * @author: Liu Cong
 * @create: Created at 2018-06-11
 */
public class FindInPartiallySortedMatrix
{
    /**
     * 首先选取数组中右上角的数字。如果该数字等于要查找的数字，则查找过程结束；如果该数字大于要查找的数字，则剔除这个数字所在的列；如果
     * 该数字小于要查找的数字，则剔除这个数字所在的行。也就是说，如果要查找的数字不在数组的右上角，则每一次都在数组的查找范围中剔除一行
     * 或者一列，这样每一步都可以缩小查找的范围，直到找到要查找的数字，或者查找范围为空。
     * <p>
     * 时间复杂度：O(2n)
     * 空间复杂度：O(1)
     *
     * @param nums   输入的二维数组
     * @param target 需要查找的数字
     * @return 如果找到，则返回true；反之，返回false。
     */
    public static boolean solution(int[][] nums, int target)
    {
        if (nums == null || nums.length <= 0) return false;

        int rows = nums.length, cols = nums[0].length;
        int row = 0, col = cols - 1;  // 从右上角开始
        while (row < rows && col >= 0)
        {
            if (nums[row][col] == target) return true;
            else if (nums[row][col] > target) col--;
            else row++;
        }
        return false;
    }
}
