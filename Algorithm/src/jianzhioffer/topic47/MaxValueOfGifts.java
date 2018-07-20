package jianzhioffer.topic47;

/**
 * <p>
 * 面试题47：礼物的最大价值（P.233）
 * 题目：在一个 m * n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次
 * 向右或者向下移动一格，直到达到棋盘的右下角。给定一个棋盘及其上面的礼物，请计算你最多能拿到多少价值的礼物？
 * </p>
 *
 * @author Liu Cong
 * @since 2018-07-14
 */
public class MaxValueOfGifts
{
    /**
     * 动态规划
     * 公式：f(i,j) = max(f(i-1,j), f(i,j-1)) + gift[i.j]
     * <p>
     * 由于有大量重复的计算，所有不能用递归。基于循环的代码效率要高很多。为了缓存中间计算结果，需要一个辅助的二维数组。
     */
    public static int getMaxValueSolution1(int[][] nums)
    {
        if (nums == null || nums.length <= 0 || nums[0].length <= 0) return 0;

        int[][] maxValue = new int[nums.length][nums[0].length];

        for (int i = 0; i < nums.length; i++)
        {
            for (int j = 0; j < nums[0].length; j++)
            {
                int left = 0;
                int up = 0;
                if (i > 0)
                    up = maxValue[i - 1][j];
                if (j > 0)
                    left = maxValue[i][j - 1];
                maxValue[i][j] = Math.max(up, left) + nums[i][j];
            }
        }

        return maxValue[nums.length - 1][nums[0].length];
    }

    /**
     * 相比solution1，节省了空间
     */
    public static int getMaxValueSolution2(int[][] nums)
    {
        if (nums == null || nums.length <= 0 || nums[0].length <= 0) return 0;

        int[] rowMaxValue = new int[nums[0].length];
        for (int i = 0; i < nums.length; i++)
        {
            for (int j = 0; j < nums[0].length; j++)
            {
                int left = 0;
                int up = 0;
                if (i > 0)
                    up = rowMaxValue[j];
                if (j > 0)
                    left = rowMaxValue[j - 1];
                rowMaxValue[j] = Math.max(up, left) + nums[i][j];
            }
        }
        return rowMaxValue[rowMaxValue.length - 1];
    }
}
