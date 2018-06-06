package leetcode.array;

/**
 * @Description: 695. Max Area of Island
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected
 * 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 * <p>
 * Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)
 * <p>
 * Example 1:
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,1,1,0,1,0,0,0,0,0,0,0,0],
 * [0,1,0,0,1,1,0,0,1,0,1,0,0],
 * [0,1,0,0,1,1,0,0,1,1,1,0,0],
 * [0,0,0,0,0,0,0,0,0,0,1,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
 * <p>
 * Example 2:
 * [[0,0,0,0,0,0,0,0]]
 * Given the above grid, return 0.
 * <p>
 * Note: The length of each dimension in the given grid does not exceed 50.
 * @Author: lc
 * @Date: Created in 2018/2/27
 */
public class _695
{
    public int maxAreaOfIsland(int[][] grid)
    {
        int max = 0;
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[0].length; j++)
            {
                if (grid[i][j] == 1)
                {
                    max = Math.max(max, getCurMax(grid, i, j));
                }
            }
        }
        return max;
    }

    public int getCurMax(int[][] grid, int i, int j)
    {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1)
        {
            grid[i][j] = 0;
            return 1 + getCurMax(grid, i + 1, j) + getCurMax(grid, i - 1, j) + getCurMax(grid, i, j + 1) + getCurMax(grid, i, j - 1);
        }
        return 0;
    }
}
