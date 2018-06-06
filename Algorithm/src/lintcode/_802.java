package lintcode;

/**
 * @Description: 802. Sudoku Solver (求解数独)
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * <p>
 * Empty cells are indicated by the number 0.
 * <p>
 * You may assume that there will be only one unique solution.
 * @Author: lc
 * @Date: Created in 2018-04-08
 */
public class _802
{
    /**
     * @param board: the sudoku puzzle
     * @return: nothing
     */
    public int solveSudoku(char[][] board)
    {
        // write your code here
        dfs(board, 0, 0);
        return 1;
    }

    public boolean dfs(char[][] board, int i, int j)
    {
        if (i == 9) return true;
        if (j == 9) return dfs(board, i + 1, 0);
        if (board[i][j] != '0') return dfs(board, i, j + 1);

        for (char val = '1'; val <= '9'; val++)
        {
            if (isValid(board, i, j, val))
            {
                board[i][j] = val;
                if (dfs(board, i, j + 1)) return true;
                board[i][j] = '0';
            }
        }

        return false;
    }

    public boolean isValid(char[][] board, int i, int j, char val)
    {
        for (int t = 0; t < 9; t++) if (board[i][t] == val || board[t][j] == val) return false;

        int row = i - i % 3;
        int col = j - j % 3;
        for (int x = 0; x < 3; x++)
        {
            for (int y = 0; y < 3; y++)
            {
                if (board[row + x][col + y] == val) return false;
            }
        }
        return true;
    }
}
