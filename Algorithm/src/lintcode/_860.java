package lintcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 860. Number of Distinct Islands
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected
 * 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 * <p>
 * Count the number of distinct islands. An island is considered to be the same as another if and only if one island
 * can be translated (and not rotated or reflected) to equal the other.
 * <p>
 * Notice that:
 * 11
 * 1
 * and
 * 1
 * 11
 * are considered different island shapes, because we do not consider reflection / rotation.
 * <p>
 * 注意事项
 * The length of each dimension in the given grid does not exceed 50.
 * <p>
 * 样例：
 * Given grid =
 * [
 * [1,1,0,0,0],
 * [1,1,0,0,0],
 * [0,0,0,1,1],
 * [0,0,0,1,1]
 * ]
 * return 1
 * Given grid =
 * [
 * [1,1,0,1,1],
 * [1,0,0,0,0],
 * [0,0,0,0,1],
 * [1,1,0,1,1]
 * ]
 * return 3
 * @Author: lc
 * @Date: Created in 2018-04-24
 */
public class _860
{
    /**
     * @param grid: a list of lists of integers
     * @return: return an integer, denote the number of distinct islands
     */
    public int numberofDistinctIslands(int[][] grid)
    {
        // write your code here
        if (grid.length <= 0 || grid[0].length <= 0) return 0;

        Set<String> res = new HashSet<>();
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[0].length; j++)
            {
                if (grid[i][j] == 1)
                {
                    String s = dfs(grid, i, j, i, j);
                    res.add(s);
                }
            }
        }

        return res.size();
    }

    public String dfs(int[][] grid, int x0, int y0, int x, int y)
    {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0) return "";

        String res = "(" + (x - x0) + "," + (y - y0) + ")";
        grid[x][y] = 0;

        res += dfs(grid, x0, y0, x - 1, y);
        res += dfs(grid, x0, y0, x, y - 1);
        res += dfs(grid, x0, y0, x + 1, y);
        res += dfs(grid, x0, y0, x, y + 1);

        return res;
    }
}
