package lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 778. Pacific Atlantic Water Flow
 * Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, the "Pacific
 * ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.
 * <p>
 * Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.
 * <p>
 * Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.
 * <p>
 * 注意事项：
 * 1.The order of returned grid coordinates does not matter.
 * 2.Both m and n are less than 150.
 * <p>
 * 样例：
 * Given the following 5x5 matrix:
 * <p>
 * Pacific ~   ~   ~   ~   ~
 * ~  1   2   2   3  (5) *
 * ~  3   2   3  (4) (4) *
 * ~  2   4  (5)  3   1  *
 * ~ (6) (7)  1   4   5  *
 * ~ (5)  1   1   2   4  *
 * *   *   *   * Atlantic
 * <p>
 * Return:
 * [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).
 * @Author: lc
 * @Date: Created in 2018-04-02
 */
public class _778
{
    /**
     * @param matrix: the given matrix
     * @return: The list of grid coordinates
     */
    public List<List<Integer>> pacificAtlantic(int[][] matrix)
    {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if (matrix.length < 1) return res;

        boolean[][] flags1 = new boolean[matrix.length][matrix[0].length];
        boolean[][] isCheck1 = new boolean[matrix.length][matrix[0].length];
        boolean[][] flags2 = new boolean[matrix.length][matrix[0].length];
        boolean[][] isCheck2 = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++)
        {
            dfs(matrix, flags1, isCheck1, i, 0);
            dfs(matrix, flags2, isCheck2, i, matrix[0].length - 1);
        }
        for (int j = 0; j < matrix[0].length; j++)
        {
            dfs(matrix, flags1, isCheck1, 0, j);
            dfs(matrix, flags2, isCheck2, matrix.length - 1, j);
        }
        for (int i = 0; i < flags1.length; i++)
        {
            for (int j = 0; j < flags1[0].length; j++)
            {
                if (flags1[i][j] && flags2[i][j])
                {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    res.add(temp);
                }
            }
        }
        return res;
    }

    public void dfs(int[][] matrix, boolean[][] flags, boolean[][] isCheck, int x, int y)
    {
        if (!isCheck[x][y])
        {
            isCheck[x][y] = true;
            flags[x][y] = true;
            if (x >= 1 && matrix[x - 1][y] >= matrix[x][y]) dfs(matrix, flags, isCheck, x - 1, y);
            if (x < matrix.length - 1 && matrix[x + 1][y] >= matrix[x][y]) dfs(matrix, flags, isCheck, x + 1, y);
            if (y >= 1 && matrix[x][y - 1] >= matrix[x][y]) dfs(matrix, flags, isCheck, x, y - 1);
            if (y < matrix[0].length - 1 && matrix[x][y + 1] >= matrix[x][y]) dfs(matrix, flags, isCheck, x, y + 1);
        }
    }
}
