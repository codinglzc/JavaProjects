package leetcode.array;

/**
 * @Description: 766. Toeplitz Matrix
 * A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.
 * <p>
 * Now given an M x N matrix, return True if and only if the matrix is Toeplitz.
 * <p>
 * Example 1:
 * <p>
 * Input: matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
 * Output: True
 * Explanation:
 * 1234
 * 5123
 * 9512
 * <p>
 * In the above grid, the diagonals are "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]", and in each diagonal
 * all elements are the same, so the answer is True.
 * <p>
 * Example 2:
 * <p>
 * Input: matrix = [[1,2],[2,2]]
 * Output: False
 * Explanation:
 * The diagonal "[1, 2]" has different elements.
 * <p>
 * Note:
 * <p>
 * 1. `matrix` will be a 2D array of integers.
 * 2. `matrix` will have a number of rows and columns in range [1, 20].
 * 3. `matrix[i][j]` will be integers in range [0, 99].
 * @Author: lc
 * @Date: Created in 2018/3/3
 */
public class _766
{
    public boolean isToeplitzMatrix(int[][] matrix)
    {
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[0].length; j++)
            {
                if (i > 0 && j > 0 && matrix[i - 1][j - 1] != matrix[i][j])
                    return false;
            }
        }
        return true;
    }

}
