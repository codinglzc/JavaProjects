package lintcode;

/**
 * @Description: 477. 被围绕的区域
 * 给一个二维的矩阵，包含 'X' 和 'O', 找到所有被 'X' 围绕的区域，并用 'X' 填充满。
 * <p>
 * 样例：
 * 给出二维矩阵：
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 把被 'X' 围绕的区域填充之后变为：
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * @Author: lc
 * @Date: Created in 2018-04-11
 */
public class _477
{
    /**
     * @param board a 2D board containing 'X' and 'O'
     * @return void
     */
    public void surroundedRegions(char[][] board)
    {
        // Write your code here
        if (board.length <= 2 || board[0].length <= 2) return;

        int row = board.length;
        int col = board[0].length;

        for (int i = 0; i < row; i++)
        {
            if (board[i][0] == 'O') search(board, i, 0);
            if (board[i][col - 1] == 'O') search(board, i, col - 1);
        }

        for (int i = 0; i < col; i++)
        {
            if (board[0][i] == 'O') search(board, 0, i);
            if (board[row - 1][i] == 'O') search(board, row - 1, i);
        }

        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                if (board[i][j] == '*') board[i][j] = 'O';
                else board[i][j] = 'X';
            }
        }
    }

    public void search(char[][] board, int x, int y)
    {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) return;

        if (board[x][y] == 'X' || board[x][y] == '*') return;

        board[x][y] = '*';

        search(board, x + 1, y);
        search(board, x - 1, y);
        search(board, x, y + 1);
        search(board, x, y - 1);
    }
}
