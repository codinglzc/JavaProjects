package jianzhioffer.topic13;

/**
 * @description: 面试题13：机器人的运动范围
 * 题目：地上有一个 m 行 n 列的方格。一个机器人从坐标(0, 0)的格子开始移动，它每次可以向左、右、上、下移动一格，但不能进入行坐标和列坐标
 * 的数位之和大于 k 的格子。例如，当 k 为 18 时，机器人能够进入方格 (35, 37)，因为 3+5+3+7=18 。但它不能进入方格 (35, 38)，因为
 * 3+5+3+8=19 。请问该机器人能够到达多少个格子？
 * @author: Liu Cong
 * @create: Created at 2018-06-20
 */
public class RobotMove
{
    /**
     * 同topic12，采用回朔法求解
     *
     * @param threshold k
     * @param rows      行数
     * @param cols      列数
     * @return 机器人能够到达的格子数
     */
    public static int solution1(int threshold, int rows, int cols)
    {
        if (threshold < 0 || rows <= 0 || cols <= 0) return 0;

        boolean[][] isVisited = new boolean[rows][cols];

        return movingCountCore(threshold, rows, cols, 0, 0, isVisited);
    }

    private static int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[][] isVisited)
    {
        int count = 0;
        if (check(threshold, rows, cols, row, col, isVisited))
        {
            isVisited[row][col] = true;

            count = 1 + movingCountCore(threshold, rows, cols, row + 1, col, isVisited)
                    + movingCountCore(threshold, rows, cols, row - 1, col, isVisited)
                    + movingCountCore(threshold, rows, cols, row, col + 1, isVisited)
                    + movingCountCore(threshold, rows, cols, row, col - 1, isVisited);
        }
        return count;
    }

    /**
     * 判断机器人能否进入坐标(row, col)的方格
     */
    private static boolean check(int threshold, int rows, int cols, int row, int col, boolean[][] isVisited)
    {
        return row >= 0 && row < rows && col >= 0 && col < cols
                && getDigitSum(row) + getDigitSum(col) <= threshold && !isVisited[row][col];
    }

    /**
     * 得到一个数字的数位之和
     */
    private static int getDigitSum(int num)
    {
        int sum = 0;
        while (num > 0)
        {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
