package jianzhioffer.topic29;

/**
 * <p>
 * 面试题29：顺时针打印矩阵（P.161）
 * 题目：输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * </p>
 *
 * @author Liu Cong
 * @since 2018-07-11
 */
public class PrintMatrix
{
    public static void printMatrixClockwisely(int[][] nums)
    {
        if (nums == null || nums.length <= 0 || nums[0].length <= 0) return;

        for (int i = 0; i <= (Math.min(nums.length, nums[0].length) - 1) / 2; i++)
            printMatrixInCircle(nums, i);
    }

    private static void printMatrixInCircle(int[][] nums, int start)
    {
        int endRow = nums.length - 1 - start;
        int endCol = nums[0].length - 1 - start;

        // 从左到右打印一行
        for (int i = start; i <= endCol; i++)
        {
            System.out.print(nums[start][i] + " ");
        }

        // 从上到下打印一列
        if (start < endRow)
        {
            for (int i = start + 1; i <= endRow; i++)
            {
                System.out.print(nums[i][endCol] + " ");
            }
        }

        // 从右到左打印一行
        if (start < endRow && start < endCol)
        {
            for (int i = endCol - 1; i >= start; i--)
            {
                System.out.print(nums[endRow][i] + " ");
            }
        }

        // 从下到上打印一列
        if (start < endCol && start < endRow - 1)
        {
            for (int i = endRow - 1; i >= start + 1; i--)
            {
                System.out.print(nums[i][start] + " ");
            }
        }
    }

    public static void main(String[] args)
    {
        printMatrixClockwisely(new int[][]
                {
                        {1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12},
                        {13, 14, 15, 16},
                }
        );
        System.out.println();
        printMatrixClockwisely(new int[][]
                {
                        {1, 2, 3},
                        {5, 6, 7},
                        {9, 10, 11},
                        {13, 14, 15},
                }
        );
        System.out.println();
        printMatrixClockwisely(new int[][]
                {
                        {1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12},
                }
        );
        System.out.println();
        printMatrixClockwisely(new int[][]
                {
                        {1, 2, 3},
                        {5, 6, 7},
                        {9, 10, 11},
                }
        );
        System.out.println();
    }
}
